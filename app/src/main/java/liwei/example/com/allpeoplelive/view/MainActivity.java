package liwei.example.com.allpeoplelive.view;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;

import com.blankj.utilcode.utils.ToastUtils;
import com.example.library.baseactivity.BasePager;
import com.example.library.mvp.MvpActivity;
import com.example.library.mvp.ibase.IBaseView;
import com.example.library.utils.L;
import com.jaeger.library.StatusBarUtil;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import liwei.example.com.allpeoplelive.R;
import liwei.example.com.allpeoplelive.adapter.ViewPagerAdapter;
import liwei.example.com.allpeoplelive.bean.DayNewsBean;
import liwei.example.com.allpeoplelive.bean.HomeBean;
import liwei.example.com.allpeoplelive.bean.WetChatBean;
import liwei.example.com.allpeoplelive.interfaces.Contract;
import liwei.example.com.allpeoplelive.pager.DayNews;
import liwei.example.com.allpeoplelive.pager.Hot;
import liwei.example.com.allpeoplelive.pager.SpecialColumn;
import liwei.example.com.allpeoplelive.pager.WeChat;
import liwei.example.com.allpeoplelive.presenter.MyPresenter;

public class MainActivity extends MvpActivity<MyPresenter> implements Contract.IBaseMvpActivity{
    private Toolbar mainToolbar;
    private NavigationView idNvMenu;
    private DrawerLayout mainDrawerlayout;
    private List<HomeBean.DataBean> dataBeenList;
    private ViewPager mainpager;
    private TabLayout tabPageIndicator;
    private List<BasePager> listPager;



    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            int obj = (int) msg.obj;
//            ToastUtils.showShortToast(getApplicationContext(),"hahahaha"+1+obj);
            switch (obj){
                case 0:
//                    StatusBarUtil.setColorForDrawerLayout(MainActivity.this,mainDrawerlayout,Color.parseColor("#32CD32"),0);

                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    getWindow().setWindowAnimations(R.style.WindowAnimationFadeInOut);
//                    int mode = getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;
//                    if(mode == Configuration.UI_MODE_NIGHT_YES) {
//                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
//                    } else if(mode == Configuration.UI_MODE_NIGHT_NO) {
//                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
//                    } else {
//                        // blah blah

//                    }

                    recreate();



                    break;
                case 1:
//                    StatusBarUtil.setColorForDrawerLayout(MainActivity.this,mainDrawerlayout,Color.parseColor("#2B2B2B"),0);

                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    getWindow().setWindowAnimations(R.style.WindowAnimationFadeInOut);
                   recreate();



                    break;

            }




        }
    };
    @Override
    public void initViews(Bundle bundle) {
        super.initViews(bundle);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        findView();
        setSupportActionBar(mainToolbar);
//        StatusBarUtil.setColor(this,Color.parseColor("#32CD32"),0);
//        StatusBarUtil.setColorForDrawerLayout(this,mainDrawerlayout, Color.parseColor("#32CD32"),0);
        StatusBarUtil.setTranslucent(this,0);


        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(this, mainDrawerlayout, mainToolbar, R.string.app_name, R.string.app_name);
        mDrawerToggle.syncState();
        mainDrawerlayout.addDrawerListener(mDrawerToggle);
        mainToolbar.setTitle("MyApp");

        listPager = new ArrayList<>();
        DayNews dayNews = new DayNews(this);
        SpecialColumn specialColumn = new SpecialColumn(this);
        WeChat weChat = new WeChat(this);
        Hot hot = new Hot(this);
        listPager.add(dayNews);
        listPager.add(specialColumn);
        listPager.add(weChat);
        listPager.add(hot);
        mainpager.setAdapter(new ViewPagerAdapter(listPager,this));
        tabPageIndicator.setupWithViewPager(mainpager);
        tabPageIndicator.getTabAt(0).select();
        getPresenter().getDataFirst();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.thememenu,menu);
        return true;
    }

    private void findView() {
        mainToolbar = (Toolbar) findViewById(R.id.main_toolbar);
        idNvMenu = (NavigationView) findViewById(R.id.id_nv_menu);
        mainDrawerlayout = (DrawerLayout) findViewById(R.id.main_drawerlayout);
        mainpager = findView(R.id.mainpager);
        tabPageIndicator = findView(R.id.indicator);
        findView(R.id.floatbutton);

    }

    @Override
    public void initDatas() {

    }

    @Override
    public void clickEvents() {
          mainToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
              @Override
              public boolean onMenuItemClick(MenuItem item) {
                    switch (item.getItemId()){
                        case R.id.day:
                         EventBus.getDefault().post(0);
                            ToastUtils.showShortToast(MainActivity.this,"111");
                            Message obtain = Message.obtain();
                            obtain.obj = 0;
                            handler.sendMessage(obtain);
                            break;
                        case R.id.night:
                            ToastUtils.showShortToast(MainActivity.this,"222");

                            Message obtain1 = Message.obtain();
                            obtain1.obj = 1;
                            handler.sendMessage(obtain1);


                            break;


                    }
                  return false;
              }
          });



        mainpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if(position==0){
                    getPresenter().getDataFirst();
                    WeChat basePager = (WeChat) listPager.get(2);
                    basePager.flag = false;
                }else
                if(position==1){
                    getPresenter().getDataSpecialColumn();
                }else if(position==2){
                    getPresenter().getDataWetChat();
                    L.e("我进到微信页面了");
                }else if(position==3){


                }


            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        idNvMenu.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.AllPeopleTV:
                        Intent intent = new Intent(getApplicationContext(), TvActivity.class);
                        startActivity(intent);

                        break;
                }
                item.setChecked(true);
                mainDrawerlayout.closeDrawers();
                return true;
            }
        });




    }


    @Override
    protected MyPresenter createPresenter(IBaseView view) {
        return new MyPresenter(this);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void getDataFirstSuccess(DayNewsBean dayNewsBean) {

        List<DayNewsBean> listday = new ArrayList<>();
        listday.add(dayNewsBean);

        listPager.get(0).initDatas(listday);



    }

    @Override
    public void getDataFirstFailure() {
        ToastUtils.showShortToast(this,"日报请求网络数据失败");
    }

    @Override
    public void getDataColumn(List<HomeBean.DataBean> list) {
        listPager.get(1).initDatas(list);

    }

    @Override
    public void getDataWetSuccess(List<WetChatBean.NewslistBean> newslistBeanList) {
        L.e("我请求成功了");
        listPager.get(2).initDatas(newslistBeanList);

    }

    @Override
    public void getDataMoreSuccess() {

    }

    @Override
    public void getDataMoreFailure() {

    }
}
