package com.example.administrator.rotatemultiplepicturesdemo;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.airbnb.lottie.LottieAnimationView;
import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    private Context context;
    private int distance;
    private ImageView faceRingImageView;
    private int currentX;
    private int currentDistanceX;
    private LottieAnimationView loadingLottieAnimationView;
    private boolean isCachedInAdvance;
    private CardView faceRingCardView;
    private ImageButton arrowLeftImageButton;
    private ImageButton arrowRightImageButton;

    private int[] currentFaceRingArray = {
            R.drawable.a0, R.drawable.a1, R.drawable.a2, R.drawable.a3,
            R.drawable.a4, R.drawable.a5, R.drawable.a6, R.drawable.a7,
            R.drawable.a8, R.drawable.a9, R.drawable.a10, R.drawable.a11,
            R.drawable.a12, R.drawable.a13, R.drawable.a14, R.drawable.a15,
            R.drawable.a16, R.drawable.a17, R.drawable.a18, R.drawable.a19,
            R.drawable.a20, R.drawable.a21, R.drawable.a22, R.drawable.a23,
            R.drawable.a24, R.drawable.a25, R.drawable.a26, R.drawable.a27,
            R.drawable.a28, R.drawable.a29, R.drawable.a30, R.drawable.a31,
            R.drawable.a32, R.drawable.a33, R.drawable.a34, R.drawable.a35,
            R.drawable.a36, R.drawable.a37, R.drawable.a38, R.drawable.a39,
            R.drawable.a40, R.drawable.a41, R.drawable.a42, R.drawable.a43,
            R.drawable.a44, R.drawable.a45, R.drawable.a46, R.drawable.a47,
            R.drawable.a48, R.drawable.a49, R.drawable.a50, R.drawable.a51,
            R.drawable.a52, R.drawable.a53, R.drawable.a54, R.drawable.a55,
            R.drawable.a56, R.drawable.a57, R.drawable.a58, R.drawable.a59
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;
        faceRingImageView = findViewById(R.id.faceRingImageView);
        loadingLottieAnimationView = findViewById(R.id.loadingLottieAnimationView);
        faceRingCardView = findViewById(R.id.faceRingCardView);
        arrowLeftImageButton = findViewById(R.id.arrowLeftImageButton);
        arrowRightImageButton = findViewById(R.id.arrowRightImageButton);
        distance = 0;
        Glide.with(this)
                .load(currentFaceRingArray[distance])
                .placeholder(faceRingImageView.getDrawable())
                .dontAnimate()
                .into(faceRingImageView);

        /**
         * isCachedInAdvance 為true, 表示會提前將所有圖片加載至緩存
         * isCachedInAdvance 為false, 表示不會將所有圖片加載至緩存
         */
        isCachedInAdvance = true;
        if (isCachedInAdvance == true) {
            cachedInAdvance();
        } else {
            loadingLottieAnimationView.setVisibility(View.GONE);
            loadingLottieAnimationView.cancelAnimation();
        }
    }

    /**
     * activity被触摸后, 会回调此方法onTouchEvent, 并回传一个event对象
     * event对象封装了触摸时的动作信息, 包括x y坐标等等信息
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {

        /** 获取当前输入点的X坐标(视图坐标) */
        int x = (int) event.getX();

        switch (event.getAction()) {

            case MotionEvent.ACTION_DOWN:                                                        // 处理按下事件
                currentX = x;
                break;

            case MotionEvent.ACTION_MOVE:

                /** 处理左右滑動事件 */
                currentDistanceX = currentX - x;
                if (currentDistanceX > 20) {
                    currentX = x;
                    distance = distance + 1;
                    distance = distance % 60;

                    Glide.with(this)
                            .load(currentFaceRingArray[distance])
                            .placeholder(faceRingImageView.getDrawable())
                            .dontAnimate()
                            .into(faceRingImageView);
                }
                if (currentDistanceX < -20) {
                    currentX = x;
                    distance = distance - 1;
                    distance = distance % 60;
                    if (distance < 0) {
                        distance = distance + 60;
                    }
                    Glide.with(this)
                            .load(currentFaceRingArray[distance])
                            .placeholder(faceRingImageView.getDrawable())
                            .dontAnimate()
                            .into(faceRingImageView);
                }
                break;

            case MotionEvent.ACTION_UP:                                                            // 处理离开事件
                break;
        }
        return true;
    }

    /**
     * 提前緩存60張圖片
     */
    public void cachedInAdvance() {

        faceRingCardView.setVisibility(View.INVISIBLE);
        arrowLeftImageButton.setVisibility(View.INVISIBLE);
        arrowRightImageButton.setVisibility(View.INVISIBLE);
        loadingLottieAnimationView.setVisibility(View.VISIBLE);

        new Handler().postDelayed(new Runnable() {
            public void run() {
                CustomTouchEvent.setMoveToRight(31, (Activity) context);
            }
        }, 100);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                CustomTouchEvent.setMoveToRight(31, (Activity) context);
            }
        }, 200);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                CustomTouchEvent.setMoveToRight(31, (Activity) context);
            }
        }, 300);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                CustomTouchEvent.setMoveToRight(31, (Activity) context);
            }
        }, 400);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                CustomTouchEvent.setMoveToRight(31, (Activity) context);
            }
        }, 500);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                CustomTouchEvent.setMoveToRight(31, (Activity) context);
            }
        }, 600);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                CustomTouchEvent.setMoveToRight(31, (Activity) context);
            }
        }, 700);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                CustomTouchEvent.setMoveToRight(31, (Activity) context);
            }
        }, 800);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                CustomTouchEvent.setMoveToRight(31, (Activity) context);
            }
        }, 900);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                CustomTouchEvent.setMoveToRight(31, (Activity) context);
            }
        }, 1000);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                CustomTouchEvent.setMoveToRight(31, (Activity) context);
            }
        }, 1100);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                CustomTouchEvent.setMoveToRight(31, (Activity) context);
            }
        }, 1200);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                CustomTouchEvent.setMoveToRight(31, (Activity) context);
            }
        }, 1300);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                CustomTouchEvent.setMoveToRight(31, (Activity) context);
            }
        }, 1400);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                CustomTouchEvent.setMoveToRight(31, (Activity) context);
            }
        }, 1500);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                CustomTouchEvent.setMoveToRight(31, (Activity) context);
            }
        }, 1600);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                CustomTouchEvent.setMoveToRight(31, (Activity) context);
            }
        }, 1700);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                CustomTouchEvent.setMoveToRight(31, (Activity) context);
            }
        }, 1800);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                CustomTouchEvent.setMoveToRight(31, (Activity) context);
            }
        }, 1900);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                CustomTouchEvent.setMoveToRight(31, (Activity) context);
            }
        }, 2000);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                CustomTouchEvent.setMoveToRight(31, (Activity) context);
            }
        }, 2100);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                CustomTouchEvent.setMoveToRight(31, (Activity) context);
            }
        }, 2200);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                CustomTouchEvent.setMoveToRight(31, (Activity) context);
            }
        }, 2300);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                CustomTouchEvent.setMoveToRight(31, (Activity) context);
            }
        }, 2400);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                CustomTouchEvent.setMoveToRight(31, (Activity) context);
            }
        }, 2500);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                CustomTouchEvent.setMoveToRight(31, (Activity) context);
            }
        }, 2600);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                CustomTouchEvent.setMoveToRight(31, (Activity) context);
            }
        }, 2700);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                CustomTouchEvent.setMoveToRight(31, (Activity) context);
            }
        }, 2800);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                CustomTouchEvent.setMoveToRight(31, (Activity) context);
            }
        }, 2900);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                CustomTouchEvent.setMoveToRight(31, (Activity) context);
            }
        }, 3000);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                CustomTouchEvent.setMoveToRight(31, (Activity) context);
            }
        }, 3100);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                CustomTouchEvent.setMoveToRight(31, (Activity) context);
            }
        }, 3200);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                CustomTouchEvent.setMoveToRight(31, (Activity) context);
            }
        }, 3300);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                CustomTouchEvent.setMoveToRight(31, (Activity) context);
            }
        }, 3400);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                CustomTouchEvent.setMoveToRight(31, (Activity) context);
            }
        }, 3500);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                CustomTouchEvent.setMoveToRight(31, (Activity) context);
            }
        }, 3600);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                CustomTouchEvent.setMoveToRight(31, (Activity) context);
            }
        }, 3700);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                CustomTouchEvent.setMoveToRight(31, (Activity) context);
            }
        }, 3800);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                CustomTouchEvent.setMoveToRight(31, (Activity) context);
            }
        }, 3900);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                CustomTouchEvent.setMoveToRight(31, (Activity) context);
            }
        }, 4000);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                CustomTouchEvent.setMoveToRight(31, (Activity) context);
            }
        }, 4100);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                CustomTouchEvent.setMoveToRight(31, (Activity) context);
            }
        }, 4200);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                CustomTouchEvent.setMoveToRight(31, (Activity) context);
            }
        }, 4300);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                CustomTouchEvent.setMoveToRight(31, (Activity) context);
            }
        }, 4400);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                CustomTouchEvent.setMoveToRight(31, (Activity) context);
            }
        }, 4500);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                CustomTouchEvent.setMoveToRight(31, (Activity) context);
            }
        }, 4600);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                CustomTouchEvent.setMoveToRight(31, (Activity) context);
            }
        }, 4700);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                CustomTouchEvent.setMoveToRight(31, (Activity) context);
            }
        }, 4800);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                CustomTouchEvent.setMoveToRight(31, (Activity) context);
            }
        }, 4900);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                CustomTouchEvent.setMoveToRight(31, (Activity) context);
            }
        }, 5000);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                CustomTouchEvent.setMoveToRight(31, (Activity) context);
            }
        }, 5100);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                CustomTouchEvent.setMoveToRight(31, (Activity) context);
            }
        }, 5200);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                CustomTouchEvent.setMoveToRight(31, (Activity) context);
            }
        }, 5300);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                CustomTouchEvent.setMoveToRight(31, (Activity) context);
            }
        }, 5400);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                CustomTouchEvent.setMoveToRight(31, (Activity) context);
            }
        }, 5500);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                CustomTouchEvent.setMoveToRight(31, (Activity) context);
            }
        }, 5600);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                CustomTouchEvent.setMoveToRight(31, (Activity) context);
            }
        }, 5700);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                CustomTouchEvent.setMoveToRight(31, (Activity) context);
            }
        }, 5800);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                CustomTouchEvent.setMoveToRight(31, (Activity) context);
            }
        }, 5900);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                CustomTouchEvent.setMoveToRight(31, (Activity) context);
            }
        }, 6000);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                loadingLottieAnimationView.setVisibility(View.GONE);
                loadingLottieAnimationView.cancelAnimation();
            }
        }, 6100);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                faceRingCardView.setVisibility(View.VISIBLE);
                arrowLeftImageButton.setVisibility(View.VISIBLE);
                arrowRightImageButton.setVisibility(View.VISIBLE);
            }
        }, 6200);
    }
}
