package liwei.example.com.allpeoplelive.view;

import android.content.pm.ActivityInfo;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.shuyu.gsyvideoplayer.GSYVideoPlayer;
import com.shuyu.gsyvideoplayer.utils.OrientationUtils;
import com.shuyu.gsyvideoplayer.video.CustomGSYVideoPlayer;

import liwei.example.com.allpeoplelive.R;


public class PlayerActivity extends AppCompatActivity {

    private CustomGSYVideoPlayer mVideoPlayer;
    private OrientationUtils mOrientationUtils;
    private String url = "http://112.253.22.157/17/z/z/y/u/zzyuasjwufnqerzvyxgkuigrkcatxr/hc.yinyuetai.com/D046015255134077DDB3ACA0D7E68D45.flv";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        mVideoPlayer = (CustomGSYVideoPlayer) findViewById(R.id.detail_player);
//                设置播放url，第二个参数表示需要边播边缓存
        mVideoPlayer.setUp(url, true, "");

//增加封面
        ImageView imageView = new ImageView(getApplicationContext());
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Glide.with(getApplicationContext()).load(R.mipmap.ic_launcher).into(imageView);
//                imageView.setImageResource(R.mipmap.ic_launcher);
        mVideoPlayer.setThumbImageView(imageView);

//增加title
        mVideoPlayer.getTitleTextView().setVisibility(View.VISIBLE);
        mVideoPlayer.getTitleTextView().setText("哈哈哈");

//设置返回键
        mVideoPlayer.getBackButton().setVisibility(View.VISIBLE);

//设置旋转
        mOrientationUtils = new OrientationUtils(this, mVideoPlayer);

//设置全屏按键功能
        mVideoPlayer.getFullscreenButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOrientationUtils.resolveByClick();
                mVideoPlayer.startWindowFullscreen(PlayerActivity.this,true,true);
            }
        });
/**
 * 如果是需要进度条预览的设置打开，默认关闭
 */



        /**
         * 全屏动画
         *
         * @param showFullAnimation 是否使用全屏动画效果
         */
        mVideoPlayer.setShowFullAnimation(true);

//设置返回按键功能
        mVideoPlayer.getBackButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });




    }
    @Override
    protected void onPause() {
        super.onPause();
        mVideoPlayer.onVideoPause();
    }

    @Override
    public void onBackPressed() {
        //先返回正常状态
        if (mOrientationUtils.getScreenType() == ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {
            mVideoPlayer.getFullscreenButton().performClick();
            return;
        }
//        释放所有
        mVideoPlayer.setStandardVideoAllCallBack(null);
        GSYVideoPlayer.releaseAllVideos();
        if ( Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            super.onBackPressed();
        } else {
            finish();
            overridePendingTransition(R.anim.abc_fade_in, R.anim.abc_fade_out);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        mVideoPlayer.releaseAllVideos();
    }
}
