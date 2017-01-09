package liwei.example.com.allpeoplelive.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.library.adapter.recyclecommonadapter.BaseViewHolder;
import com.example.library.adapter.recyclecommonadapter.RecycleCommonAdapter;
import com.example.library.adapter.recyclecommonadapter.RecycleCommonViewHolder;
import com.example.library.utils.glideutils.imageutils.GlideUtils;

import java.util.List;

import liwei.example.com.allpeoplelive.R;
import liwei.example.com.allpeoplelive.bean.DayNewsBean;

/**
 * 1.类的用途
 * 2.@author:liwei
 * 3.@2016/12/31
 */

public class RecycleBodyHolder extends BaseViewHolder<DayNewsBean> {

    private final RecyclerView recyclerView;

    public RecycleBodyHolder(View itemView) {
        super(itemView);
        recyclerView = getView(R.id.daynewsrecyclerviewbody);

    }

    @Override
    public void setData(Context context, DayNewsBean topStoriesBean) {
        List<DayNewsBean.StoriesBean> stories = topStoriesBean.stories;

        RecycleCommonAdapter<DayNewsBean.StoriesBean> recycleCommonAdapter = new RecycleCommonAdapter<DayNewsBean.StoriesBean>(context, R.layout.daynewsrecycleitem, stories) {
            @Override
            public void convert(RecycleCommonViewHolder holder, DayNewsBean.StoriesBean storiesBean) {
                GlideUtils.getInstance().display((ImageView) holder.getView(R.id.dayrecycleiv),storiesBean.images.get(0));
               TextView tv = holder.getView(R.id.dayrecycletv);
                tv.setText(storiesBean.title);

            }
        };
        recyclerView.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false));
        recyclerView
                .setAdapter(recycleCommonAdapter);
    }
}
