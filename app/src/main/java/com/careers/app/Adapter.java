package com.careers.app;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ExampleViewHolder>
{

    //////////////////////////////////////////////////////////////////////////////
    OnNoteListener onNoteListener;
    ArrayList<com.careers.app.Item> arrayList;
    Activity activity;

    public Adapter(ArrayList<com.careers.app.Item> arrayList, OnNoteListener onNoteListener, Activity activity)
    {
        this.arrayList = arrayList;
        this.onNoteListener=onNoteListener;
        this.activity=activity;
    }

    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        ExampleViewHolder evh=new ExampleViewHolder(v,onNoteListener);
        return evh;

    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {

        com.careers.app.Item item=arrayList.get(position);

        holder.bookname.setText(item.getJobTitle());
        holder.writer.setText(item.getEmployerName());
        holder.link.setText(item.getEducationalQualification());
        holder.id.setText(item.getDeadLine());
        Glide.with(activity).load(item.logoURL).into(holder.itemLogo);



    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ExampleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {

        TextView bookname,writer,link,id;
        OnNoteListener onNoteListener;
        ImageView itemLogo;
        public ExampleViewHolder(@NonNull View itemView,OnNoteListener onNoteListener) {
            super(itemView);

            bookname=itemView.findViewById(R.id.jobTitle);
            writer=itemView.findViewById(R.id.employerName);
            link=itemView.findViewById(R.id.educationalQualification);
            id=itemView.findViewById(R.id.deadline);
            itemLogo=itemView.findViewById(R.id.itemLogo);
            this.onNoteListener=onNoteListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            onNoteListener.onNoteclicl(getAdapterPosition());

        }
    }

    public interface OnNoteListener
    {
        Void onNoteclicl(int position);
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////


}
