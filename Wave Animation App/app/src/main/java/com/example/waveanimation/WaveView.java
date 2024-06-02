package com.example.waveanimation;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.animation.ValueAnimator;

public class WaveView extends View implements ValueAnimator.AnimatorUpdateListener {
    private Paint wavePaint;
    private float frequency = 1.5f;
    private float amplitude = 50;
    private float phaseShift = 5;
    private float phase = 0;
    private ValueAnimator animator;

    public WaveView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        wavePaint = new Paint();
        wavePaint.setColor(0xFF6C9ECD);
        wavePaint.setStyle(Paint.Style.FILL);
        wavePaint.setAntiAlias(true);

        animator = ValueAnimator.ofFloat(0, (float) (2 * Math.PI));
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setDuration(10000);
        animator.addUpdateListener(this);
        animator.start();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int width = getWidth();
        int height = getHeight();
        int centerY = height / 2;

        float[] waveY = new float[width];

        for (int i = 0; i < width; i++) {
            waveY[i] = (float) (centerY + amplitude * Math.sin(frequency * i + phase));
        }

        for (int i = 0; i < width - 1; i++) {
            canvas.drawLine(i, waveY[i], i + 1, waveY[i + 1], wavePaint);
        }
    }

    @Override
    public void onAnimationUpdate(ValueAnimator animation) {
        phase -= phaseShift;
        invalidate();
    }
}
