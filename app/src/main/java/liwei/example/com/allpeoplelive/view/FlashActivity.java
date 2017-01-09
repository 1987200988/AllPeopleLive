package liwei.example.com.allpeoplelive.view;

import android.Manifest;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

import com.blankj.utilcode.utils.ToastUtils;
import com.example.library.baseactivity.BaseActivity;
import com.example.library.baseactivity.Ipermissions;
import com.example.library.utils.L;
import com.example.library.utils.T;
import com.jaeger.library.StatusBarUtil;

import java.util.List;
import java.util.concurrent.TimeUnit;

import liwei.example.com.allpeoplelive.R;
import rx.Observable;

public class FlashActivity extends BaseActivity {


    private MyCountDownTimer myCountDownTimer;

    public void mstartActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }


    @Override
    public void initViews(Bundle bundle) {
        myCountDownTimer = new MyCountDownTimer(0, 0);
        myCountDownTimer.start();
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_flash);
        StatusBarUtil.setTranslucent(this,0);



    }

    @Override
    public void initDatas() {

    }

    @Override
    public void clickEvents() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        myCountDownTimer.cancel();
    }

    class MyCountDownTimer extends CountDownTimer{
        int i=0;

        public MyCountDownTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long l) {
            i++;
            L.e(i+"");
        }

        @Override
        public void onFinish() {
            requestRuntimePermissions(new String[]{Manifest.permission.CAMERA,
                            Manifest.permission.CALL_PHONE, Manifest.permission.ACCESS_FINE_LOCATION},
                    new Ipermissions() {
                        @Override
                        public void onGranted() {
                            mstartActivity();
                            finish();
                        }

                        @Override
                        public void onDenied(List<String> listDenies) {
                            for (String denies:listDenies) {
                                L.e(denies);
                            }
                            mstartActivity();
                            finish();
                        }
                    });
        }
    }




}
