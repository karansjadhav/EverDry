package com.example.everdry;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.ArrayList;

public class MyAdapterUserProduct extends RecyclerView.Adapter<MyAdapterUserProduct.MyViewHolder> {

    Context context;
    ArrayList<UserProducts> list;

    public MyAdapterUserProduct(Context context, ArrayList<UserProducts> list) {
        this.context = context;
        this.list = list;
    }

    @androidx.annotation.NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@androidx.annotation.NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.itemproduct,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@androidx.annotation.NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        UserProducts q = list.get(position);

        holder.p_id.setText(q.getP_id());
        holder.p_name.setText(q.getP_name());
        holder.p_offer.setText(q.getP_offer());
        holder.p_delivery.setText(q.getP_delivery());
        holder.p_payment.setText(q.getP_payment());
        holder.p_address.setText(q.getP_address());
        holder.p_price.setText("₹" + q.getP_price());

        String s = q.getP_image();

        if(s.equals("1")) {
            holder.p_image.setImageResource(R.drawable.a1);
        }
        else if(s.equals("2")) {
            holder.p_image.setImageResource(R.drawable.a2);
        }
        else if(s.equals("3")) {
            holder.p_image.setImageResource(R.drawable.a3);
        }
        else if(s.equals("4")) {
            holder.p_image.setImageResource(R.drawable.a5);
        }
        else if(s.equals("5")) {
            holder.p_image.setImageResource(R.drawable.a5);
        }
        else if(s.equals("6")) {
            holder.p_image.setImageResource(R.drawable.a6);
        }
        else if(s.equals("7")) {
            holder.p_image.setImageResource(R.drawable.a7);
        }
        else if(s.equals("8")) {
            holder.p_image.setImageResource(R.drawable.a8);
        }



        holder.cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String c = holder.p_id.getText().toString();

                String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
                FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance("https://everdry-7777-default-rtdb.firebaseio.com");
                DatabaseReference databaseReference = firebaseDatabase.getReference("UsersInformation");

                databaseReference.child(uid).child("products").child(c).removeValue();
                databaseReference.child("vfJHYhyUZWWumffrHZnOMkrHXDp2").child("products").child(uid).child(c).removeValue();

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

        TextView p_id,p_name,p_offer,p_delivery,p_payment,p_address,p_price;
        ImageView p_image;
        Button cancel;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            p_id = itemView.findViewById(R.id.p_id);
            p_name = itemView.findViewById(R.id.p_name);
            p_offer = itemView.findViewById(R.id.p_offer);
            p_delivery = itemView.findViewById(R.id.p_delivery);
            p_payment = itemView.findViewById(R.id.p_payment);
            p_address = itemView.findViewById(R.id.p_address);
            p_price = itemView.findViewById(R.id.p_price);
            p_image = itemView.findViewById(R.id.p_image);
            cancel = itemView.findViewById(R.id.cancel);
        }
    }
}
