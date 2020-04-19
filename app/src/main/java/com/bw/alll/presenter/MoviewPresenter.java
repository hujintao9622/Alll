package com.bw.alll.presenter;

import com.bw.alll.base.BasePresenter;
import com.bw.alll.contract.MovieContract;
import com.bw.alll.model.MovieModel;

import java.util.HashMap;

import okhttp3.MultipartBody;

/**
 * date:2020/3/19 0019
 * author:胡锦涛(Administrator)
 * function:presenter
 */
public class MoviewPresenter extends BasePresenter<MovieContract.IView> implements MovieContract.IPresenter {

    private MovieModel movieModel;

    @Override
    protected void initModel() {
        movieModel = new MovieModel();
    }

    @Override
    public void getNoParams(String url, Class cls) {
        movieModel.getNoParams(url, cls, new MovieContract.IModelCallback() {
            @Override
            public void onSuccess(Object o) {
                getView().onSuccess(o);
            }

            @Override
            public void onFailure(Throwable e) {
                getView().onFailure(e);
            }
        });
    }

    @Override
    public void getDoParams(String url, Class cls, HashMap<String, Object> map) {
        movieModel.getDoParams(url, cls, map, new MovieContract.IModelCallback() {
            @Override
            public void onSuccess(Object o) {
                getView().onSuccess(o);
            }

            @Override
            public void onFailure(Throwable e) {
                getView().onFailure(e);
            }
        });
    }

    @Override
    public void getHeaderParams(String url, Class cls, HashMap<String, Object> map) {
        movieModel.getHeaderParams(url, cls, map, new MovieContract.IModelCallback() {
            @Override
            public void onSuccess(Object o) {
                getView().onSuccess(o);
            }

            @Override
            public void onFailure(Throwable e) {
                getView().onFailure(e);
            }
        });
    }

    @Override
    public void postDoHeadPic(String url, Class cls, MultipartBody.Part img) {
        movieModel.postDoHeadPic(url, cls, img, new MovieContract.IModelCallback() {
            @Override
            public void onSuccess(Object o) {
                getView().onSuccess(o);
            }

            @Override
            public void onFailure(Throwable e) {
                getView().onFailure(e);
            }
        });
    }

    @Override
    public void postNoParams(String url, Class cls) {
        movieModel.postNoParams(url, cls, new MovieContract.IModelCallback() {
            @Override
            public void onSuccess(Object o) {
                getView().onSuccess(o);
            }

            @Override
            public void onFailure(Throwable e) {
                getView().onFailure(e);
            }
        });
    }

    @Override
    public void postDoParams(String url, Class cls, HashMap<String, Object> map) {
        movieModel.postDoParams(url, cls, map, new MovieContract.IModelCallback() {
            @Override
            public void onSuccess(Object o) {
                getView().onSuccess(o);
            }

            @Override
            public void onFailure(Throwable e) {
                getView().onFailure(e);
            }
        });
    }
}
