package com.sparrow.kidsapp.Utility;

import android.view.MotionEvent;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

public class ZoomLayoutManager extends RecyclerView.LayoutManager {

    private int currentItem = 0;
    private float scaleFactor = 1f;

    @Override
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        for (int i = 0; i < getChildCount(); i++) {
            View child = getChildAt(i);
            int position = getPosition(child);

            if (position == currentItem) {
                child.setScaleX(scaleFactor);
                child.setScaleY(scaleFactor);
            } else {
                child.setScaleX(1f);
                child.setScaleY(1f);
            }
        }
    }

    @Override
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return null;
    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        if (e.getAction() == MotionEvent.ACTION_DOWN) {
            float x = e.getX();
            float y = e.getY();

            View child = rv.findChildViewUnder(x, y);
            if (child != null) {
                currentItem = getPosition(child);
                scaleFactor = 1.5f;
                rv.invalidate();
            }
        }

        return false;
    }

    public void setCurrentItem(int currentItem) {
        this.currentItem = currentItem;
        this.scaleFactor = 1.5f;
        this.invalidate();
    }

    public void reset() {
        this.currentItem = 0;
        this.scaleFactor = 1f;
        this.invalidate();
    }
}
