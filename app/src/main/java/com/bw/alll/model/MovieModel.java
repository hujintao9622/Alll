package com.bw.alll.model;

import com.bw.alll.contract.MovieContract;
import com.bw.alll.util.NetUtil;

import java.util.HashMap;

import okhttp3.MultipartBody;

/**
 * date:2020/3/19 0019
 * author:胡锦涛(Administrator)
 * function:model
 */
public class MovieModel implements MovieContract.IModel {
    @Override  //get无参
    public void getNoParams(String url, Class cls, MovieContract.IModelCallback iModelCallback) {
        NetUtil.getInstance().getNoParams(url, cls, new NetUtil.ICallback() {
            @Override
            public void onSuccess(Object o) {
                iModelCallback.onSuccess(o);
            }

            @Override
            public void onError(Throwable e) {
                iModelCallback.onFailure(e);
            }
        });
    }

    @Override
    public void getDoParams(String url, Class cls, HashMap<String, Object> map, MovieContract.IModelCallback iModelCallback) {
        NetUtil.getInstance().getDoParams(url, cls, map, new NetUtil.ICallback() {
            @Override
            public void onSuccess(Object o) {
                iModelCallback.onSuccess(o);
            }

            @Override
            public void onError(Throwable e) {
                iModelCallback.onFailure(e);
            }
        });
    }

    @Override
    public void getHeaderParams(String url, Class cls, HashMap<String, Object> map, MovieContract.IModelCallback iModelCallback) {
        NetUtil.getInstance().getHeaderParams(url, cls, map, new NetUtil.ICallback() {
            @Override
            public void onSuccess(Object o) {
                iModelCallback.onSuccess(o);
            }

            @Override
            public void onError(Throwable e) {
                iModelCallback.onFailure(e);
            }
        });
    }

    @Override
    public void postDoHeadPic(String url, Class cls, MultipartBody.Part image,MovieContract.IModelCallback iModelCallback) {
        NetUtil.getInstance().postDoHeadPic(url, cls, image, new NetUtil.ICallback() {
            @Override
            public void onSuccess(Object o) {
                iModelCallback.onSuccess(o);
            }

            @Override
            public void onError(Throwable e) {
                iModelCallback.onFailure(e);
            }
        });
    }

    @Override
    public void postNoParams(String url, Class cls, MovieContract.IModelCallback iModelCallback) {
        NetUtil.getInstance().postNoParams(url, cls, new NetUtil.ICallback() {
            @Override
            public void onSuccess(Object o) {
                iModelCallback.onSuccess(o);
            }

            @Override
            public void onError(Throwable e) {
                iModelCallback.onFailure(e);
            }
        });
    }

    @Override
    public void postDoParams(String url, Class cls, HashMap<String, Object> map, MovieContract.IModelCallback iModelCallback) {
        NetUtil.getInstance().postDoParams(url, cls, map, new NetUtil.ICallback() {
            @Override
            public void onSuccess(Object o) {
                iModelCallback.onSuccess(o);
            }

            @Override
            public void onError(Throwable e) {
                iModelCallback.onFailure(e);
            }
        });
    }
}
