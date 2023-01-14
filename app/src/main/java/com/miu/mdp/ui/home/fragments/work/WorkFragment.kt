package com.miu.mdp.ui.home.fragments.work

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.miu.mdp.R
import com.miu.mdp.databinding.FragmentWorkBinding
import com.miu.mdp.domain.model.Experience
import com.miu.mdp.ui.home.adapter.WorkAdapter
import com.miu.mdp.ui.home.adapter.decorator.DividerItemDecorator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WorkFragment : Fragment(), WorkAdapter.OnItemClickListener {

    companion object {
        const val TAG = "WorkFragment"
        fun newInstance(email: String): WorkFragment {
            val args = Bundle()
            args.putString("email", email)
            val fragment = WorkFragment()
            fragment.arguments = args
            return fragment
        }
    }


    private var _binding: FragmentWorkBinding? = null
    private val binding get() = _binding!!

    private val workViewModel: WorkViewModel by activityViewModels()

    private val workAdapter = WorkAdapter(this)
    private var email = ""
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWorkBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        email = arguments?.getString("email") ?: ""
        workViewModel.getWorkExperience(email)
        binding.workExperienceRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        //divider
        binding.workExperienceRecyclerView.addItemDecoration(
            DividerItemDecorator(
                ContextCompat.getDrawable(
                    requireContext(),
                    R.drawable.divider
                )
            )
        )
        binding.workExperienceRecyclerView.adapter = workAdapter
        binding.fabAddWork.setOnClickListener {
            if (email.isNotEmpty()) {
                val dialog = AddWorkDialog.newInstance(email)
                dialog.show(childFragmentManager, AddWorkDialog.TAG)
            }
        }
        workViewModel.workExperienceLiveDataDTO.observe(viewLifecycleOwner) {
            if (it == null) return@observe
            workAdapter.updateList(it)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onDeleteClick(experience: Experience) {
        workViewModel.removeWorkExperience(experience)
    }

    override fun onEditClick(experience: Experience) {
        val dialog = AddWorkDialog.newInstance(email, experience)
        dialog.show(childFragmentManager, AddWorkDialog.TAG)
    }
}