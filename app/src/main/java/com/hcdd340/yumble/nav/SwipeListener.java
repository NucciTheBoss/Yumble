package com.hcdd340.yumble.nav;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

public class SwipeListener implements View.OnTouchListener {
    private final GestureDetector gestureDetector;

    public SwipeListener(Context context) {
        gestureDetector = new GestureDetector(context, new GestureListener());
    }

    // Capture when the user touches the screen
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return gestureDetector.onTouchEvent(motionEvent);
    }

    private final class GestureListener extends GestureDetector.SimpleOnGestureListener {
        private static final int SWIPE_THRESHOLD = 100;
        private static final int SWIPE_VELOCITY_THRESHOLD = 100;

        // Capture when the user is holding down on the screen
        @Override
        public boolean onDown(MotionEvent e) {
            return true;
        }

        // Fancy calculator for which direction user swipes
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float veloX, float veloY) {
            boolean res = false;

            try {
                float diffY = e2.getY() - e1.getY();
                float diffX = e2.getX() - e1.getX();

                if (Math.abs(diffX) > Math.abs(diffY)) {
                    if (Math.abs(diffX) > SWIPE_THRESHOLD && Math.abs(veloX) > SWIPE_VELOCITY_THRESHOLD) {
                        if (diffX > 0) {
                            onSwipeRight();
                        } else {
                            onSwipeLeft();
                        }
                        res = true;
                    }
                }
                else if (Math.abs(diffY) > SWIPE_THRESHOLD && Math.abs(veloY) > SWIPE_VELOCITY_THRESHOLD) {
                    if (diffY > 0) {
                        onSwipeBottom();
                    } else {
                        onSwipeTop();
                    }
                    res = true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            return res;
        }
    }
    
    // Swipe events to help change screen based on touched view
    public void onSwipeRight() {}
    public void onSwipeLeft() {}
    public void onSwipeBottom() {}
    public void onSwipeTop() {}
}
