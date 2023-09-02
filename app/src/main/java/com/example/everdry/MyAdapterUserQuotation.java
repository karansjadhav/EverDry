package com.example.everdry;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.ArrayList;

public class MyAdapterUserQuotation extends RecyclerView.Adapter<MyAdapterUserQuotation.MyViewHolder> {

    Context context;
    ArrayList<Quotation> list;

    public MyAdapterUserQuotation(Context context, ArrayList<Quotation> list) {
        this.context = context;
        this.list = list;
    }

    @androidx.annotation.NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@androidx.annotation.NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@androidx.annotation.NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Quotation q = list.get(position);
        holder.qid.setText(q.getQId());
        holder.construction.setText(q.getConstruction());
        holder.part.setText(q.getPart());
        holder.coating.setText(q.getCoat());
        holder.location.setText(q.getLocation());
        holder.area.setText(q.getArea());
        holder.quality.setText(q.getQuality());
        holder.address.setText(q.getAddress());
        holder.total_cost.setText(q.getCost());



        holder.cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String c = holder.qid.getText().toString();

                String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
                FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance("https://everdry-7777-default-rtdb.firebaseio.com");
                DatabaseReference databaseReference = firebaseDatabase.getReference("UsersInformation");

                databaseReference.child(uid).child("quotations").child(c).removeValue();
                databaseReference.child("vfJHYhyUZWWumffrHZnOMkrHXDp2").child("quotations").child(uid).child(c).removeValue();

                list.remove(position);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView qid,construction,part,coating,location,area,quality,address,total_cost;
        Button cancel;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            qid = itemView.findViewById(R.id.qid);
            construction = itemView.findViewById(R.id.construction);
            part = itemView.findViewById(R.id.part);
            coating = itemView.findViewById(R.id.coating);
            location = itemView.findViewById(R.id.rate);
            area = itemView.findViewById(R.id.area);
            quality = itemView.findViewById(R.id.quality);
            address = itemView.findViewById(R.id.address);
            total_cost = itemView.findViewById(R.id.total_cost);
            cancel = itemView.findViewById(R.id.cancel);
        }
    }
}
