package com.li.pc.lutils.utils;

import android.app.ProgressDialog;
import android.content.Context;

import com.li.pc.lutils.R;


/**
 * author   ：mo
 * data     ：2016/11/23
 * time     ：16:19
 * function :进度条工具类
 */

public class UtilsProgressDlg {
    static ProgressDialog progressDlg = null;

    /**
     * 启动进度条
     *
     * @param strMessage
     *            进度条显示的信息
     *            当前的activity
     */
    public static void showProgressDlg(Context ctx, String setTitle , String strMessage, int i) {

        if (null == progressDlg) {
            progressDlg = new ProgressDialog(ctx);
            //设置进度条样式
            progressDlg.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            //设置进度条标题
            progressDlg.setTitle(setTitle);
            //提示的消息
            progressDlg.setMessage(strMessage);
            progressDlg.setIndeterminate(false);
            progressDlg.setCancelable(false);
            progressDlg.setIcon(i);
            progressDlg.show();
        }
    }
    public static ProgressDialog getCustomProgress(Context context){
        ProgressDialog progressDialog=new ProgressDialog(context);
        progressDialog.setTitle("消息");
        progressDialog.setMessage("正在下载中，请稍候。。。");
        progressDialog.setIcon(R.mipmap.progress_1);
        return progressDialog;
    }
    /**
     * 结束进度条
     */
    public static void stopProgressDlg() {
        if (null != progressDlg) {
            progressDlg.dismiss();
            progressDlg = null;
        }
    }
}
