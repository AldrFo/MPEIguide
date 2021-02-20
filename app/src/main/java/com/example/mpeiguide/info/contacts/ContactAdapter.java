package com.example.mpeiguide.info.contacts;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mpeiguide.R;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder>  {

    interface OnContactClickListener{
        public void onContactClick(Contact contact, int position);
    }

    private final int MAX_DESC_LENGTH = 50;

    private final LayoutInflater inflater;
    private final List<Contact> contacts;
    private ContactAdapter.OnContactClickListener contactClickListener;

    public ContactAdapter(LayoutInflater inflater, List<Contact> contacts,
                          OnContactClickListener listener){
        this.inflater = inflater;
        this.contacts = contacts;
        this.contactClickListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.contact_item,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final Contact contact = contacts.get(position);

        if(contact.getImageId() != 0){
            holder.avatar.setImageResource(contact.getImageId());
        }

        holder.contactName.setText(contact.getName());
        holder.contactWorkPos.setText(contact.getWorkPosition());

        char[] shortDescChar = contact.getDescription().toCharArray();
        StringBuilder shortDesc = new StringBuilder();
        shortDesc.append("  ");
        if(shortDescChar.length >= MAX_DESC_LENGTH-3) {
            for (int i = 0; i < MAX_DESC_LENGTH-3; i++) {
                shortDesc.append(shortDescChar[i]);
            }
            shortDesc.append("...");
        }else{
            shortDesc.append(shortDescChar);
        }
        holder.contactShortDescription.setText(shortDesc.toString());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contactClickListener.onContactClick(contact,position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        final ImageView avatar;
        final TextView contactName;
        final TextView contactWorkPos;
        final TextView contactShortDescription;

        public ViewHolder(View v){
            super(v);

            avatar = v.findViewById(R.id.contact_item_avatar);
            contactName = v.findViewById(R.id.contact_item_name);
            contactWorkPos = v.findViewById(R.id.contact_item_work_pos);
            contactShortDescription = v.findViewById(R.id.contact_short_item_description);
        }
    }
}
