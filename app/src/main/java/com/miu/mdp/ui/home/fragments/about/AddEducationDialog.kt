package com.miu.mdp.ui.home.fragments.about

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import com.miu.mdp.R
import com.miu.mdp.databinding.DialogAddEducationBinding
import com.miu.mdp.domain.model.EducationDTO
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddEducationDialog : DialogFragment() {

    companion object {
        const val TAG = "AddEducationDialog"
        fun newInstance(email: String, educationDTO: EducationDTO? = null): AddEducationDialog {
            val args = Bundle()
            args.putString("email", email)
            args.putParcelable("education", educationDTO)
            val fragment = AddEducationDialog()
            fragment.arguments = args
            return fragment
        }
    }

    private var _binding: DialogAddEducationBinding? = null
    private val binding get() = _binding!!

    private var email: String = ""

    private val viewModel: AboutViewModel by activityViewModels()
    override fun onStart() {
        super.onStart()
        val width = (resources.displayMetrics.widthPixels * 0.85).toInt()
        dialog!!.window?.setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        email = arguments?.getString("email") ?: ""
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dialog?.window?.setBackgroundDrawableResource(R.drawable.rounded_corner);
        _binding = DialogAddEducationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val experienceDTO = arguments?.getParcelable<EducationDTO>("education")
        experienceDTO?.let {
            binding.schoolNameEditText.setText(it.schoolName)
            binding.degreeEditText.setText(it.degree)
            binding.startDateEditText.setText(it.startDate)
            binding.schoolImageUrlEditText.setText(it.image)
            binding.endDateEditText.setText(it.endDate)
            binding.addEducationButton.text = "Update Education"
        }

        viewModel.addEducationState.observe(viewLifecycleOwner) {
            when (it) {
                is AddEducationState.Success -> {
                    binding.progressBar.visibility = View.GONE
                    binding.addEducationButton.visibility = View.VISIBLE
                    Toast.makeText(requireContext(), "Education added", Toast.LENGTH_SHORT)
                        .show()
                    viewModel.getAboutData(email)
                    dismiss()
                }
                is AddEducationState.Error -> {
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
                    binding.progressBar.visibility = View.GONE
                    binding.addEducationButton.visibility = View.VISIBLE
                }
                is AddEducationState.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                    binding.addEducationButton.visibility = View.GONE
                }
                else -> {
                    binding.progressBar.visibility = View.GONE
                    binding.addEducationButton.visibility = View.VISIBLE
                }
            }
        }

        binding.closeImageView.setOnClickListener {
            dismiss()
        }

        binding.addEducationButton.setOnClickListener {
            val schoolName = binding.schoolNameEditText.text.toString()
            val degree = binding.degreeEditText.text.toString()
            val startDate = binding.startDateEditText.text.toString()
            val endDate = binding.endDateEditText.text.toString()
            val schoolImageUrl = binding.schoolImageUrlEditText.text.toString()

            if (schoolName.isEmpty() || degree.isEmpty() || startDate.isEmpty() || endDate.isEmpty() || schoolImageUrl.isEmpty()) {
                Toast.makeText(requireContext(), "Please fill all fields", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            }
            val educationDTO = EducationDTO(
                id = experienceDTO?.id ?: 0,
                schoolName = schoolName,
                degree = degree,
                startDate = startDate,
                endDate = endDate,
                image = schoolImageUrl,
                email = email
            )

            viewModel.addEducation(educationDTO)
        }
    }

}