package com.example.mywork;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Map;

public class myclass extends RecyclerView.Adapter <myclass.MyViewHolder>{

    private View itemView;
    private Context context;
    private List<Map<String,Object>> data;

    public myclass(List<Map<String,Object>> data, Context context){
        this.context=context;
        this.data=data;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        itemView= LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        MyViewHolder myViewHolder=new MyViewHolder(itemView);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.textView.setText(data.get(position).get("PRODUCT").toString());
        holder.textView1.setText(data.get(position).get("PRICE").toString());
        holder.textView2.setText(data.get(position).get("CONFIGURATION").toString());
        holder.imageView.setImageResource(Integer.parseInt(data.get(position).get("PNG").toString()));

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private Intent intent;
        TextView textView;
        TextView textView1;
        TextView textView2;
        ImageView imageView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.textView);
            textView1=itemView.findViewById(R.id.textView1);
            textView2=itemView.findViewById(R.id.textView2);
            imageView=itemView.findViewById(R.id.imageView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Log.e("lcf","当前点击位置："+getAdapterPosition());
                    switch (getAdapterPosition())
                    {
                        case 0:
                            intent=new Intent(itemView.getContext(), com.example.mywork.clearly.class);
                            break;
                        case 1:
                            intent=new Intent(itemView.getContext(),clearly1.class);
                            break;
                        case 2:
                            intent=new Intent(itemView.getContext(), com.example.mywork.clearly2.class);
                            break;
                        case 3:
                            intent=new Intent(itemView.getContext(),clearly3.class);
                            break;
                    }
                    context.startActivity(intent);
                }
            });
        }
    }
}
