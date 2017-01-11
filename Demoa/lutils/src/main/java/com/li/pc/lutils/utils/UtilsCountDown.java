package com.li.pc.lutils.utils;

import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

/**
 * author   ：mo
 * data     ：2016/12/3
 * time     ：11:23
 * function : 倒计时工具类
 * 默认60秒
 */

public class UtilsCountDown {
    private int time = 60;

    private Timer timer;

    private TextView btnSure;

    private String btnText;

    public UtilsCountDown(TextView btnSure, String btnText) {
        super();
        this.btnSure = btnSure;
        this.btnText = btnText;
    }
    public UtilsCountDown(TextView btnSure, String btnText, int time) {
        super();
        this.btnSure = btnSure;
        this.btnText = btnText;
        this.time = time;
    }

    public void RunTimer() {
        timer = new Timer();
        TimerTask task = new TimerTask() {

            @Override
            public void run() {
                time--;
                Message msg = handler.obtainMessage();
                msg.what = 1;
                handler.sendMessage(msg);

            }
        };


        timer.schedule(task, 100, 1000);
    }


    private Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:

                    if (time > 0) {
                        btnSure.setEnabled(false);
                        btnSure.setText(time + "s");
                        btnSure.setTextSize(14);
                    } else {

                        timer.cancel();
                        btnSure.setText(btnText);
                        btnSure.setEnabled(true);
                        btnSure.setTextSize(14);
                    }

                    break;


                default:
                    break;
            }

        }
    };
//    private int recLen = 60;
//    private Timer timer = new Timer();
//    private Handler mHandler = new Handler();
//    TimerTask task = new TimerTask() {
//        @Override
//        public void run() {
//            mHandler.post(new Runnable() {
//                @Override
//                public void run() {
//                    setButtonStatusOff();
//                    if (recLen < 1) {
//                        setButtonStatusOn();
//                    }
//                }
//            });
//        }
//    };
//
//    timer = new Timer();
//    timer.schedule(task, 0, 1000);
//
//}
//
//    private void setButtonStatusOff() {
//        getVerifiCodeButton.setText(String.format(
//                mContext.getResources().getString(R.string.count_down), recLen--));
//        getVerifiCodeButton.setClickable(false);
//        getVerifiCodeButton.setTextColor(Color.parseColor("#f3f4f8"));
//        getVerifiCodeButton.setBackgroundColor(Color.parseColor("#b1b1b3"));
//    }
//
//    private void setButtonStatusOn() {
//        timer.cancel();
//        getVerifiCodeButton.setText("重新发送");
//        getVerifiCodeButton.setTextColor(Color.parseColor("#b1b1b3"));
//        getVerifiCodeButton.setBackgroundColor(Color.parseColor("#f3f4f8"));
//        recLen = 60;
//        getVerifiCodeButton.setClickable(true);
//    }

}
