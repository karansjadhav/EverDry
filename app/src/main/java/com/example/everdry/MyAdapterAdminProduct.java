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

public class MyAdapterAdminProduct extends RecyclerView.Adapter<MyAdapterAdminProduct.MyViewHolder> {

    Context context;
    ArrayList<AdminProducts> list;

    public MyAdapterAdminProduct(Context context, ArrayList<AdminProducts> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(@androidx.annotation.NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.itemadminproduct,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@androidx.annotation.NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        AdminProducts q = list.get(position);

        holder.c_id.setText(q.getC_id());
        holder.c_pid.setText(q.getC_pid());
        holder.c_name.setText(q.getC_name());
        holder.c_mobile.setText(q.getC_mobile());
        holder.c_address.setText(q.getC_address());
        holder.c_product.setText(q.getC_product());
        holder.c_delivery.setText(q.getC_delivery());
        holder.c_payment.setText(q.getC_payment());
        holder.c_price.setText("₹" + q.getC_price());

        String s = q.getC_product_image();

        if(s.equals("1")) {
            holder.c_product_image.setImageResource(R.drawable.a1);
        }
        else if(s.equals("2")) {
            holder.c_product_image.setImageResource(R.drawable.a2);
        }
        else if(s.equals("3")) {
            holder.c_product_image.setImageResource(R.drawable.a3);
        }
        else if(s.equals("4")) {
            holder.c_product_image.setImageResource(R.drawable.a5);
        }
        else if(s.equals("5")) {
            holder.c_product_image.setImageResource(R.drawable.a5);
        }
        else if(s.equals("6")) {
            holder.c_product_image.setImageResource(R.drawable.a6);
        }
        else if(s.equals("7")) {
            holder.c_product_image.setImageResource(R.drawable.a7);
        }
        else if(s.equals("8")) {
            holder.c_product_image.setImageResource(R.drawable.a8);
        }



        holder.delivered.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String id = holder.c_id.getText().toString();
                String c = holder.c_pid.getText().toString();

                String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
                FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance("https://everdry-7777-default-rtdb.firebaseio.com");
                DatabaseReference databaseReference = firebaseDatabase.getReference("UsersInformation");

                databaseReference.child(id).child("products").child(c).removeValue();
                databaseReference.child(uid).child("products").child(id).child(c).removeValue();

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

        TextView c_id, c_pid, c_name, c_mobile, c_address, c_product, c_delivery, c_payment, c_price;
        ImageView c_product_image;
        Button delivered;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            c_id = itemView.findViewById(R.id.c_id);
            c_pid = itemView.findViewById(R.id.c_pid);
            c_name = itemView.findViewById(R.id.c_name);
            c_mobile = itemView.findViewById(R.id.c_mobile);
            c_address = itemView.findViewById(R.id.c_address);
            c_product = itemView.findViewById(R.id.c_product);
            c_delivery = itemView.findViewById(R.id.c_delivery);
            c_payment = itemView.findViewById(R.id.c_payment);
            c_price = itemView.findViewById(R.id.c_price);

            c_product_image = itemView.findViewById(R.id.c_product_image);
            delivered = itemView.findViewById(R.id.delivered);
        }
    }
}
