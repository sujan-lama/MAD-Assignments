package com.miu.mdp.ui.home.fragments.work

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import com.miu.mdp.R
import com.miu.mdp.databinding.DialogAddWorkBinding
import com.miu.mdp.domain.model.Experience
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddWorkDialog : DialogFragment() {

    companion object {
        const val TAG = "AddWorkDialog"
        fun newInstance(): AddWorkDialog {
            return AddWorkDialog()
        }
    }

    private var _binding: DialogAddWorkBinding? = null
    private val binding get() = _binding!!

    private val viewModel: WorkViewModel by viewModels()
    override fun onStart() {
        super.onStart()
        val width = (resources.displayMetrics.widthPixels * 0.85).toInt()
        dialog!!.window?.setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dialog?.window?.setBackgroundDrawableResource(R.drawable.rounded_corner);
        _binding = DialogAddWorkBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.addWorkState.observe(viewLifecycleOwner) {
            when (it) {
                is AddWorkState.Success -> {
                    binding.progressBar.visibility = View.GONE
                    binding.addWorkButton.visibility = View.VISIBLE
                    Toast.makeText(requireContext(), "Work experience added", Toast.LENGTH_SHORT)
                        .show()
                    dismiss()
                }
                is AddWorkState.Error -> {
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
                    binding.progressBar.visibility = View.GONE
                    binding.addWorkButton.visibility = View.VISIBLE
                }
                is AddWorkState.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                    binding.addWorkButton.visibility = View.GONE
                }
                is AddWorkState.Empty -> {
                    binding.progressBar.visibility = View.GONE
                    binding.addWorkButton.visibility = View.VISIBLE
                }
            }
        }

        binding.closeImageView.setOnClickListener {
            dismiss()
        }

        binding.addWorkButton.setOnClickListener {
            val companyName = binding.companyEditText.text.toString()
            val position = binding.positionEditText.text.toString()
            val startDate = binding.startDateEditText.text.toString()
            val endDate = binding.endDateEditText.text.toString()
            val companyImageUrl = binding.companyImageUrlEditText.text.toString()
            val description = binding.descriptionEditText.text.toString()

            if (companyName.isEmpty() || position.isEmpty() || startDate.isEmpty() || endDate.isEmpty() || companyImageUrl.isEmpty() || description.isEmpty()) {
                Toast.makeText(requireContext(), "Please fill all fields", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            }
            val experience = Experience(
                companyName = companyName,
                position = position,
                startDate = startDate,
                endDate = endDate,
                image = companyImageUrl,
                description = description
            )

            viewModel.addWorkExperience(experience)
        }
    }

}