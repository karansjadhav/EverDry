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

public class MyAdapterAdminQuotation extends RecyclerView.Adapter<MyAdapterAdminQuotation.MyViewHolder> {

    Context context;
    ArrayList<UsersQuotations> list;

    public MyAdapterAdminQuotation(Context context, ArrayList<UsersQuotations> list) {
        this.context = context;
        this.list = list;
    }

    @androidx.annotation.NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@androidx.annotation.NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.itemadmin,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@androidx.annotation.NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        UsersQuotations q = list.get(position);

        holder.userid.setText(q.getUid());
        holder.qid.setText(q.getUqid());
        holder.name.setText(q.getUName());
        holder.mobile.setText(q.getUMobile_number());
        holder.email.setText(q.getUEmail());
        holder.construction.setText(q.getUConstruction());
        holder.part.setText(q.getUPart());
        holder.coating.setText(q.getUCoat());
        holder.location.setText(q.getULocation());
        holder.area.setText(q.getUArea());
        holder.quality.setText(q.getUQuality());
        holder.address.setText(q.getUAddress());
        holder.total_cost.setText(q.getUCost());
        holder.done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String id = holder.userid.getText().toString();
                String c = holder.qid.getText().toString();

                String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
                FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance("https://everdry-7777-default-rtdb.firebaseio.com");
                DatabaseReference databaseReference = firebaseDatabase.getReference("UsersInformation");

                databaseReference.child(id).child("quotations").child(c).removeValue();
                databaseReference.child(uid).child("quotations").child(id).child(c).removeValue();

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

        TextView userid,qid,name,mobile,email,construction,part,coating,location,area,quality,address,total_cost;
        Button done;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            userid = itemView.findViewById(R.id.userid);
            qid = itemView.findViewById(R.id.qid);
            name = itemView.findViewById(R.id.name);
            mobile = itemView.findViewById(R.id.mobile);
            email = itemView.findViewById(R.id.email);
            construction = itemView.findViewById(R.id.construction);
            part = itemView.findViewById(R.id.part);
            coating = itemView.findViewById(R.id.coating);
            location = itemView.findViewById(R.id.rate);
            area = itemView.findViewById(R.id.area);
            quality = itemView.findViewById(R.id.quality);
            address = itemView.findViewById(R.id.address);
            total_cost = itemView.findViewById(R.id.total_cost);
            done = itemView.findViewById(R.id.done);
        }
    }
}
