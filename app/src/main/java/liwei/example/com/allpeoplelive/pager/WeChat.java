package liwei.example.com.allpeoplelive.pager;

import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.example.library.adapter.listgridcommonadapter.CommonAdapter;
import com.example.library.adapter.recyclecommonadapter.RecycleCommonAdapter;
import com.example.library.adapter.recyclecommonadapter.RecycleCommonViewHolder;
import com.example.library.baseactivity.BasePager;
import com.example.library.utils.L;
import com.example.library.utils.glideutils.imageutils.GlideUtils;
import com.lcodecore.tkrefreshlayout.RefreshListenerAdapter;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import liwei.example.com.allpeoplelive.R;
import liwei.example.com.allpeoplelive.bean.WetChatBean;
import liwei.example.com.allpeoplelive.customview.LoadingView;

/**
 * 1.类的用途
 * 2.@author:liwei
 * 3.@2016/12/30
 */

public class WeChat extends BasePager<WetChatBean.NewslistBean> {

    private RecyclerView wetRecycle;

    public boolean flag;
    private RecycleCommonAdapter<WetChatBean.NewslistBean> recycleCommonAdapter;
    private CommonAdapter commonAdapter;
    private TwinklingRefreshLayout refreshLayout;

    public WeChat(Activity activity) {
        super(activity);
    }

    @Override
    public View initViews() {
        View view = View.inflate(basePagerActivity, R.layout.wetchatpager, null);
        wetRecycle = (RecyclerView) view.findViewById(R.id.wetrecycle);
//        scrollView = (PullToRefreshScrollView) view.findViewById(R.id.pull_refresh_scrollview);
        refreshLayout = (TwinklingRefreshLayout) view.findViewById(R.id.refreshLayout);
        return view;
    }

    @Override
    public void initDatas(List<WetChatBean.NewslistBean> list) {


        if (!flag) {
            recycleCommonAdapter = new RecycleCommonAdapter<WetChatBean.NewslistBean>(basePagerActivity, R.layout.wetchatrecycleitem, list) {
                @Override
                public void convert(RecycleCommonViewHolder holder, WetChatBean.NewslistBean newslistBean) {
                    ImageView iv = holder.getView(R.id.wetrecycleiv);
                    GlideUtils.getInstance().display(iv, newslistBean.picUrl);
                    holder.setText(R.id.wetdescription, newslistBean.description);
                    holder.setText(R.id.wettime, newslistBean.ctime);
                    holder.setText(R.id.wettitle, newslistBean.title);

                }
            };
            wetRecycle.setLayoutManager(new LinearLayoutManager(basePagerActivity, LinearLayoutManager.VERTICAL, false));

            wetRecycle.setAdapter(recycleCommonAdapter);
//            commonAdapter = new CommonAdapter<WetChatBean.NewslistBean>(basePagerActivity, listWet, R.layout.wetchatrecycleitem){
//                @Override
//                public void convert(CommonViewHolder helper, WetChatBean.NewslistBean item) {
//                    ImageView iv = helper.getView(R.id.wetrecycleiv);
//                    GlideUtils.getInstance().display(iv, item.picUrl);
//                    helper.setText(R.id.wetdescription, item.description);
//                    helper.setText(R.id.wettime, item.ctime);
//                    helper.setText(R.id.wettitle, item.title);
//
//                }
//            };

        } else {
            recycleCommonAdapter.notifyDataSetChanged();

//            wetRecycle.setAdapter(recycleCommonAdapter);

            L.e("hahahahahhahaahhhaahaah");
            refreshLayout.finishRefreshing();
            refreshLayout.finishLoadmore();
        }
//        scrollView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ScrollView>() {
//            @Override
//            public void onPullDownToRefresh(PullToRefreshBase<ScrollView> refreshView) {
//
//            }
//
//            @Override
//            public void onPullUpToRefresh(PullToRefreshBase<ScrollView> refreshView) {
//                EventBus.getDefault().post("1");
//                flag = true;
//
//            }
//        });
//            refreshLayout.setBottomView(new BottomProgressView(basePagerActivity));
        refreshLayout.setBottomView(new LoadingView(basePagerActivity));
//        refreshLayout.setBottomView(new ProgressView(basePagerActivity));


//        refreshLayout.setEnableRefresh(false);
        refreshLayout.setOnRefreshListener(new RefreshListenerAdapter() {
            @Override
            public void onRefresh(final TwinklingRefreshLayout refreshLayout) {
                EventBus.getDefault().post("1");
                flag = true;
            }

            @Override
            public void onLoadMore(final TwinklingRefreshLayout refreshLayout) {

                        EventBus.getDefault().post("1");
                        flag = true;

            }
        });
    }





}
