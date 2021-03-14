package com.example.mpeiguide.info.organizations;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mpeiguide.R;
import com.example.mpeiguide.info.faq.Question;

import java.util.ArrayList;
import java.util.List;

public class OrganizationAdapter extends RecyclerView.Adapter<OrganizationAdapter.ViewHolder> {

    interface OnOrganizationClickListener{
        void onOrganizationClick(Organization org, int position);
    }

    public static final int MAX_DESC_LENGTH = 200;

    private LayoutInflater inflater;
    private List<Organization> organizations;
    private OnOrganizationClickListener listener;

    public OrganizationAdapter(LayoutInflater inflater, List<Organization> organizations,
                               OnOrganizationClickListener listener){
        this.inflater = inflater;
        this.organizations = organizations;
        this.listener = listener;
    }

    @NonNull
    @Override
    public OrganizationAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.organization_item,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull OrganizationAdapter.ViewHolder holder, final int position) {
        final Organization organization = organizations.get(position);

        if(organization.getImageId() != Organization.NONE){
            holder.avatar.setImageResource(organization.getImageId());
        }

        holder.name.setText(organization.getOrgName());

        char[] shortDescChar = organization.getDescription().toCharArray();
        StringBuilder shortDesc = new StringBuilder();
        if(shortDescChar.length >= MAX_DESC_LENGTH) {
            for (int i = 0; i < MAX_DESC_LENGTH; i++) {
                shortDesc.append(shortDescChar[i]);
            }
            shortDesc.append("...");
        }else{
            shortDesc.append(shortDescChar);
        }

        holder.description.setText(shortDesc.toString());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onOrganizationClick(organization,position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return organizations.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        ImageView avatar;
        TextView name;
        TextView description;

        public ViewHolder(View v){
            super(v);
            avatar = v.findViewById(R.id.organization_item_avatar);
            name = v.findViewById(R.id.organization_item_name);
            description = v.findViewById(R.id.organization_item_description);
        }
    }
}
