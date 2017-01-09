package liwei.example.com.allpeoplelive.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.library.utils.glideutils.imageutils.GlideUtils;

import java.util.List;

import liwei.example.com.allpeoplelive.bean.DayNewsBean;

/**
 * 1.类的用途
 * 2.@author:liwei
 * 3.@2016/12/30
 */

public class DayNewsPagerAdapter extends PagerAdapter {
    private List<DayNewsBean.TopStoriesBean> storiesBeanList;
    private Context mContext;
    public DayNewsPagerAdapter(List<DayNewsBean.TopStoriesBean> list, Context context){
        storiesBeanList = list;
        mContext = context;
    }
    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
       container.removeView((View)object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        int i = position % storiesBeanList.size();
        ImageView imageView = new ImageView(mContext);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        GlideUtils instance = GlideUtils.getInstance();
        instance.displayImgQuick(imageView,storiesBeanList.get(i).image,
                1f, DiskCacheStrategy.SOURCE);
        container.addView(imageView);

        return imageView;
    }
}
