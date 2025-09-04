package com.congress.app.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.congress.app.R
import com.congress.app.databinding.ItemCongressMemberBinding
import com.congress.app.db.CongressMember

class CongressMemberAdapter(
    private val onItemClick: (CongressMember) -> Unit,
    private val onEmailClick: (CongressMember) -> Unit,
    private val onCallClick: (CongressMember) -> Unit
) : ListAdapter<CongressMember, CongressMemberAdapter.CongressMemberViewHolder>(CongressMemberDiffCallback()) {
    
    class CongressMemberViewHolder(
        private val binding: ItemCongressMemberBinding,
        private val onItemClick: (CongressMember) -> Unit,
        private val onEmailClick: (CongressMember) -> Unit,
        private val onCallClick: (CongressMember) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        
        fun bind(member: CongressMember) {
            binding.memberName.text = member.getDisplayName()
            binding.memberParty.text = member.getPartyAbbreviation()
            binding.memberChamber.text = member.getChamberAbbreviation()
            binding.memberStateDistrict.text = member.getStateDistrictDisplay()
            binding.memberPhone.text = member.phoneNumber
            binding.memberEmail.text = member.email
            
            // Set party color
            val partyColor = when (member.party.lowercase()) {
                "democratic" -> binding.root.context.getColor(R.color.democrat_blue)
                "republican" -> binding.root.context.getColor(R.color.republican_red)
                "independent" -> binding.root.context.getColor(R.color.independent_green)
                else -> binding.root.context.getColor(R.color.text_secondary)
            }
            binding.memberParty.setBackgroundColor(partyColor)
            
            // Set click listeners
            binding.root.setOnClickListener { onItemClick(member) }
            binding.btnEmail.setOnClickListener { onEmailClick(member) }
            binding.btnCall.setOnClickListener { onCallClick(member) }
        }
    }
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CongressMemberViewHolder {
        val binding = ItemCongressMemberBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CongressMemberViewHolder(binding, onItemClick, onEmailClick, onCallClick)
    }
    
    override fun onBindViewHolder(holder: CongressMemberViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
    
    class CongressMemberDiffCallback : DiffUtil.ItemCallback<CongressMember>() {
        override fun areItemsTheSame(oldItem: CongressMember, newItem: CongressMember): Boolean {
            return oldItem.id == newItem.id
        }
        
        override fun areContentsTheSame(oldItem: CongressMember, newItem: CongressMember): Boolean {
            return oldItem == newItem
        }
    }
}

