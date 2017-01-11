package com.li.pc.lutils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.util.Linkify;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;


/**
 * author   ：mo
 * data     ：2016/12/19
 * time     ：16:10
 * function : 通用ViewHolder
 */

public class CommonBaseViewHolder {
    private Context mContext;
    private final SparseArray<View> mViews;
    private int mPosition;
    private View mConvertView;
    private int mLayoutId;

    private CommonBaseViewHolder(Context context, ViewGroup parent, int layoutId, int position) {
        mContext = context;
        mLayoutId = layoutId;
        this.mPosition = position;
        this.mViews = new SparseArray<View>();
        mConvertView = LayoutInflater.from(context).inflate(layoutId, parent, false);
        // setTag
        mConvertView.setTag(this);
    }

    /**
     * 拿到一个ViewHolder对象
     *
     * @param context
     * @param convertView
     * @param parent
     * @param layoutId
     * @param position
     * @return
     */
    public static CommonBaseViewHolder get(Context context, View convertView, ViewGroup parent, int layoutId, int position) {
        CommonBaseViewHolder commonBaseViewHolder = null;
        if (convertView == null) {
            commonBaseViewHolder = new CommonBaseViewHolder(context, parent, layoutId, position);
            convertView = commonBaseViewHolder.mConvertView;
        } else {
            commonBaseViewHolder = (CommonBaseViewHolder) convertView .getTag(layoutId);
            if(commonBaseViewHolder == null) {
                commonBaseViewHolder = new CommonBaseViewHolder(context, parent, layoutId, position);
                convertView = commonBaseViewHolder.mConvertView;
            }
        }
        commonBaseViewHolder.mPosition = position;
        return commonBaseViewHolder;
    }

    /**
     * 获取转换布局
     *
     * @return 返回convertView
     */
    public View getConvertView() {
        return mConvertView;
    }

    /**
     * 获取当前数据和布局位于整体数据和所有布局中的位置
     *
     * @return 当前的位置
     */
    public int getPosition() {
        return mPosition;
    }

    /**
     * 获取当前布局id
     * @return
     */
    public int getLayoutId() {
        return mLayoutId;
    }

    /**
     * 通过控件的Id获取对于的控件，如果没有则加入views
     *
     * @param viewId
     * @return
     */
    public <T extends View> T getView(int viewId) {
        View view = mViews.get(viewId);
        if (view == null) {
            view = mConvertView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T) view;
    }
    /**
     * 设置控件显示状态
     *
     * @param viewId
     * @param visibility
     */
    public void setViewVisiblity(int viewId, int visibility) {
        View view = getView(viewId);
        view.setVisibility(visibility);
    }
    /**
     * 设置控件点击事件
     *
     * @param viewId
     * @param listener
     * @return
     */
    public CommonBaseViewHolder setClickListener(int viewId, View.OnClickListener listener) {
        View view = getView(viewId);
        view.setOnClickListener(listener);
        return this;
    }

    /**
     * 设置控件滑动事件
     * @param viewId
     * @param listener
     * @return
     */
    public CommonBaseViewHolder setOnTouchListener(int viewId, View.OnTouchListener listener) {
        View view = getView(viewId);
        view.setOnTouchListener(listener);
        return this;
    }

    /**
     * 设置控件长按事件
     * @param viewId
     * @param listener
     * @return
     */
    public CommonBaseViewHolder setOnLongClickListener(int viewId, View.OnLongClickListener listener) {
        View view = getView(viewId);
        view.setOnLongClickListener(listener);
        return this;
    }
    /**
     * 为TextView设置字符串--string
     *
     * @param viewId
     * @param text
     * @return
     */
    public CommonBaseViewHolder setText(int viewId, String text) {
        TextView view = getView(viewId);
        view.setText(text);
        return this;
    }

    /**
     * 为TextView设置字符颜色
     * @param viewId
     * @param textColor
     * @return
     */
    public CommonBaseViewHolder setTextColor(int viewId, int textColor) {
        TextView view = getView(viewId);
        view.setTextColor(textColor);
        return this;
    }

    /**
     * 为TextView设置字符颜色-res
     * @param viewId
     * @param textColorRes
     * @return
     */
    public CommonBaseViewHolder setTextColorRes(int viewId, int textColorRes) {
        TextView view = getView(viewId);
        view.setTextColor(mContext.getResources().getColor(textColorRes));
        return this;
    }
    /**
     * 为ImageView设置图片--res
     *
     * @param viewId
     * @param drawableId
     * @return
     */
    public CommonBaseViewHolder setImageResource(int viewId, int drawableId) {
        ImageView view = getView(viewId);
        view.setImageResource(drawableId);
        return this;
    }

