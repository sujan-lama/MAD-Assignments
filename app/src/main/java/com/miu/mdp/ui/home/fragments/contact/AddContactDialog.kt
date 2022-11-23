package com.miu.mdp.ui.home.fragments.contact

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import com.miu.mdp.R
import com.miu.mdp.databinding.DialogAddContactBinding
import com.miu.mdp.domain.model.Contact
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddContactDialog : DialogFragment() {

    companion object {
        const val TAG = "AddContactDialog"
        fun newInstance(
            email: String,
            contact: Contact? = null
        ): AddContactDialog {
            val args = Bundle()
            args.putString("email", email)
            args.putParcelable("contact", contact)
            val fragment = AddContactDialog()
            fragment.arguments = args
            return fragment
        }
    }

    private var _binding: DialogAddContactBinding? = null
    private val binding get() = _binding!!

    private var email: String = ""

    private val viewModel: ContactViewModel by activityViewModels()
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
        _binding = DialogAddContactBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val contactDTO = arguments?.getParcelable<Contact>("contact")
        contactDTO?.let {
            binding.phoneEditText.setText(it.phone)
            binding.emailEditText.setText(it.email)
            binding.linkedInEditText.setText(it.linkedIn)
            binding.githubEditText.setText(it.github)
            binding.pdfEditText.setText(it.pdf)
            binding.addContactButton.text = "Update Contact"
        }

        viewModel.addContactState.observe(viewLifecycleOwner) {
            when (it) {
                is AddContactState.Success -> {
                    binding.progressBar.visibility = View.GONE
                    binding.addContactButton.visibility = View.VISIBLE
                    Toast.makeText(requireContext(), "Contact added", Toast.LENGTH_SHORT)
                        .show()
                    viewModel.getContact(email)
                    dismiss()
                }
                is AddContactState.Error -> {
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
                    binding.progressBar.visibility = View.GONE
                    binding.addContactButton.visibility = View.VISIBLE
                }
                is AddContactState.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                    binding.addContactButton.visibility = View.GONE
                }
                else -> {
                    binding.progressBar.visibility = View.GONE
                    binding.addContactButton.visibility = View.VISIBLE
                }
            }
        }

        binding.closeImageView.setOnClickListener {
            dismiss()
        }

        binding.addContactButton.setOnClickListener {
            val phoneValue = binding.phoneEditText.text.toString()
            val emailValue = binding.emailEditText.text.toString()
            val linkedinValue = binding.linkedInEditText.text.toString()
            val githubValue = binding.githubEditText.text.toString()
            val pdfValue = binding.pdfEditText.text.toString()

            if (phoneValue.isEmpty() || emailValue.isEmpty() || linkedinValue.isEmpty() || pdfValue.isEmpty() || githubValue.isEmpty()) {
                Toast.makeText(requireContext(), "Please fill all fields", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            }
            val contact = Contact(
                phone = phoneValue,
                email = emailValue,
                linkedIn = linkedinValue,
                github = githubValue,
                pdf = pdfValue
            )

            if (contactDTO == null) {
                viewModel.addContact(contact, email)
            } else {
                viewModel.updateContact(contact, email)
            }
        }
    }

}