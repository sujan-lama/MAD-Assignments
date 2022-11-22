package com.miu.mdp.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.PopupMenu
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.miu.mdp.R
import com.miu.mdp.databinding.ItemWorkExperienceBinding
import com.miu.mdp.domain.model.ExperienceDTO
import com.miu.mdp.utils.setImageUrl

class WorkAdapter(private val listener: OnItemClickListener) :
    ListAdapter<ExperienceDTO, WorkAdapter.ViewHolder>(DiffCallback()) {

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

    fun updateList(list: List<ExperienceDTO>) = submitList(list)


    inner class ViewHolder(private val binding: ItemWorkExperienceBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ExperienceDTO) {
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

    class DiffCallback : DiffUtil.ItemCallback<ExperienceDTO>() {
        override fun areItemsTheSame(oldItem: ExperienceDTO, newItem: ExperienceDTO) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: ExperienceDTO, newItem: ExperienceDTO) =
            oldItem == newItem
    }

    interface OnItemClickListener {
        fun onDeleteClick(experienceDTO: ExperienceDTO)
        fun onEditClick(experienceDTO: ExperienceDTO)
    }
}