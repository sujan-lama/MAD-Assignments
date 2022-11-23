package com.miu.mdp.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.PopupMenu
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.miu.mdp.R
import com.miu.mdp.databinding.ItemCertificationBinding
import com.miu.mdp.domain.model.CertificationDTO
import com.miu.mdp.utils.setImageUrl

class CertificationAdapter(private val listener: OnCertificationActionListener) :
    ListAdapter<CertificationDTO, CertificationAdapter.ViewHolder>(DiffCallback()) {

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

    fun updateList(list: List<CertificationDTO>) = submitList(list)

    inner class ViewHolder(private val binding: ItemCertificationBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: CertificationDTO) {
            binding.apply {
                certificationName.text = item.certificationName
                certificationImage.setImageUrl(item.image)
            }

            val popupMenu = PopupMenu(binding.root.context, binding.menu)
            popupMenu.menuInflater.inflate(R.menu.menu_work, popupMenu.menu)
            popupMenu.setOnMenuItemClickListener {
                when (it.itemId) {
                    R.id.action_edit -> {
                        listener.onCertificationEditClick(item)
                        true
                    }
                    R.id.action_delete -> {
                        listener.onCertificationDeleteClick(item)
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

    class DiffCallback : DiffUtil.ItemCallback<CertificationDTO>() {
        override fun areItemsTheSame(oldItem: CertificationDTO, newItem: CertificationDTO) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: CertificationDTO, newItem: CertificationDTO) =
            oldItem == newItem
    }

    interface OnCertificationActionListener {
        fun onCertificationDeleteClick(certification: CertificationDTO)
        fun onCertificationEditClick(certification: CertificationDTO)
    }
}