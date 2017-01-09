package liwei.example.com.allpeoplelive.view;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Window;

import com.example.library.baseactivity.BaseActivity;
import com.example.library.mvp.MvpActivity;
import com.example.library.mvp.ibase.IBasePresenter;
import com.example.library.mvp.ibase.IBaseView;
import com.zhy.autolayout.AutoLinearLayout;

import java.util.ArrayList;
import java.util.List;

import liwei.example.com.allpeoplelive.R;
import liwei.example.com.allpeoplelive.view.fragment.FaceLikeFrag;
import liwei.example.com.allpeoplelive.view.fragment.LolFrag;

public class TvActivity extends BaseActivity {
private String recommon = "http://www.quanmin.tv/json/app/index/recommend/list-android.json?11241742&v=2.2.4&os=1&ver=4";
    private String[] arrTitle = {"颜值控","英雄联盟","全明星秀","守望先锋",
            "全民户外","炉石传说","手游","网游",
            "单机","王者荣耀","精彩推荐","DOTO2",
            "CF","DNF","QQ飞车","魔兽争霸3",
            "NBA2K","我的世界","FIFA","暴雪经典",
            "球球大作战","二次元区"
    };
    private AutoLinearLayout activityTv;
    private AppBarLayout appbartv;
    private Toolbar mainToolbar;
    private TabLayout tvTab;
    private ViewPager tvViewpager;
    private List<Fragment> listFrag = new ArrayList<>();
    private int position;
    @Override
    public void initViews(Bundle bundle) {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_tv);
        findview();

    }

    private void findview() {
        activityTv = (AutoLinearLayout) findViewById(R.id.activity_tv);
        appbartv = (AppBarLayout) findViewById(R.id.appbartv);
        mainToolbar = (Toolbar) findViewById(R.id.main_toolbar);
        tvTab = (TabLayout) findViewById(R.id.tv_tab);
        tvViewpager = (ViewPager) findViewById(R.id.tv_viewpager);
    }

    @Override
    public void initDatas() {
        FaceLikeFrag faceLikeFrag = new FaceLikeFrag();
        listFrag.add(faceLikeFrag);
        for (int i = 0; i < 21; i++) {
            LolFrag lolFrag = new LolFrag();
            Bundle bundle = new Bundle();
            bundle.putString("url",position+"");
            lolFrag.setArguments(bundle);
            position++;
            listFrag.add(lolFrag);
        }


        mainToolbar.setTitle("全民TV");

        //设置TabLayout的模式
//        tab_FindFragment_title.setTabMode(TabLayout.MODE_FIXED);
        //为TabLayout添加tab名称
//        tab_FindFragment_title.addTab(tab_FindFragment_title.newTab().setText(list_title.get(0)));
//        tab_FindFragment_title.addTab(tab_FindFragment_title.newTab().setText(list_title.get(1)));
//        tab_FindFragment_title.addTab(tab_FindFragment_title.newTab().setText(list_title.get(2)));
//        tab_FindFragment_title.addTab(tab_FindFragment_title.newTab().setText(list_title.get(3)));


        tvViewpager.setAdapter(new MyTvAdapter(getSupportFragmentManager()));
        tvTab.setupWithViewPager(tvViewpager);
        //       默认选中第一条
        tvTab.getTabAt(0).select();
    }

    @Override
    public void clickEvents() {

    }
    private class MyTvAdapter extends FragmentPagerAdapter{


        public MyTvAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return listFrag.get(position);
        }

        @Override
        public int getCount() {
            return 22;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return arrTitle[position];
        }
    }







}
