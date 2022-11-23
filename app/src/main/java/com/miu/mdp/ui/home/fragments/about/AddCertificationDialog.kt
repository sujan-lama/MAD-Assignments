package com.miu.mdp.ui.home.fragments.about

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import com.miu.mdp.R
import com.miu.mdp.databinding.DialogAddCertificationBinding
import com.miu.mdp.domain.model.CertificationDTO
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddCertificationDialog : DialogFragment() {

    companion object {
        const val TAG = "AddCertificationDialog"
        fun newInstance(
            email: String,
            certificationDTO: CertificationDTO? = null
        ): AddCertificationDialog {
            val args = Bundle()
            args.putString("email", email)
            args.putParcelable("certification", certificationDTO)
            val fragment = AddCertificationDialog()
            fragment.arguments = args
            return fragment
        }
    }

    private var _binding: DialogAddCertificationBinding? = null
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
        _binding = DialogAddCertificationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val certificationDTO = arguments?.getParcelable<CertificationDTO>("certification")
        certificationDTO?.let {
            binding.certificationNameEditText.setText(it.certificationName)
            binding.certImageUrlEditText.setText(it.image)
            binding.authorityEditText.setText(it.certificationAuthority)
            binding.expirationDateEditText.setText(it.certificationDate)
            binding.addCertificationButton.text = "Update Certification"
        }

        viewModel.addCertificationLiveData.observe(viewLifecycleOwner) {
            when (it) {
                is AddCertificationState.Success -> {
                    binding.progressBar.visibility = View.GONE
                    binding.addCertificationButton.visibility = View.VISIBLE
                    Toast.makeText(requireContext(), "Certification added", Toast.LENGTH_SHORT)
                        .show()
                    viewModel.getAboutData(email)
                    dismiss()
                }
                is AddCertificationState.Error -> {
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
                    binding.progressBar.visibility = View.GONE
                    binding.addCertificationButton.visibility = View.VISIBLE
                }
                is AddCertificationState.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                    binding.addCertificationButton.visibility = View.GONE
                }
                else -> {
                    binding.progressBar.visibility = View.GONE
                    binding.addCertificationButton.visibility = View.VISIBLE
                }
            }
        }

        binding.closeImageView.setOnClickListener {
            dismiss()
        }

        binding.addCertificationButton.setOnClickListener {
            val certificationName = binding.certificationNameEditText.text.toString()
            val authority = binding.authorityEditText.text.toString()
            val expirationDate = binding.expirationDateEditText.text.toString()
            val certImageUrl = binding.certImageUrlEditText.text.toString()

            if (certificationName.isEmpty() || authority.isEmpty() || expirationDate.isEmpty() || certImageUrl.isEmpty()) {
                Toast.makeText(requireContext(), "Please fill all fields", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            }
            val certificationDTO = CertificationDTO(
                id = certificationDTO?.id ?: 0,
                certificationName = certificationName,
                certificationAuthority = authority,
                certificationDate = expirationDate,
                image = certImageUrl,
                email = email
            )

            viewModel.addCertification(certificationDTO)
        }
    }

}