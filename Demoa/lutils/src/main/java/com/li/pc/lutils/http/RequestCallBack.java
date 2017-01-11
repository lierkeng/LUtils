package com.li.pc.lutils.http;

import android.widget.Toast;

import org.xutils.common.Callback;
import org.xutils.ex.DbException;
import org.xutils.ex.HttpException;
import org.xutils.x;

import java.net.UnknownHostException;

/**
 * author   ：mo
 * data     ：2017/1/11
 * time     ：17:43
 * function :请求回调类，最接近网络请求的回调===第三层
 */

public abstract class RequestCallBack<T> implements Callback.CommonCallback<T> ,Callback.CacheCallback<T>,Callback.ProgressCallback<T>{
    private final InterfaceCallBack interfaceCallBack;
    public RequestCallBack(ImplCallBack<T> callback) {
        this.interfaceCallBack=callback;
    }

    /**
     * 是否缓存
     * @param result
     * @return
     */
    @Override
    public boolean onCache(T result) {
        return false;
    }

    /**
     * 请求成功的数据返回 抽象方法不能有方法体
     * @param result
     */
    @Override
    public abstract void onSuccess(T result);

    /**
     * 请求失败
     * @param ex 错误
     * @param isOnCallback 是否还在请求
     */
    @Override
    public void onError(Throwable ex, boolean isOnCallback) {
        if (ex instanceof HttpException) { // 网络错误
            HttpException httpEx = (HttpException) ex;
            interfaceCallBack.onFailure((HttpException) ex,((HttpException) ex).getCode());
            int responseCode = httpEx.getCode();
            String responseMsg = httpEx.getMessage();
            String errorResult = httpEx.getResult();
            Toast.makeText(x.app(), "网络错误，请检查网络", Toast.LENGTH_LONG).show();//打印系统错误
        } else if(ex instanceof DbException){ // 数据库错误
            Toast.makeText(x.app(), "请重新初始化数据库", Toast.LENGTH_LONG).show();//打印系统错误
        }else if(ex instanceof UnknownHostException){
            Toast.makeText(x.app(), "请检查网络连接", Toast.LENGTH_LONG).show();//打印系统错误
        }
    }

    /**
     * 请求取消
     * @param cex 取消错误
     */
    @Override
    public void onCancelled(CancelledException cex) {
        interfaceCallBack.onCancel();
    }

    /**
     * 请求成功
     */
    @Override
    public void onFinished() {
        interfaceCallBack.onFinish();
    }

    /**
     * 正在加载中
     * @param total
     * @param current
     * @param isDownloading
     */
    @Override
    public void onLoading(long total, long current, boolean isDownloading) {
        interfaceCallBack.onLoading(total, current, isDownloading);
    }

    /**
     * 开始加载
     */
    @Override
    public void onStarted() {
        interfaceCallBack.onStart();
    }

    @Override
    public void onWaiting() {
        interfaceCallBack.onWaiting();
    }
}
