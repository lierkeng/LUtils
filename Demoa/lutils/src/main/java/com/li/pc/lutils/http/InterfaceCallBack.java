package com.li.pc.lutils.http;



/**
 * author   ：mo
 * data     ：2017/1/11
 * time     ：17:33
 * function : 回调接口，向外暴露所有的回调状态接口===第一层
 */

public interface InterfaceCallBack<T> {
    /**
     * 开始处理数据
     */
    void onStart();
    /**
     * 当数据处理失败的时候
     * @param  ex 异常类型
     * @param Code 错误代码
     */
    void onFailure(Throwable ex, int Code);

    /**
     * 当数据请求成功的时候进行回调数据
     * @param result
     */
    void onSuccessData(T result);

    /**
     * 在数据处理时的状态显示
     * @param total
     * @param current
     * @param isUploading
     */
    void onLoading(long total, long current, boolean isUploading);

    /**
     * 处理数据取消
     */
    void onCancel();

    /**
     * 处理数据结束
     */
    void onFinish();

    void onWaiting();
}
