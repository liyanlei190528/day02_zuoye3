package com.example.a41845.day02_zuoye3.presenter;


import com.example.a41845.day02_zuoye3.bean.RootBean;
import com.example.a41845.day02_zuoye3.callback.MyCallBack;
import com.example.a41845.day02_zuoye3.model.MyModel;
import com.example.a41845.day02_zuoye3.view.MyView;

public class MyPersenterImpl implements MyPersenter, MyCallBack {

    private MyModel myModel;
    private MyView myView;

    public MyPersenterImpl(MyModel myModel, MyView myView) {
        this.myModel = myModel;
        this.myView = myView;
    }

    @Override
    public void getdata(int page) {
        if (myModel !=null){
            myModel.getdata(page,this);
        }
    }

    @Override
    public void onScuuess(RootBean rootBean) {
        if (myView != null){
            myView.onScuuess(rootBean);
        }
    }

    @Override
    public void onField(String msg) {
        if (myView != null){
            myView.onField(msg);
        }
    }
}
