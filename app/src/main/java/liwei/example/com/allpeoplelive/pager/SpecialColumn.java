package liwei.example.com.allpeoplelive.pager;

import android.app.Activity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.library.adapter.recyclecommonadapter.RecycleCommonAdapter;
import com.example.library.adapter.recyclecommonadapter.RecycleCommonViewHolder;
import com.example.library.baseactivity.BasePager;
import com.example.library.utils.L;
import com.example.library.utils.glideutils.imageutils.GlideUtils;

import java.util.List;

import liwei.example.com.allpeoplelive.R;
import liwei.example.com.allpeoplelive.bean.HomeBean;
import liwei.example.com.allpeoplelive.bean.WetChatBean;

/**
 * 1.类的用途
 * 2.@author:liwei
 * 3.@2016/12/30
 */

public class SpecialColumn extends BasePager<HomeBean.DataBean> {

    private RecyclerView recyclerView;

    public SpecialColumn(Activity activity) {
        super(activity);
    }

    @Override
    public View initViews() {
        View view = View.inflate(basePagerActivity, R.layout.specialcolumnrecycle, null);
        recyclerView = (RecyclerView) view.findViewById(R.id.specialrecycle);

        return view;
    }

    @Override
    public void initDatas(List<HomeBean.DataBean> list) {

        RecycleCommonAdapter<HomeBean.DataBean> recycleCommonAdapter = new RecycleCommonAdapter<HomeBean.DataBean>(basePagerActivity, R.layout.specialcolumnrecycleitem, list) {
            @Override
            public void convert(RecycleCommonViewHolder holder, HomeBean.DataBean dataBean) {
               ImageView iv = holder.getView(R.id.specialrecycleitemiv);
                GlideUtils.getInstance().displayRoundImg(iv,dataBean.thumbnail,10);
            }
        };
        recyclerView.setLayoutManager(new GridLayoutManager(basePagerActivity,2,GridLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(recycleCommonAdapter);



    }


}
