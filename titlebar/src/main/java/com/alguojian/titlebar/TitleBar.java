package com.alguojian.titlebar;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * 自定义头部-toolbar
 * 2018/4/12
 *
 * @author alguojian
 */

public class TitleBar extends RelativeLayout {

    private String titleText;
    private float titleTextSize;
    private int titleTextColor;


    private String rightTitleText;
    private int rightTitleTextSize;
    private int rightTitleTextColor;


    public TitleBar(Context context) {
        super(context);

    }

    public TitleBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.titleBar);

//         titleTextSize = typedArray.getDimension(R.styleable.titleBar_titleSize,30);

//        int textColor = typedArray.getColor(R.styleable.titleBar, ContextCompat.getColor(context,R.color.colorAccent1));


        //用完之后回收
        typedArray.recycle();

        View inflate = LayoutInflater.from(context).inflate(R.layout.titlebarview, this);

        ImageButton viewById = inflate.findViewById(R.id.finish);
        TextView rightTextView = inflate.findViewById(R.id.rightText);

        viewById.setOnClickListener(v -> {

            if (getContext() instanceof Activity)
                ((Activity) getContext()).finish();

        });

        rightTextView.setOnClickListener(v -> {

            if (null != rightClickCallBack)
                rightClickCallBack.click();
        });
    }

    public TitleBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setRightClickListener(RightClickCallBack rightClickListener) {

        this.rightClickCallBack = rightClickListener;
    }


    private RightClickCallBack rightClickCallBack;

    public interface RightClickCallBack {

        void click();
    }


}
