package com.erickvazquezs.hellomodulo4.practices.graphicComponents.list2ExtraExercise

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.erickvazquezs.hellomodulo4.R

class ContactsAdapter(val list: List<ContactEntity>) : RecyclerView.Adapter<ContactsAdapter.ViewHolder>() {

    var onItemSelected: ((ContactEntity) -> Unit)? = null

    // Creamos la vista que queremos se utilice para cada item de la lista
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_contact, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        holder.render(list[position], onItemSelected)
    }

    override fun getItemCount(): Int {
        return list.size
    }


    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        // obtenemos los elementos de nuestro item
        val contactNameTextView: TextView? = view.findViewById(R.id.contactName)
        val phoneNumberTextView: TextView? = view.findViewById(R.id.contactPhoneNumber)
        val contactPhotoImageView: ImageView? = view.findViewById(R.id.contactPhoto)

        // obtenemos la tarjeta
        val contactCard: CardView? = view.findViewById(R.id.contactCard)

        fun render(contact: ContactEntity, onItemSelected: ((ContactEntity) -> Unit)?) {
            contactNameTextView?.text = contact.name
            phoneNumberTextView?.text = contact.phoneNumber

            val imageId = contact.photo ?: R.drawable.img_placeholder
            contactPhotoImageView?.setImageResource(imageId)

            contactCard?.setOnClickListener {
                onItemSelected?.invoke(contact)
            }
        }
    }
}