package com.careers.app;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter3 extends RecyclerView.Adapter<Adapter3.ExampleViewHolder>
{

    Adapter3.OnNoteListener onNoteListener;
    ArrayList<com.careers.app.Item3> arrayList;

    public Adapter3(ArrayList<com.careers.app.Item3> arrayList, Adapter3.OnNoteListener onNoteListener)
    {
        this.arrayList = arrayList;
        this.onNoteListener=onNoteListener;
    }

    @NonNull
    @Override
    public Adapter3.ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.item3,parent,false);
        Adapter3.ExampleViewHolder evh=new Adapter3.ExampleViewHolder(v,onNoteListener);
        return evh;

    }

    @Override
    public void onBindViewHolder(@NonNull Adapter3.ExampleViewHolder holder, int position) {

        com.careers.app.Item3 item=arrayList.get(position);

        holder.bookname.setText(item.getJobTitle());
        holder.writer.setText(item.getEmployerName());
        holder.link.setText(item.getEducationalQualification());
        holder.id.setText(item.getDeadLine());


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ExampleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {

        TextView bookname,writer,link,id;
        Adapter3.OnNoteListener onNoteListener;
        public ExampleViewHolder(@NonNull View itemView, Adapter3.OnNoteListener onNoteListener) {
            super(itemView);

            bookname=itemView.findViewById(R.id.jobTitle);
            writer=itemView.findViewById(R.id.employerName);
            link=itemView.findViewById(R.id.educationalQualification);
            id=itemView.findViewById(R.id.deadline);
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

}
