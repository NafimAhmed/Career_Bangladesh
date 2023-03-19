package com.careers.app;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter_FAQs extends RecyclerView.Adapter<Adapter_FAQs.ExampleViewHolder> {


    //////////////////////////////////////////////////////////////////////////////
    Adapter_FAQs.OnNoteListener onNoteListener;
    ArrayList<com.careers.app.FAQ_Items> arrayList;

    public Adapter_FAQs(ArrayList<com.careers.app.FAQ_Items> arrayList, Adapter_FAQs.OnNoteListener onNoteListener)
    {
        this.arrayList = arrayList;
        this.onNoteListener=onNoteListener;
    }

    @NonNull
    @Override
    public Adapter_FAQs.ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.faq_item,parent,false);
        Adapter_FAQs.ExampleViewHolder evh=new Adapter_FAQs.ExampleViewHolder(v,onNoteListener);
        return evh;

    }

    @Override
    public void onBindViewHolder(@NonNull Adapter_FAQs.ExampleViewHolder holder, int position) {

        com.careers.app.FAQ_Items item=arrayList.get(position);

        holder.question.setText(item.getQuestions());
        holder.answer.setText(item.getAnswer());


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ExampleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {

        TextView question,answer;
        Adapter_FAQs.OnNoteListener onNoteListener;
        public ExampleViewHolder(@NonNull View itemView, Adapter_FAQs.OnNoteListener onNoteListener) {
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
