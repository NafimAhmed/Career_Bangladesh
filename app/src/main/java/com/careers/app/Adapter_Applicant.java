package com.careers.app;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter_Applicant extends RecyclerView.Adapter<Adapter_Applicant.ExampleViewHolder> {


    //////////////////////////////////////////////////////////////////////////////
    Adapter_Applicant.OnNoteListener onNoteListener;
    ArrayList<Applicant_Item> arrayList;

    public Adapter_Applicant(ArrayList<com.careers.app.Applicant_Item> arrayList, Adapter_Applicant.OnNoteListener onNoteListener)
    {
        this.arrayList = arrayList;
        this.onNoteListener=onNoteListener;
    }

    @NonNull
    @Override
    public Adapter_Applicant.ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.faq_item,parent,false);
        Adapter_Applicant.ExampleViewHolder evh=new Adapter_Applicant.ExampleViewHolder(v,onNoteListener);
        return evh;

    }

    @Override
    public void onBindViewHolder(@NonNull Adapter_Applicant.ExampleViewHolder holder, int position) {

        com.careers.app.Applicant_Item item=arrayList.get(position);

        holder.question.setText("Name : "+item.getName());
        holder.answer.setText("Email : "+item.getEmail());


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ExampleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {

        TextView question,answer;
        Adapter_Applicant.OnNoteListener onNoteListener;
        public ExampleViewHolder(@NonNull View itemView, Adapter_Applicant.OnNoteListener onNoteListener) {
            super(itemView);

            question=itemView.findViewById(R.id.faq_question);
            answer=itemView.findViewById(R.id.faq_answer);

            this.onNoteListener=onNoteListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            onNoteListener.onNoteclick(getAdapterPosition());

        }
    }

    public interface OnNoteListener
    {
        Void onNoteclick(int position);
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////





}
