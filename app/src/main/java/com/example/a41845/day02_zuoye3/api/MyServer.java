package com.example.a41845.day02_zuoye3.api;



import com.example.a41845.day02_zuoye3.bean.RootBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MyServer {

    public String url = "http://gank.io/api/data/%E7%A6%8F%E5%88%A9/";
    @GET("20/{page}")
    Observable<RootBean> getdata(@Path("page") int page);
}
