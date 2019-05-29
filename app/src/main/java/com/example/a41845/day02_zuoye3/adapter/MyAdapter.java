package com.example.a41845.day02_zuoye3.adapter;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.a41845.day02_zuoye3.MainActivity;
import com.example.a41845.day02_zuoye3.R;
import com.example.a41845.day02_zuoye3.bean.RootBean;


import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private final MainActivity mainActivity;
    private final ArrayList<RootBean.ResultsBean> list;

    public MyAdapter(MainActivity mainActivity, ArrayList<RootBean.ResultsBean> list) {

        this.mainActivity = mainActivity;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(mainActivity,R.layout.layout_item,null);
        return new ViewHolder(view);
    }

    @SuppressLint("CheckResult")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        final RootBean.ResultsBean resultsBean = list.get(i);
        ViewHolder holder = viewHolder;
        holder.title.setText(resultsBean.getDesc());
        RequestOptions requestOptions = RequestOptions.bitmapTransform(new RoundedCorners(8));
        Glide.with(mainActivity)
                .load(resultsBean.getUrl())
                .apply(requestOptions)
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.img);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickListener.getdata(i,resultsBean);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView img;
        private TextView title;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            title = itemView.findViewById(R.id.title);
        }
    }
    private OnClickListener onClickListener;

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public interface OnClickListener{
        void getdata(int position,RootBean.ResultsBean resultsBean);
    }
}
