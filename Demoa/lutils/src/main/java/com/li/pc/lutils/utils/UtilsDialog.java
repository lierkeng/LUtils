package com.li.pc.lutils.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.AnimationDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.li.pc.lutils.R;


/**
 * author   ：mo
 * data     ：2016/11/23
 * time     ：16:08
 * function : 对话框工具类
 */

public class UtilsDialog {

    // 因为本类不是activity所以通过继承接口的方法获取到点击的事件
    public interface OnClickYesListener {
        abstract void onClickYes();
    }

    /**
     * 提问框的 Listener
     *
     */
    public interface OnClickNoListener {
        abstract void onClickNo();
    }
    /**
     * 提问框的 Listener
     *    UiHelper.showQuestionDialog(ShowDialogActivity.this, "提示", "是否确定", new OnClickYesListener()
     * @author Lei
     */
    public static void showQuestionDialog(Context context, String title,
                                          String text, String yes, String no, final OnClickYesListener listenerYes,
                                          final OnClickNoListener listenerNo) {

        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        if (!isBlank(text)) {
            // 此方法为dialog写布局
            final TextView textView = new TextView(context);
            textView.setText(text);
            LinearLayout layout = new LinearLayout(context);
            layout.setPadding(10, 0, 10, 0);
            layout.addView(textView, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT));
            builder.setView(layout);
        }
        // 设置title
        builder.setTitle(title);
        // 设置确定按钮，固定用法声明一个按钮用这个setPositiveButton
        builder.setPositiveButton(yes,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // 如果确定被电击
                        if (listenerYes != null) {
                            listenerYes.onClickYes();
                        }
                    }
                });
        // 设置取消按钮，固定用法声明第二个按钮要用setNegativeButton
        builder.setNegativeButton(no,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // 如果取消被点击
                        if (listenerNo != null) {
                            listenerNo.onClickNo();
                        }
                    }
                });

        // 控制这个dialog可不可以按返回键，true为可以，false为不可以
        builder.setCancelable(false);
        // 显示dialog
        builder.create().show();

    }

    /**
     * 处理字符的方法
     *
     * @param str
     * @return
     */
    public static boolean isBlank(String str) {
        int strLen;
        if (str == null || (strLen = str.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if ((Character.isWhitespace(str.charAt(i)) == false)) {
                return false;
            }
        }
        return true;
    }
    private static Dialog loadingDialog;


    /**
     * 得到自定义的progressDialog
     * @param context
     * @return 返回一个dialog
     */
    private static Dialog createDialog(Context context) {

        View view = LayoutInflater.from(context).inflate(R.layout.dialog_loading, null);// 得到加载view
        ImageView spaceshipImage = (ImageView) view.findViewById(R.id.img);
        spaceshipImage.setBackgroundResource(R.drawable.dialog_rotate);
        AnimationDrawable drawable = (AnimationDrawable) spaceshipImage.getBackground();
        drawable.start();
        loadingDialog = new Dialog(context, R.style.loading_dialog);// 创建自定义样式dialog

//        loadingDialog.setCancelable(false);// 不可以用“返回键”取消
        loadingDialog.setContentView(view, new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));// 设置布局
        loadingDialog.setCancelable(false);
        loadingDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                loadingDialog = null;
            }
        });

        return loadingDialog;
    }

    /**
     * 设置能否取消
     * @param cancelable
     * @return 返回一个dialog
     */
    private static void  setCancelable(boolean cancelable) {
        loadingDialog.setCancelable(cancelable);
    }



    public static void showDialog(Context context) {
        if (loadingDialog == null)
            createDialog(context);
        loadingDialog.show();
    }

    public static void hintDialog() {
        if (loadingDialog == null)
            return;
        loadingDialog.dismiss();
    }

    public interface EnterOrBackDialogListener {

        void onWarningDialogOK(int id);

        void onWarningDialogCancel(int id);
    }

    /**
     * @param context      上下文参数
     * @param id           dialog的id
     * @param warning      警告的内容
     * @param title        标题
     * @param positiveText
     * @param negativeText 标题
     * @param listener     重写方法
     * @return
     */
    public static Dialog createDialogYesNoWarming(final Context context,
                                                  final int id, String warning, String title, String positiveText, String negativeText,
                                                  final EnterOrBackDialogListener listener) {

        return new AlertDialog.Builder(context)
                .setTitle(title)
                .setMessage(warning)
                .setPositiveButton(positiveText, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        if (context instanceof Activity) {
                            ((Activity) context).removeDialog(id);
                        }
                        if (listener != null)
                            listener.onWarningDialogOK(id);
                    }
                })
                .setNegativeButton(negativeText, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        if (context instanceof Activity) {
                            ((Activity) context).removeDialog(id);

                            if (listener != null)
                                listener.onWarningDialogCancel(id);
                        }
                    }
                }).create();
    }
    public static Dialog createDialogYesNoWarmingNoCancel(final Context context,
                                                          final int id, String warning, String title, String positiveText, String negativeText,
                                                          final EnterOrBackDialogListener listener) {

        return new AlertDialog.Builder(context)
                .setTitle(title)
                .setMessage(warning)
                .setCancelable(false)
                .setPositiveButton(positiveText, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        if (context instanceof Activity) {
                            ((Activity) context).removeDialog(id);
                        }
                        if (listener != null)
                            listener.onWarningDialogOK(id);
                    }
                })
                .setNegativeButton(negativeText, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        if (context instanceof Activity) {
                            ((Activity) context).removeDialog(id);

                            if (listener != null)
                                listener.onWarningDialogCancel(id);
                        }
                    }
                }).create();
    }


}
