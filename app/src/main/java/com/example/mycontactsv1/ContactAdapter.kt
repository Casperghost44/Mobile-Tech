package com.example.mycontactsv1

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mycontactsv1.databinding.ContactsLayoutBinding

class ContactsAdapter(val context : Context, val list : List<Contacts>) : RecyclerView.Adapter<ContactsAdapter.ViewHolder>() {

    class ViewHolder(val binding : ContactsLayoutBinding) : RecyclerView.ViewHolder(binding.root){}


    private val dao = ContactDatabase.getDatabaseInstance(context).contactsDao()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ContactsLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.contactName.text = list[position].name
        holder.binding.contactNumber.text = list[position].number

        holder.binding.deleteButton.setOnClickListener{
            dao.delete(list[position])
            notifyItemRemoved(position)
        }


        holder.binding.phoneicon.setOnClickListener{
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + list[position].number))
            context.startActivity(intent)
        }

    }


    override fun getItemCount(): Int {
        return list.size
    }
}
