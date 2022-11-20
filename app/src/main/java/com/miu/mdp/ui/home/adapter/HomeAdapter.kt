package com.miu.mdp.ui.home.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.miu.mdp.ui.home.fragments.about.AboutFragment
import com.miu.mdp.ui.home.fragments.contact.ContactFragment
import com.miu.mdp.ui.home.fragments.home.HomeFragment
import com.miu.mdp.ui.home.fragments.work.WorkFragment

class HomeAdapter(fragmentActivity: FragmentActivity, val email: String) :
    FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int {
        return 4
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> HomeFragment.newInstance(email)
            1 -> AboutFragment.newInstance(email)
            2 -> WorkFragment.newInstance(email)
            3 -> ContactFragment.newInstance(email)
            else -> HomeFragment.newInstance(email)
        }
    }

    fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "Home"
            1 -> "About me"
            2 -> "Work"
            3 -> "Contact"
            else -> "Home"
        }
    }
}
