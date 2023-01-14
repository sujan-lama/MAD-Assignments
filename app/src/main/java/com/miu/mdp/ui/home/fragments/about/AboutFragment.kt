package com.miu.mdp.ui.home.fragments.about

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.miu.mdp.databinding.FragmentAboutBinding
import com.miu.mdp.domain.model.Certification
import com.miu.mdp.domain.model.Education
import com.miu.mdp.ui.home.adapter.CertificationAdapter
import com.miu.mdp.ui.home.adapter.EducationAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AboutFragment : Fragment(), EducationAdapter.OnItemClickListener,
    CertificationAdapter.OnCertificationActionListener {

    companion object {
        const val TAG = "AboutFragment"
        fun newInstance(email: String): AboutFragment {
            val args = Bundle()
            args.putString("email", email)
            val fragment = AboutFragment()
            fragment.arguments = args
            return fragment
        }
    }

    private var _binding: FragmentAboutBinding? = null
    private val binding get() = _binding!!

    private val viewModel: AboutViewModel by activityViewModels()

    private val educationAdapter = EducationAdapter(this)
    private val certificationAdapter = CertificationAdapter(this)

    private var email: String = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAboutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        email = arguments?.getString("email") ?: ""
        viewModel.getAboutData(email)
        binding.educationRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.certificationRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.educationRecyclerView.adapter = educationAdapter
        binding.certificationRecyclerView.adapter = certificationAdapter

        binding.fabAddEducation.setOnClickListener {
            val dialog = AddEducationDialog.newInstance(email)
            dialog.show(parentFragmentManager, AddEducationDialog.TAG)
        }
        binding.fabAddCertification.setOnClickListener {
            val dialog = AddCertificationDialog.newInstance(email)
            dialog.show(parentFragmentManager, AddCertificationDialog.TAG)
        }

        viewModel.about.observe(viewLifecycleOwner) {
            if (it == null) return@observe
            binding.aboutMe.text = it.aboutMe
            educationAdapter.updateList(it.education)
            certificationAdapter.updateList(it.certification)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onDeleteClick(education: Education) {
        viewModel.deleteEducation(education)
    }

    override fun onEditClick(education: Education) {
        val dialog = AddEducationDialog.newInstance(email, education)
        dialog.show(parentFragmentManager, AddEducationDialog.TAG)
    }

    override fun onCertificationDeleteClick(certification: Certification) {
        viewModel.deleteCertification(certification)
    }

    override fun onCertificationEditClick(certification: Certification) {
        val dialog = AddCertificationDialog.newInstance(email, certification)
        dialog.show(parentFragmentManager, AddCertificationDialog.TAG)
    }
}