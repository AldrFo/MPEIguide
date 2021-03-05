package com.example.mpeiguide.info.sites;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mpeiguide.R;

import java.util.List;

public class SitesAdapter extends RecyclerView.Adapter<SitesAdapter.ViewHolder>{

    public interface OnSiteClickListener{
        void onSiteClick(Site site, int position);
    }

    private LayoutInflater inflater;
    private List<Site> sites;
    private OnSiteClickListener listener;

    public SitesAdapter(LayoutInflater inflater, List<Site> sites, OnSiteClickListener listener){
        this.inflater = inflater;
        this.sites = sites;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.site_item,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        final Site site = sites.get(position);

        holder.name.setText(site.getName());
        holder.desc.setText(site.getDescription());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onSiteClick(site, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return sites.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        TextView desc;

        public ViewHolder(View v){
            super(v);

            name = v.findViewById(R.id.site_name);
            desc = v.findViewById(R.id.site_description);
        }
    }
}
