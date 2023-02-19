package com.nafim.jobportal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter_Exp extends RecyclerView.Adapter<Adapter_Exp.ExampleViewHolder> {


    Adapter_Exp.OnNoteListener onNoteListener;
    ArrayList<Exp_Item> arrayList;

    public Adapter_Exp(ArrayList<Exp_Item> arrayList, Adapter_Exp.OnNoteListener onNoteListener)
    {
        this.arrayList = arrayList;
        this.onNoteListener=onNoteListener;
    }

    @NonNull
    @Override
    public Adapter_Exp.ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.exp_item,parent,false);
        Adapter_Exp.ExampleViewHolder evh=new Adapter_Exp.ExampleViewHolder(v,onNoteListener);
        return evh;

    }

    @Override
    public void onBindViewHolder(@NonNull Adapter_Exp.ExampleViewHolder holder, int position) {

        Exp_Item item=arrayList.get(position);

        holder.companyName.setText(item.company_Name);
        holder.designetion.setText(item.designetion);
        holder.jobDuration.setText("From"+item.joiningDate+"to"+item.resignetionDate);
        holder.jobResponsiblity.setText(item.responsiblity);


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ExampleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {

        TextView companyName,designetion,jobDuration,jobResponsiblity;
        Adapter_Exp.OnNoteListener onNoteListener;
        public ExampleViewHolder(@NonNull View itemView, Adapter_Exp.OnNoteListener onNoteListener) {
            super(itemView);

            companyName=itemView.findViewById(R.id.companyName);
            designetion=itemView.findViewById(R.id.designetion);
            jobDuration=itemView.findViewById(R.id.jobDuration);
            jobResponsiblity=itemView.findViewById(R.id.jobResponsiblity);
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
