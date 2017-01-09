package liwei.example.com.allpeoplelive.adapter;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import com.example.library.adapter.recyclecommonadapter.BaseViewHolder;

import java.util.List;

import liwei.example.com.allpeoplelive.R;
import liwei.example.com.allpeoplelive.bean.DayNewsBean;
import liwei.example.com.allpeoplelive.bean.HomeBean;

import static android.media.CamcorderProfile.get;

/**
 * 1.类的用途
 * 2.@author:liwei
 * 3.@2016/12/31
 */

public class RecycleHeaderHolder extends BaseViewHolder<DayNewsBean> {

    private final ViewPager viewPager;
    private final TextView textView;
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            int currentItem = viewPager.getCurrentItem();
            int i = currentItem+1;
            viewPager.setCurrentItem(i);
            handler.sendEmptyMessageDelayed(0,5000);


        }
    };


    public RecycleHeaderHolder(View itemView) {
        super(itemView);
        viewPager = getView(R.id.daynewsviewpager);
        textView = getView(R.id.daytextview);
    }

    @Override
    public void setData(Context context, DayNewsBean topStoriesBean) {
        final List<DayNewsBean.TopStoriesBean> top_stories = topStoriesBean.top_stories;
        textView.setText(top_stories.get(0).title);
//        L.e(top_stories.get(0).title);
        viewPager.setAdapter(new DayNewsPagerAdapter(top_stories,context));
        viewPager.setCurrentItem(2000);
        handler.sendEmptyMessageDelayed(0,5000);

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                int i = position % top_stories.size();

                textView.setText(top_stories.get(i).title);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
//


    }
}
