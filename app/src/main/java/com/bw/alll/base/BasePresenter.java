package com.bw.alll.base;

import java.lang.ref.WeakReference;

/**
 * date:2020/4/13 0013
 * author:胡锦涛(Administrator)
 * function:
 */
public abstract class BasePresenter<V>{

    private WeakReference<V> weakReference;

    public void attach(V view){
        weakReference = new WeakReference<>(view);
    }
    public void detach(){
        if (weakReference != null) {
            weakReference.clear();
            weakReference=null;
        }
    }
    public V getView(){
        return weakReference.get();
    }

    public BasePresenter() {
        initModel();
    }

    protected abstract void initModel();
}