    /**
     * 为ImageView设置图片-bitmap
     *
     * @param viewId
     * @param bm
     * @return
     */
    public CommonBaseViewHolder setImageBitmap(int viewId, Bitmap bm) {
        ImageView view = getView(viewId);
        view.setImageBitmap(bm);
        return this;
    }

    /**
     * 为ImageView设置图片-Drawable
     * @param viewId
     * @param drawable
     * @return
     */
    public CommonBaseViewHolder setImageDrawable(int viewId, Drawable drawable) {
        ImageView view = getView(viewId);
        view.setImageDrawable(drawable);
        return this;
    }
    /**
     * 为ImageView设置图片-网络加载
     *
     * @param viewId
     * @param url
     * @return
     */
    public CommonBaseViewHolder setImageByUrl(int viewId, String url) {
//        ImageLoader.getInstance(3, Type.LIFO).loadImage(url, (ImageView) getView(viewId));
//        x.image().bind((ImageView) getView(viewId), url);
        return this;
    }
    /**
     * 设置控件背景--圆角图片
     *
     * @param viewId
     * @param res
     * @param resId
     * @return
     */
    public CommonBaseViewHolder setImageBitmapRound(int viewId, Resources res, int resId, int roundPiexl) {
        ImageView imageView = getView(viewId);
        Bitmap bitmap = BitmapFactory.decodeResource(res, resId);
        imageView.setImageBitmap(getRoundedCornerBitmap(bitmap, roundPiexl));
        return this;
    }
    /**
     * 设置控件背景--res
     *
     * @param viewId
     * @param resId
     * @return
     */
    public CommonBaseViewHolder setBackgroundRes(int viewId, int resId) {
        View view = getView(viewId);
        view.setBackgroundResource(resId);
        return this;
    }

    /**
     * 设置控件背景
     * @param viewId
     * @param color
     * @return
     */
    public CommonBaseViewHolder setBackgroundColor(int viewId, int color) {
        View view = getView(viewId);
        view.setBackgroundColor(color);
        return this;
    }


    /**
     * 给bitmap设置圆角
     *
     * @param bitmap
     * @param roundPiexl
     * @return
     */
    public static Bitmap getRoundedCornerBitmap(Bitmap bitmap, int roundPiexl) {
        Bitmap output = Bitmap.createBitmap(bitmap.getWidth(),
                bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);

        final int color = 0xff424242;
        final Paint paint = new Paint();
        final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        final RectF rectF = new RectF(rect);

        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(color);
        canvas.drawRoundRect(rectF, roundPiexl, roundPiexl, paint);

        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);

        return output;
    }



    /**
     * 设置控件动画
     * @param viewId
     * @param value
     * @return
     */
    @SuppressLint("NewApi")
    public CommonBaseViewHolder setAlpha(int viewId, float value) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            getView(viewId).setAlpha(value);
        } else {
            // Pre-honeycomb hack to set Alpha value
            AlphaAnimation alpha = new AlphaAnimation(value, value);
            alpha.setDuration(0);
            alpha.setFillAfter(true);
            getView(viewId).startAnimation(alpha);
        }
        return this;
    }

    /**
     * 设置超链接识别
     * @param viewId
     * @return
     */
    public CommonBaseViewHolder setLinkify(int viewId) {
        TextView view = getView(viewId);
        Linkify.addLinks(view, Linkify.ALL);
        return this;
    }

    /**
     * 设置进度条
     * @param viewId
     * @param progress
     * @return
     */
    public CommonBaseViewHolder setProgress(int viewId, int progress) {
        ProgressBar view = getView(viewId);
        view.setProgress(progress);
        return this;
    }
    public CommonBaseViewHolder setProgress(int viewId, int progress, int max) {
        ProgressBar view = getView(viewId);
        view.setMax(max);
        view.setProgress(progress);
        return this;
    }

    public CommonBaseViewHolder setMax(int viewId, int max) {
        ProgressBar view = getView(viewId);
        view.setMax(max);
        return this;
    }

    /**
     * 设置评分控件---五角星
     * @param viewId
     * @param rating
     * @return
     */
    public CommonBaseViewHolder setRating(int viewId, float rating) {
        RatingBar view = getView(viewId);
        view.setRating(rating);
        return this;
    }

    public CommonBaseViewHolder setRating(int viewId, float rating, int max) {
        RatingBar view = getView(viewId);
        view.setMax(max);
        view.setRating(rating);
        return this;
    }
    public CommonBaseViewHolder setTag(int viewId, Object tag) {
        View view = getView(viewId);
        view.setTag(tag);
        return this;
    }

    public CommonBaseViewHolder setTag(int viewId, int key, Object tag) {
        View view = getView(viewId);
        view.setTag(key, tag);
        return this;
    }

    public CommonBaseViewHolder setChecked(int viewId, boolean checked) {
        Checkable view = (Checkable) getView(viewId);
        view.setChecked(checked);
        return this;
    }

}
