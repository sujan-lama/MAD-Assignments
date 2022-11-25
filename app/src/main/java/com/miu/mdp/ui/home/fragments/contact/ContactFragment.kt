package com.miu.mdp.ui.home.fragments.contact

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.miu.mdp.databinding.FragmentContactBinding
import com.miu.mdp.domain.model.Contact
import com.miu.mdp.utils.startEmailIntent
import com.miu.mdp.utils.startPhoneIntent
import com.miu.mdp.utils.startWebIntent
import com.miu.mdp.utils.startWebView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ContactFragment : Fragment() {

    companion object {
        const val TAG = "ContactFragment"
        fun newInstance(email: String): ContactFragment {
            val fragment = ContactFragment()
            val args = Bundle()
            args.putString("email", email)
            fragment.arguments = args
            return fragment
        }
    }

    private var _binding: FragmentContactBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ContactViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentContactBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val email = arguments?.getString("email") ?: ""
        viewModel.getContact(email)
        binding.edit.setOnClickListener {
            val dialog = AddContactDialog.newInstance(email, binding.contact)
            dialog.show(parentFragmentManager, AddContactDialog.TAG)
        }
        binding.fabAddContact.setOnClickListener {
            val dialog = AddContactDialog.newInstance(email)
            dialog.show(parentFragmentManager, AddContactDialog.TAG)
        }
        viewModel.contactLiveData.observe(viewLifecycleOwner) {
            if (it == null) {
                binding.cardContact.visibility = View.GONE
                binding.fabAddContact.visibility = View.VISIBLE
                return@observe
            }
            binding.fabAddContact.visibility = View.GONE
            binding.cardContact.visibility = View.VISIBLE
            binding.contact = it
            setListener(it)
        }
    }

    private fun setListener(contact: Contact) {
        binding.phoneLayout.root.setOnClickListener {
            contact.phone.startPhoneIntent(requireContext())
        }
        binding.emailLayout.root.setOnClickListener {
            contact.email.startEmailIntent(requireContext())
        }
        binding.linkedinLayout.root.setOnClickListener {
            contact.getLinkedInUrl().startWebView(requireContext())
        }

        binding.githubLayout.root.setOnClickListener {
            contact.getGithubUrl().startWebView(requireContext())
        }
        binding.pdfLayout.root.setOnClickListener {
            contact.pdf.startWebView(requireContext())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}