package com.example.a41845.day02_zuoye3;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.a41845.day02_zuoye3.adapter.MyAdapter;
import com.example.a41845.day02_zuoye3.adapter.VpAdapter;
import com.example.a41845.day02_zuoye3.bean.RootBean;
import com.example.a41845.day02_zuoye3.model.MyModelImpl;
import com.example.a41845.day02_zuoye3.presenter.MyPersenterImpl;
import com.example.a41845.day02_zuoye3.view.MyView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MyView {

    private RecyclerView mRv;
    private ArrayList<RootBean.ResultsBean> list;
    private MyAdapter myAdapter;
    private int page = 1;
    private ViewPager mVp;
    private ArrayList<View> views;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {
        MyPersenterImpl myPersenter = new MyPersenterImpl(new MyModelImpl(), this);
        myPersenter.getdata(page);
    }

    private void initView() {
        mRv = (RecyclerView) findViewById(R.id.rv);
        mVp = (ViewPager) findViewById(R.id.vp);
        list = new ArrayList<>();
        views = new ArrayList<>();
        myAdapter = new MyAdapter(this, list);
        mRv.setAdapter(myAdapter);
        mRv.setLayoutManager(new LinearLayoutManager(this));



    }

    @Override
    public void onScuuess(RootBean rootBean) {
        List<RootBean.ResultsBean> results = rootBean.getResults();
        list.addAll(results);
        myAdapter.notifyDataSetChanged();

        myAdapter.setOnClickListener(new MyAdapter.OnClickListener() {
            @Override
            public void getdata(int position, RootBean.ResultsBean resultsBean) {
                for (int i = 0; i <list.size() ; i++) {
                    View view = View.inflate(MainActivity.this,R.layout.layout_vp,null);
                    ImageView img_vp = view.findViewById(R.id.img_vp);
                    TextView txt = view.findViewById(R.id.txt);
                    txt.setText(""+(i+1)+"/"+list.size());
                    Glide.with(MainActivity.this)
                            .load(list.get(i).getUrl()).into(img_vp);
                    img_vp.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            mVp.setVisibility(View.GONE);
                        }
                    });
                    views.add(view);

                }
                VpAdapter vpAdapter = new VpAdapter(views);
                vpAdapter.setList(views);
                mVp.setAdapter(vpAdapter);
                mVp.setCurrentItem(position);
                mVp.setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    public void onField(String msg) {
        Toast.makeText(this, "" + msg, Toast.LENGTH_SHORT).show();
    }
}
