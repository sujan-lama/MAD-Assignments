package com.miu.mdp.ui.home.fragments.contact

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.miu.mdp.databinding.FragmentAboutBinding
import com.miu.mdp.databinding.FragmentContactBinding
import com.miu.mdp.databinding.FragmentHomeBinding

class ContactFragment : Fragment() {

    companion object{
        const val TAG = "ContactFragment"
        fun newInstance(): ContactFragment {
            return ContactFragment()
        }
    }

    private var _binding: FragmentContactBinding? = null
    private val binding get() = _binding!!

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
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}