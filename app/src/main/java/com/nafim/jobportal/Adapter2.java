package com.nafim.jobportal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter2 extends RecyclerView.Adapter<Adapter2.ExampleViewHolder>
{

    //////////////////////////////////////////////////////////////////////////////
    Adapter2.OnNoteListener onNoteListener;
    ArrayList<Item2> arrayList;

    public Adapter2(ArrayList<Item2> arrayList, Adapter2.OnNoteListener onNoteListener)
    {
        this.arrayList = arrayList;
        this.onNoteListener=onNoteListener;
    }

    @NonNull
    @Override
    public Adapter2.ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.item2,parent,false);
        Adapter2.ExampleViewHolder evh=new Adapter2.ExampleViewHolder(v,onNoteListener);
        return evh;

    }

    @Override
    public void onBindViewHolder(@NonNull Adapter2.ExampleViewHolder holder, int position) {

        Item2 item=arrayList.get(position);

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
        Adapter2.OnNoteListener onNoteListener;
        public ExampleViewHolder(@NonNull View itemView, Adapter2.OnNoteListener onNoteListener) {
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
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////



}
