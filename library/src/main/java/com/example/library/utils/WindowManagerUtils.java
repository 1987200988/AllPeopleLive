package com.example.library.utils;

import android.content.Context;
import android.graphics.PixelFormat;
import android.view.View;
import android.view.WindowManager;
/**
 * Created by 李韦 on 2016/11/3.
 */
public class WindowManagerUtils {
private static WindowManager mWindowManager;
private static View mNightView;
public static void showWindow(Context context) {
    mWindowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
    mNightView = new View(context);
    WindowManager.LayoutParams lp = new WindowManager.LayoutParams(
               WindowManager.LayoutParams.MATCH_PARENT,
               WindowManager.LayoutParams.MATCH_PARENT,
               WindowManager.LayoutParams.TYPE_APPLICATION,
               WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE |
 WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
               PixelFormat.TRANSLUCENT);
     mNightView.setBackgroundColor(0xaa000000);
     mWindowManager.addView(mNightView, lp);

}
public static void removeWindow() {
    // TODO Auto-generated method stub
    if(mWindowManager==null||mNightView==null){
        
        return;
    }
    mWindowManager.removeViewImmediate(mNightView);
}

}