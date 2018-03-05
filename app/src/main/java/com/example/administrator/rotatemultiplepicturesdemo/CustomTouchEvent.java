package com.example.administrator.rotatemultiplepicturesdemo;

import android.app.Activity;
import android.os.SystemClock;
import android.view.MotionEvent;

/**
 * 模拟点击屏幕、滑动屏幕等操作
 */
public class CustomTouchEvent {

    /**
     * 模拟向右滑动事件
     *
     * @param distance 滑动的距离
     * @param activity 传进去的活动对象
     */
    public static void setMoveToRight(int distance, Activity activity) {
        activity.dispatchTouchEvent(MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(),
                MotionEvent.ACTION_DOWN, 400, 500, 0));
        activity.dispatchTouchEvent(MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(),
                MotionEvent.ACTION_MOVE, 400 + distance, 500, 0));
        activity.dispatchTouchEvent(MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(),
                MotionEvent.ACTION_UP, 400 + distance, 500, 0));
    }
}
