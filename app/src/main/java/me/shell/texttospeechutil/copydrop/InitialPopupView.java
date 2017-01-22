package me.shell.texttospeechutil.copydrop;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.Toast;

import me.shell.texttospeechutil.R;

/**
 * Created by shell on 20/1/17.
 */

public class InitialPopupView extends FrameLayout {

    public static int a;
    public final WindowManager.LayoutParams mLayoutParams;
    public final WindowManager mWindowManager;

    public final View initialPopupView;
    public final View initialPopupIconContainer;
    public final View initialPopupGlow;
    public InitialPopupView mInitialPopupView;
    public int i;

    public int initialX;
    public int initialY;
    public float initialTouchX;
    public float initialTouchY;

    public int h;

    public Animation mAnimationPopupIconContainer, mAnimationPopupIconGlow;

    public InitialPopupView(final Context paramContext, WindowManager.LayoutParams paramLayoutParams) {
        super(paramContext);

        mWindowManager = (WindowManager) paramContext.getSystemService(Context.WINDOW_SERVICE);
        mLayoutParams = paramLayoutParams;

        LayoutInflater.from(getContext()).inflate(R.layout.view_copydrop_initial_popup, this, true);

        this.initialPopupView = findViewById(R.id.initial_popup_view);
        this.initialPopupIconContainer = findViewById(R.id.initial_popup_icon_container);
        this.initialPopupGlow = findViewById(R.id.initial_popup_glow);

        if (((AccessibilityManager) paramContext.getSystemService(Context.ACCESSIBILITY_SERVICE)).isTouchExplorationEnabled()) {
            this.initialPopupIconContainer.setClickable(true);
            this.initialPopupIconContainer.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(paramContext, "Clicked", Toast.LENGTH_SHORT).show();
                    Log.d("test", "Clicked");
                }
            });
            return;
        }

        mInitialPopupView = this;

        mAnimationPopupIconContainer = AnimationUtils.loadAnimation(paramContext, R.anim.initial_popup_icon_container);
        mAnimationPopupIconGlow = AnimationUtils.loadAnimation(paramContext, R.anim.intial_popup_icon_glow);

        mAnimationPopupIconContainer.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                mWindowManager.removeView(mInitialPopupView);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    public void startAnimation() {
        this.initialPopupGlow.startAnimation(mAnimationPopupIconGlow);
        this.initialPopupIconContainer.startAnimation(mAnimationPopupIconContainer);
    }

    public boolean onTouchEvent(MotionEvent paramMotionEvent) {
        switch (paramMotionEvent.getAction()) {
            case MotionEvent.ACTION_DOWN:
                initialX = mLayoutParams.x;
                initialY = mLayoutParams.y;
                initialTouchX = paramMotionEvent.getRawX();
                initialTouchY = paramMotionEvent.getRawY();
                return true;
            case MotionEvent.ACTION_UP:
                return true;
            case MotionEvent.ACTION_MOVE:
                /*mLayoutParams.x = initialX
                        + (int) (paramMotionEvent.getRawX() - initialTouchX);*/
                mLayoutParams.y = initialY
                        + (int) (paramMotionEvent.getRawY() - initialTouchY);
                mWindowManager.updateViewLayout(this, this.mLayoutParams);
                return true;
        }
        return false;
    }
}
