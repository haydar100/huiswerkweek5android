package com.haydar.huiswerkweek5;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.ImageView;


public class MainView extends ImageView {
    private final int colorBall = Color.BLACK;
    private int width, height;
    private int x = 100, y = 100;

    public MainView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        if (widthMode == MeasureSpec.EXACTLY) {
            width = widthSize;
        } else if (widthMode == MeasureSpec.AT_MOST) {
            width = 150;
        }

        if (heightMode == MeasureSpec.EXACTLY) {
            height = heightSize;
        } else if (heightMode == MeasureSpec.AT_MOST) {
            height = 150;
        }

        setMeasuredDimension(width, height);
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(colorBall);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(x, y, 50, paint);
    }

    public void naarLinks() {
        x += 5;
        invalidate();
    }

    public void naarRechts() {
        x -= 5;
        invalidate();
    }

    public void naarOnder() {
        y += 5;
        invalidate();
    }

    public void naarBoven() {
        y -= 5;
        invalidate();
    }

}
