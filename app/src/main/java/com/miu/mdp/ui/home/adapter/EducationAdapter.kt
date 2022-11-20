package com.miu.mdp.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.miu.mdp.databinding.ItemEducationBinding
import com.miu.mdp.domain.model.EducationDTO
import com.miu.mdp.utils.setImageUrl

class EducationAdapter : ListAdapter<EducationDTO, EducationAdapter.ViewHolder>(DiffCallback()) {

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
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<EducationDTO>() {
        override fun areItemsTheSame(oldItem: EducationDTO, newItem: EducationDTO) =
            oldItem.schoolName == newItem.schoolName

        override fun areContentsTheSame(oldItem: EducationDTO, newItem: EducationDTO) =
            oldItem == newItem
    }
}