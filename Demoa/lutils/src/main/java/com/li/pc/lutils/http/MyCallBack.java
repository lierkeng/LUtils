package com.li.pc.lutils.http;

import android.widget.Toast;

import org.xutils.common.Callback;
import org.xutils.common.util.LogUtil;
import org.xutils.ex.HttpException;
import org.xutils.x;

/**
 * Describe 网络请求回调
 */
public  class MyCallBack<T> implements Callback.CommonCallback<T>,Callback.CacheCallback<T>{

    /**
     * 请求成功的数据返回 抽象方法不能有方法体
     * @param result
     */
    @Override
    public  void onSuccess(T result){
        LogUtil.i("网络请求成功");
    };

    /**
     * 请求失败
     * @param ex 错误
     * @param isOnCallback 是否还在请求
     */
    @Override
    public void onError(Throwable ex, boolean isOnCallback) {
        LogUtil.i("网络请求失败");
        if (ex instanceof HttpException) { // 网络错误
            HttpException httpEx = (HttpException) ex;
            int responseCode = httpEx.getCode();
            String responseMsg = httpEx.getMessage();
            String errorResult = httpEx.getResult();
            // ...
        } else { // 其他错误
            // ...
        }
        Toast.makeText(x.app(), ex.getMessage(), Toast.LENGTH_LONG).show();
    }

    /**
     * 请求取消
     * @param cex 取消错误
     */
    @Override
    public void onCancelled(CancelledException cex) {
        LogUtil.i("网络请求取消");
    }

    /**
     * 请求成功
     */
    @Override
    public void onFinished() {
        LogUtil.i("网络请求完成");
    }

    @Override
    public boolean onCache(T result) {
        return false;
    }
}
