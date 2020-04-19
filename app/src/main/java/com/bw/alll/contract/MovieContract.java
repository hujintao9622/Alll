package com.bw.alll.contract;

import java.util.HashMap;

import okhttp3.MultipartBody;

/**
 * date:2020/3/19 0019
 * author:胡锦涛(Administrator)
 * function:契约类
 */
public interface MovieContract {
    //回调
    interface IModelCallback<T>{
        void onSuccess(T t);
        void onFailure(Throwable e);
    }
    interface IView<T>{
        void onSuccess(T t);
        void onFailure(Throwable e);
    }
    interface IPresenter{
        //get无参
        void getNoParams(String url, Class cls);
        //get有参
        void getDoParams(String url, Class cls, HashMap<String, Object> map);
        //get头参
        void getHeaderParams(String url, Class cls, HashMap<String, Object> map);
        //post 头像
        void postDoHeadPic(String url, Class cls, MultipartBody.Part image);
        //post无参
        void postNoParams(String url, Class cls);
        //post有参
        void postDoParams(String url, Class cls, HashMap<String, Object> map);
    }
    interface IModel{
        //get无参
        void getNoParams(String url, Class cls, IModelCallback iModelCallback);
        //get有参
        void getDoParams(String url, Class cls, HashMap<String, Object> map, IModelCallback iModelCallback);
        //get头参
        void getHeaderParams(String url, Class cls, HashMap<String, Object> map, IModelCallback iModelCallback);
        //post 头像
        void postDoHeadPic(String url, Class cls, MultipartBody.Part image, IModelCallback iModelCallback);
        //post无参
        void postNoParams(String url, Class cls, IModelCallback iModelCallback);
        //post有参
        void postDoParams(String url, Class cls, HashMap<String, Object> map, IModelCallback iModelCallback);
    }
}
