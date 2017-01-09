package com.example.library.baseactivity;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by 李韦 on 2016/11/3.
 */
public abstract class BaseActivity extends AppCompatActivity implements IOnCreate{

    private static Ipermissions ipermissions;
    private final static LinkedList<BaseActivity> mActivities = new LinkedList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

            synchronized(mActivities){
                mActivities.add(this);
            }
            initViews(savedInstanceState);
            initDatas();
            clickEvents();
    }

    public <T extends View>T findView(int viewId){
       return (T) findViewById(viewId);
    }

    public static void requestRuntimePermissions(String[] permissions,Ipermissions permissionListener){
        ipermissions = permissionListener;
        List<String> listRequest = new ArrayList<>();
        for(String permission:permissions){
            if(ContextCompat.checkSelfPermission(mActivities.getLast(),permission)!= PackageManager.PERMISSION_GRANTED){
                listRequest.add(permission);
            }
        }
        if(!listRequest.isEmpty()){
            ActivityCompat.requestPermissions(mActivities.getLast(),listRequest.toArray(new String[listRequest.size()]),1);

        }else{
            ipermissions.onGranted();
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 1:
                if(grantResults.length>0){
                    List<String> deniedPermissions = new ArrayList<>();
                    for (int i = 0; i < grantResults.length; i++) {
                        int grantResult = grantResults[i];
                        String permission = permissions[i];
                        if(grantResult!=PackageManager.PERMISSION_GRANTED){
                            deniedPermissions.add(permission);
                        }
                    }
                    if(deniedPermissions.isEmpty()){
                        ipermissions.onGranted();
                    }else{
                        ipermissions.onDenied(deniedPermissions);
                    }
                }
                break;
            default:
                break;
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        synchronized (mActivities){
            mActivities.remove(this);
        }
    }
    public void killAll(){
        LinkedList<BaseActivity> baseActivities = new LinkedList<>(mActivities);
        for(BaseActivity base:baseActivities){
            base.finish();
        }
    }
}
