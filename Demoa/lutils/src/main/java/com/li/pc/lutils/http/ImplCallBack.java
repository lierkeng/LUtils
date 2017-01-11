package com.li.pc.lutils.http;

/**
 * author   ：mo
 * data     ：2017/1/11
 * time     ：17:39
 * function :抽象回调类，向使用者展示数据时的回调===第二层
 */

public abstract class ImplCallBack<T> implements InterfaceCallBack<T> {
    /**
     * 开始处理数据
     */
    @Override
    public void onStart() {
    }
    /**
     * 当数据处理失败的时候
     * @param  ex 异常类型
     * @param Code 错误代码
     */
    @Override
    public void onFailure(Throwable ex, int Code) {

    }
    /**
     * 当数据请求成功的时候进行回调数据
     * @param result
     */
    @Override
    public void onSuccessData(T result) {

    }
    /**
     * 在数据处理时的状态显示
     * @param total
     * @param current
     * @param isUploading
     */
    @Override
    public void onLoading(long total, long current, boolean isUploading) {

    }
    /**
     * 处理数据取消
     */
    @Override
    public void onCancel() {

    }
    /**
     * 处理数据结束
     */
    @Override
    public void onFinish() {

    }

    @Override
    public void onWaiting() {

    }
}
