package com.example.a41845.day02_zuoye3.adapter;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Time:1219:51
 * <p>
 * Author:L
 */
public class VpAdapter extends PagerAdapter {
    private ArrayList<View>list;

    public VpAdapter(ArrayList<View> list) {
        this.list = list;
    }

    public void setList(ArrayList<View> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return o == view;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = list.get(position);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        View view = list.get(position);
        container.removeView(view);
    }
}
