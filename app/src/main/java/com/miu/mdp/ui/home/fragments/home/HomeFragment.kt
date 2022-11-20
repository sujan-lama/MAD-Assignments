package com.miu.mdp.ui.home.fragments.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.text.bold
import androidx.core.text.buildSpannedString
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.miu.mdp.R
import com.miu.mdp.databinding.FragmentHomeBinding
import com.miu.mdp.utils.setImageUrl
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    companion object {
        const val TAG = "HomeFragment"
        fun newInstance(email: String): HomeFragment {
            val fragment = HomeFragment()
            val bundle = Bundle()
            bundle.putString("email", email)
            fragment.arguments = bundle
            return fragment
        }
    }

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val viewModel: HomeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val email = arguments?.getString("email") ?: ""
        viewModel.getHomeData(email)
        viewModel.homeDataLiveData.observe(viewLifecycleOwner) {
            if (it == null) return@observe
            val user = it.userDTO
            binding.userName.text = "${user.firstName} ${user.lastName}"
            binding.email.text = user.username
            val userDetail = it.userDetailDTO
            binding.profileImage.setImageUrl(userDetail.image)
            binding.position.text = userDetail.position
            binding.careerNote.text = userDetail.careerNote
            setWorkExperienceLayout(userDetail.experienceMap)
        }
    }

    private fun setWorkExperienceLayout(experienceMap: HashMap<String, List<String>>) {
        val workExperienceLayout = binding.workExperienceLayout
        workExperienceLayout.removeAllViews()
        experienceMap.forEach { (key, value) ->
            val textView = TextView(requireContext())
            textView.setTextColor(ContextCompat.getColor(requireContext(), R.color.text_color))
            textView.textSize = 16f
            textView.text = buildSpannedString {
                bold { append("$key : ") }
                append(value.joinToString(", "))
            }
            workExperienceLayout.addView(textView)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}