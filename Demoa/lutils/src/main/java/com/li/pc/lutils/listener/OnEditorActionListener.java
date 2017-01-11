package com.li.pc.lutils.listener;

import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;

import org.xutils.common.util.LogUtil;


/**
 * author   ：mo
 * data     ：2016/12/16
 * time     ：19:28
 * function :针对软键盘的编辑开始后进行监听，
 * 给文本框添加编辑监听事件,并且改变软键盘某些按键的功能
 *
 * 添加状态；(可设置多个状态)
 * 1布局；
 * <EditText android:id="@+id/txtTest2"
 * android:imeOptions="actionSend"
 * android:layout_width="fill_parent"
 * android:inputType="number"
 * android:layout_height="wrap_content"
 * android:hint="发送"
 * />
 * 2代码
 * edit.setImeOptions(EditorInfo.IME_ACTION_SEND)
 */

public abstract class OnEditorActionListener implements TextView.OnEditorActionListener {
    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if (actionId == EditorInfo.IME_ACTION_GO) {
            LogUtil.i("========功能===============" + "去往");
            doWhat(v, actionId, event);
        } else if (actionId == EditorInfo.IME_ACTION_SEARCH) {
            LogUtil.i("========功能===============" + "搜索");
            doWhat(v, actionId, event);
        } else if (actionId == EditorInfo.IME_ACTION_SEND) {
            LogUtil.i("========功能===============" + "发送");
            doWhat(v, actionId, event);
        } else if (actionId == EditorInfo.IME_ACTION_NEXT) {
            LogUtil.i("========功能===============" + "下一个");
            doWhat(v, actionId, event);
        } else if (actionId == EditorInfo.IME_ACTION_DONE) {
            LogUtil.i("========功能===============" + "完成");
            doWhat(v, actionId, event);
        } else if (actionId == EditorInfo.IME_ACTION_UNSPECIFIED) {
            LogUtil.i("========功能===============" + "未指定");
            doWhat(v, actionId, event);
        }
        return false;
    }

    /**
     * 通用方法
     * @param v        可以取到里面输入的内容，按了换行也会执行换行后的输出
     * @param actionId 动作标识，是跟EditorInfo.IME_**这里的值对比可以判断执行了什么动作
     * @param event    事件，跟KeyEvent.ACTION_**比较值判断他的事件
     */
    protected abstract void doWhat(TextView v, int actionId, KeyEvent event);
}
