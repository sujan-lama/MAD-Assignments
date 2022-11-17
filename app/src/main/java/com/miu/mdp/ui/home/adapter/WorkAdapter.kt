package com.miu.mdp.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.miu.mdp.databinding.ItemWorkExperienceBinding
import com.miu.mdp.domain.model.Experience
import com.miu.mdp.utils.setImageUrl

class WorkAdapter(private val listener: OnItemClickListener) :
    ListAdapter<Experience, WorkAdapter.ViewHolder>(DiffCallback()) {

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


            binding.root.setOnCreateContextMenuListener { contextMenu, _, _ ->
                contextMenu.add(adapterPosition, 0, 0, "Delete").setOnMenuItemClickListener {
                    listener.onDeleteClick(item)
                    true
                }
            }
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<Experience>() {
        override fun areItemsTheSame(oldItem: Experience, newItem: Experience) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Experience, newItem: Experience) =
            oldItem == newItem
    }

    interface OnItemClickListener {
        fun onDeleteClick(experience: Experience)

    }
}