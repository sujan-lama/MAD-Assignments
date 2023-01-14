package com.miu.mdp.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.PopupMenu
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.miu.mdp.R
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

            val popupMenu = PopupMenu(binding.root.context, binding.menu)
            popupMenu.menuInflater.inflate(R.menu.menu_work, popupMenu.menu)
            popupMenu.setOnMenuItemClickListener {
                when (it.itemId) {
                    R.id.action_edit -> {
                        listener.onEditClick(item)
                        true
                    }
                    R.id.action_delete -> {
                        listener.onDeleteClick(item)
                        true
                    }
                    else -> false
                }
            }
            binding.menu.setOnClickListener {
                popupMenu.show()
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
        fun onEditClick(experience: Experience)
    }
}