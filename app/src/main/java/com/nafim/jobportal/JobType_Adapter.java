package com.nafim.jobportal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class JobType_Adapter extends RecyclerView.Adapter<JobType_Adapter.ExampleViewHolder>{

    //////////////////////////////////////////////////////////////////////////////
    JobType_Adapter.JobType_OnNoteListener onNoteListener;
    ArrayList<JobType_Item> arrayList;

    public JobType_Adapter(ArrayList<JobType_Item> arrayList, JobType_Adapter.JobType_OnNoteListener onNoteListener)
    {
        this.arrayList = arrayList;
        this.onNoteListener=onNoteListener;
    }

    @NonNull
    @Override
    public JobType_Adapter.ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.job_type_item,parent,false);
        JobType_Adapter.ExampleViewHolder evh=new JobType_Adapter.ExampleViewHolder(v,onNoteListener);
        return evh;

    }

    @Override
    public void onBindViewHolder(@NonNull JobType_Adapter.ExampleViewHolder holder, int position) {

        JobType_Item item=arrayList.get(position);

        holder.bookname.setText(item.getJobTitle());
//        holder.writer.setText(item.getEmployerName());
//        holder.link.setText(item.getEducationalQualification());
//        holder.id.setText(item.getDeadLine());


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ExampleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {

        TextView bookname;
        JobType_Adapter.JobType_OnNoteListener onNoteListener;
        public ExampleViewHolder(@NonNull View itemView, JobType_Adapter.JobType_OnNoteListener onNoteListener) {
            super(itemView);

            bookname=itemView.findViewById(R.id.jobType);
//            writer=itemView.findViewById(R.id.employerName);
//            link=itemView.findViewById(R.id.educationalQualification);
//            id=itemView.findViewById(R.id.deadline);
//            this.onNoteListener=onNoteListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            onNoteListener.onNoteclick(getAdapterPosition());

        }
    }

    public interface JobType_OnNoteListener extends Adapter.OnNoteListener {
        Void onNoteclick(int position);
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////





}
