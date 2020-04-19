package com.bw.alll.widget;


import com.bw.alll.model.bean.CartEntity;
import com.bw.alll.model.bean.HeadPicBean;
import com.bw.alll.model.bean.LogEntity;
import com.bw.alll.model.bean.RegEntity;

import java.util.HashMap;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;


/**
 * date:2020/4/13 0013
 * author:胡锦涛(Administrator)
 * function:
 */
public interface Api {
    @GET //get无参
    Observable<ResponseBody> getNoParams(@Url String url);

    @GET //get有参
    Observable<ResponseBody> getDoParams(@Url String url, @QueryMap HashMap<String,Object> map);
    @GET //get头参
    Observable<ResponseBody> getHeaderParams(@Url String url,@HeaderMap HashMap<String,Object> map);
    @POST //post头像
    @Multipart
    Observable<ResponseBody> postDoHeadPic(@Url String url, @Part MultipartBody.Part img);
    @POST //post无参
    @FormUrlEncoded
    Observable<ResponseBody> postNoParams(@Url String url);
    @POST //post有参
    @FormUrlEncoded
    Observable<ResponseBody> postDoParams(@Url String url,@FieldMap HashMap<String,Object> map);
}
