package com.miu.mdp.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.miu.mdp.databinding.ItemWorkExperienceBinding
import com.miu.mdp.domain.model.Experience
import com.miu.mdp.utils.setImageUrl

class WorkAdapter : ListAdapter<Experience, WorkAdapter.ViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemWorkExperienceBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    fun updateList(list: List<Experience>) = submitList(list)


    inner class ViewHolder(private val binding: ItemWorkExperienceBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Experience) {
            binding.apply {
                position.text = item.position
                company.text = item.companyName
                duration.text = "${item.startDate} - ${item.endDate}"
                description.text = item.description
                workExperienceImage.setImageUrl(item.image)
            }
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<Experience>() {
        override fun areItemsTheSame(oldItem: Experience, newItem: Experience) =
            oldItem.companyName == newItem.companyName

        override fun areContentsTheSame(oldItem: Experience, newItem: Experience) =
            oldItem == newItem
    }
}