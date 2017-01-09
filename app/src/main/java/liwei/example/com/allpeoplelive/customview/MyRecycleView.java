package liwei.example.com.allpeoplelive.customview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * 1.类的用途
 * 2.@author:liwei
 * 3.@2017/1/5
 */

public class MyRecycleView extends RecyclerView {

    private float startX;
    private float startY;

    public MyRecycleView(Context context) {
        super(context);
    }

    public MyRecycleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyRecycleView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
	switch (ev.getAction()) {
		case MotionEvent.ACTION_DOWN:
			startY = ev.getRawY();
			startX = ev.getRawX();
			break;
		case MotionEvent.ACTION_MOVE:
			float endY = ev.getRawY();
			float endX = ev.getRawX();
			float x = endX - startX;
			float y = endY - startY;
			if(Math.abs(x)>Math.abs(y)){
				getParent().requestDisallowInterceptTouchEvent(false);
			}else if(Math.abs(y)<50){
				getParent().requestDisallowInterceptTouchEvent(true);

			}else{
				getParent().requestDisallowInterceptTouchEvent(false);
			}

			break;

	}
        return super.dispatchTouchEvent(ev);
    }
}
