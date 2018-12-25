package com.example.yuekaozxf.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.yuekaozxf.R;
import com.example.yuekaozxf.bean.MyData;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private ArrayList<MyData.DataBean> list;
    private Context context;

    public MyAdapter(ArrayList<MyData.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view=LayoutInflater.from(context).inflate(R.layout.dan,null);
            ViewHolder holder=new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder holder, int position) {
            MyData.DataBean dataBean=list.get(position);
        //Glide.with(context).load(dataBean.getList()).into(holder.image1);
            holder.text.setText(dataBean.getSellerName());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private  ImageView image1;
        private  TextView text;

        public ViewHolder(View itemView) {
            super(itemView);
            image1= itemView.findViewById(R.id.imagerecy);
            text = itemView.findViewById(R.id.textrecy);

        }
    }
}
