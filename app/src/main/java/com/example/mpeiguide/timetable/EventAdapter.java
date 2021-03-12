package com.example.mpeiguide.timetable;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mpeiguide.MainActivity;
import com.example.mpeiguide.R;
import com.example.mpeiguide.settings.SettingsFragment;

import java.util.List;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.ViewHolder> {

    interface OnEventClickListener{
        public void onEventClick(Event e, int position);
    }

    private final LayoutInflater inflater;
    private final List<Event> events;
    private OnEventClickListener eventClickListener;

    private SharedPreferences settings;

    public EventAdapter(Context context, List<Event> events, OnEventClickListener eventClickListener){
        inflater = LayoutInflater.from(context);
        settings = context.getSharedPreferences(SettingsFragment.SETTING_NAME,Context.MODE_PRIVATE);
        this.events = events;
        this.eventClickListener = eventClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.event_item,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Log.d(MainActivity.MAIN_LOG,"EventAdapter: onBindHolder");
        final Event event = events.get(position);
        holder.startTime.setText(event.getStartTime());
        holder.endTime.setText(event.getEndTime());
        holder.eventName.setText(event.getEventName());
        holder.eventType.setText(event.getEventType());
        holder.place.setText(event.getPlace());
        holder.teacherName.setText(event.getTeacherName());
        holder.description.setText(event.getDescription());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eventClickListener.onEventClick(event,position);
            }
        });

        if(!settings.getBoolean(SettingsFragment.SHOW_TEACHER,true)){
            holder.infoLayout.removeView(holder.teacherName);
        }
    }

    @Override
    public int getItemCount() {
        return events.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        final LinearLayout infoLayout;

        final TextView startTime, endTime;
        final TextView eventName;
        final TextView eventType;
        final TextView place;
        final TextView teacherName;
        final TextView description;

        public ViewHolder(View v){
            super(v);
            infoLayout = v.findViewById(R.id.event_info_layout);
            startTime = v.findViewById(R.id.event_start_time);
            endTime = v.findViewById(R.id.event_end_time);
            eventName = v.findViewById(R.id.event_name);
            eventType = v.findViewById(R.id.event_type);
            place = v.findViewById(R.id.event_place);
            teacherName = v.findViewById(R.id.teacher_name);
            description = v.findViewById(R.id.event_description);
        }
    }
}
