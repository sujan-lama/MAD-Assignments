package com.miu.mdp.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.PopupMenu
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.miu.mdp.R
import com.miu.mdp.databinding.ItemEducationBinding
import com.miu.mdp.domain.model.EducationDTO
import com.miu.mdp.domain.model.ExperienceDTO
import com.miu.mdp.utils.setImageUrl

class EducationAdapter(private val listener:EducationAdapter.OnItemClickListener) : ListAdapter<EducationDTO, EducationAdapter.ViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemEducationBinding
            .inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    fun updateList(list: List<EducationDTO>) = submitList(list)


    inner class ViewHolder(private val binding: ItemEducationBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: EducationDTO) {
            binding.apply {
                schoolName.text = item.schoolName
                schoolDegree.text = item.degree
                schoolImage.setImageUrl(item.image)
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

    class DiffCallback : DiffUtil.ItemCallback<EducationDTO>() {
        override fun areItemsTheSame(oldItem: EducationDTO, newItem: EducationDTO) =
            oldItem.schoolName == newItem.schoolName

        override fun areContentsTheSame(oldItem: EducationDTO, newItem: EducationDTO) =
            oldItem == newItem
    }

    interface OnItemClickListener {
        fun onDeleteClick(educationDTO: EducationDTO)
        fun onEditClick(educationDTO: EducationDTO)
    }
}