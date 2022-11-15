package com.miu.mdp.ui.home.fragments.work

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.miu.mdp.R
import com.miu.mdp.databinding.FragmentWorkBinding
import com.miu.mdp.ui.home.adapter.WorkAdapter
import com.miu.mdp.ui.home.adapter.decorator.DividerItemDecorator
import com.miu.mdp.ui.home.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WorkFragment : Fragment() {

    companion object {
        const val TAG = "WorkFragment"
        fun newInstance(): WorkFragment {
            return WorkFragment()
        }
    }


    private var _binding: FragmentWorkBinding? = null
    private val binding get() = _binding!!

    private val viewModel: HomeViewModel by viewModels()

    private val workAdapter = WorkAdapter()

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
            AddWorkDialog.newInstance().show(childFragmentManager, AddWorkDialog.TAG)
        }
        viewModel.userDetail.observe(viewLifecycleOwner) {
            if (it == null) return@observe
            workAdapter.submitList(it.experience)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}