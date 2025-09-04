package com.congress.app.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.congress.app.R
import com.congress.app.databinding.ItemCallLogBinding
import java.text.SimpleDateFormat
import java.util.*

class CallLogAdapter : RecyclerView.Adapter<CallLogAdapter.CallLogViewHolder>() {
    
    private val logEntries = mutableListOf<CallLogEntry>()
    private val dateFormat = SimpleDateFormat("HH:mm:ss", Locale.getDefault())
    
    data class CallLogEntry(
        val phoneNumber: String,
        val status: String,
        val message: String,
        val timestamp: Long
    )
    
    class CallLogViewHolder(private val binding: ItemCallLogBinding) : RecyclerView.ViewHolder(binding.root) {
        
        fun bind(entry: CallLogEntry, dateFormat: SimpleDateFormat) {
            binding.phoneNumberText.text = entry.phoneNumber
            binding.statusText.text = entry.status
            binding.messageText.text = entry.message
            binding.timestampText.text = dateFormat.format(Date(entry.timestamp))
            
            // Set status color
            val statusColor = when (entry.status.lowercase()) {
                "success" -> binding.root.context.getColor(R.color.success_green)
                "failed" -> binding.root.context.getColor(R.color.error_red)
                else -> binding.root.context.getColor(R.color.warning_orange)
            }
            binding.statusText.setTextColor(statusColor)
        }
    }
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CallLogViewHolder {
        val binding = ItemCallLogBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CallLogViewHolder(binding)
    }
    
    override fun onBindViewHolder(holder: CallLogViewHolder, position: Int) {
        holder.bind(logEntries[position], dateFormat)
    }
    
    override fun getItemCount(): Int = logEntries.size
    
    fun addLogEntry(entry: CallLogEntry) {
        logEntries.add(0, entry) // Add to top
        notifyItemInserted(0)
    }
    
    fun clearLog() {
        logEntries.clear()
        notifyDataSetChanged()
    }
}

