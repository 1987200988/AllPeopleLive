package liwei.example.com.allpeoplelive.pager;

import android.app.Activity;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.library.adapter.recyclecommonadapter.RecycleCommonAdapter;
import com.example.library.adapter.recyclecommonadapter.RecycleCommonViewHolder;
import com.example.library.baseactivity.BasePager;
import com.example.library.utils.L;
import com.example.library.utils.glideutils.imageutils.GlideUtils;

import java.util.List;

import liwei.example.com.allpeoplelive.R;
import liwei.example.com.allpeoplelive.adapter.DayNewsPagerAdapter;
import liwei.example.com.allpeoplelive.adapter.DayNewsRecyclerAdapter;
import liwei.example.com.allpeoplelive.bean.DayNewsBean;

/**
 * 1.类的用途
 * 2.@author:liwei
 * 3.@2016/12/30
 */

public class DayNews extends BasePager<DayNewsBean>{


    private ViewPager dayviewpager;
    private RecyclerView dayrecyclerview;
    private TextView dayTextView;

    public DayNews(Activity activity) {
        super(activity);
    }

    @Override
    public View initViews() {
        View view = View.inflate(basePagerActivity, R.layout.daynewspager, null);

        dayrecyclerview = (RecyclerView) view.findViewById(R.id.daynewsrecyclerview);

        return view;
    }

    @Override
    public void initDatas(List<DayNewsBean> list) {
        DayNewsBean dayNewsBean = list.get(0);
//       recyclerview
        List<DayNewsBean.StoriesBean> stories = dayNewsBean.stories;
//       viewpager
        List<DayNewsBean.TopStoriesBean> top_stories = dayNewsBean.top_stories;
        DayNewsRecyclerAdapter dayNewsRecyclerAdapter = new DayNewsRecyclerAdapter(dayNewsBean, basePagerActivity);
        dayrecyclerview.setLayoutManager(new LinearLayoutManager(basePagerActivity,LinearLayoutManager.VERTICAL,false));
        dayrecyclerview.setAdapter(dayNewsRecyclerAdapter);
//        dayTextView.setText(top_stories.get(0).title);
//        L.e(top_stories.get(0).title);
//        dayviewpager.setAdapter(new DayNewsPagerAdapter(top_stories,basePagerActivity));
//        dayviewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//                dayTextView.setText(top_stories.get(position).title);
//
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//
//            }
//        });
//
//        RecycleCommonAdapter<DayNewsBean.StoriesBean> recycleCommonAdapter = new RecycleCommonAdapter<DayNewsBean.StoriesBean>(basePagerActivity, R.layout.daynewsrecycleitem, stories) {
//            @Override
//            public void convert(RecycleCommonViewHolder holder, DayNewsBean.StoriesBean storiesBean) {
//                GlideUtils.getInstance().display((ImageView) holder.getView(R.id.dayrecycleiv),storiesBean.images.get(0));
//               TextView tv = holder.getView(R.id.dayrecycletv);
//                tv.setText(storiesBean.title);
//
//            }
//        };
//        dayrecyclerview.setLayoutManager(new LinearLayoutManager(basePagerActivity,LinearLayoutManager.VERTICAL,false));
//        dayrecyclerview.setAdapter(recycleCommonAdapter);



    }


}
