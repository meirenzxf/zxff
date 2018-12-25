package com.example.yuekaozxf.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yuekaozxf.R;
import com.example.yuekaozxf.bean.MyData;

import java.util.ArrayList;

public class XAdapter extends RecyclerView.Adapter<XAdapter.ViewHolder> {
    private ArrayList<MyData.DataBean> list1;
    private Context context;

    public XAdapter(ArrayList<MyData.DataBean> list1, Context context) {
        this.list1 = list1;
        this.context = context;
    }
    @NonNull
    @Override
    public XAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(context).inflate(R.layout.duo,null);
       ViewHolder holder=new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull XAdapter.ViewHolder holder, int position) {
        MyData.DataBean dataBean=list1.get(position);
        //Glide.with(context).load(dataBean.getList()).into(holder.image1);
        holder.textt.setText(dataBean.getSellerName());
    }

    @Override
    public int getItemCount() {
        return list1.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView image2;
        private TextView textt;
        public ViewHolder(View itemView) {
            super(itemView);
            textt=itemView.findViewById(R.id.textxrecy);
            image2=itemView.findViewById(R.id.imagexrecy);
        }
    }
}
