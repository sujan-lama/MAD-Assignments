package com.miu.mdp.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.miu.mdp.databinding.ItemCertificationBinding
import com.miu.mdp.domain.model.Certification
import com.miu.mdp.utils.setImageUrl

class CertificationAdapter :
    ListAdapter<Certification, CertificationAdapter.ViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemCertificationBinding
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

    fun updateList(list: List<Certification>) = submitList(list)

    inner class ViewHolder(private val binding: ItemCertificationBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Certification) {
            binding.apply {
                certificationName.text = item.certificationName
                certificationImage.setImageUrl(item.image)
            }
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<Certification>() {
        override fun areItemsTheSame(oldItem: Certification, newItem: Certification) =
            oldItem.certificationName == newItem.certificationName

        override fun areContentsTheSame(oldItem: Certification, newItem: Certification) =
            oldItem == newItem
    }
}