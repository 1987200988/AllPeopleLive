package liwei.example.com.allpeoplelive.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.example.library.baseactivity.BasePager;

import java.util.List;

/**
 * 1.类的用途
 * 2.@author:liwei
 * 3.@2016/12/30
 */

public class ViewPagerAdapter extends PagerAdapter {
    private List<BasePager> listPager;
    private Context mContext;
    private String[] arrTitle = {"日报","专栏","微信","热门 "};
    public ViewPagerAdapter(List<BasePager> list,Context context){
        listPager = list;
        mContext = context;
    }

    @Override
    public int getCount() {
        return listPager.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        BasePager basePager = listPager.get(position);
        View view = basePager.initViews();
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View)object);


    }

    @Override
    public CharSequence getPageTitle(int position) {


        return arrTitle[position];
    }
}
