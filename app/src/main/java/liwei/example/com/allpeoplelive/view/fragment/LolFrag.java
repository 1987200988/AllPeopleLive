package liwei.example.com.allpeoplelive.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.utils.ConvertUtils;
import com.blankj.utilcode.utils.EncryptUtils;
import com.example.library.adapter.recyclecommonadapter.RecycleCommonAdapter;
import com.example.library.adapter.recyclecommonadapter.RecycleCommonViewHolder;
import com.example.library.mvp.MvpFragment;
import com.example.library.mvp.ibase.IBaseView;
import com.example.library.utils.L;
import com.example.library.utils.T;
import com.example.library.utils.glideutils.imageutils.GlideUtils;
import com.example.library.utils.recyclerviewutils.RecyclerViewClickListener2;

import java.util.List;

import liwei.example.com.allpeoplelive.R;
import liwei.example.com.allpeoplelive.bean.LolBean;
import liwei.example.com.allpeoplelive.presenter.LolPresenter;
import liwei.example.com.allpeoplelive.view.PlayerActivity;

/**
 * 1.类的用途
 * 2.@author:liwei
 * 3.@2017/1/4
 */
public class LolFrag extends MvpFragment<LolPresenter> {
    private RecyclerView lolRecycle;

    @Override
    protected LolPresenter createPresenter(IBaseView view) {
        return new LolPresenter(this);
    }

    @Override
    public int bindLayout() {
        return R.layout.lolfrag;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        View rootView = getmRootView();
        lolRecycle = (RecyclerView) rootView.findViewById(R.id.lol_recycle);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle arguments = getArguments();
        String url = (String) arguments.get("url");
        int integer = Integer.valueOf(url);
        L.e(integer+"hahahhahahhaha");
        mPresenter.getDataLol(integer);
    }

    public void requestLolData(LolBean lolBean) {
        List<LolBean.DataBean> datas = lolBean.data;
        RecycleCommonAdapter<LolBean.DataBean> recycleCommonAdapter = new RecycleCommonAdapter<LolBean.DataBean>(getActivity(), R.layout.lolrecycleitem, datas) {
            @Override
            public void convert(RecycleCommonViewHolder holder, LolBean.DataBean dataBean) {
                ImageView playiv = holder.getView(R.id.facelikeitemitemllol_playiv);
                TextView numtv = holder.getView(R.id.playnumlol_tv);
                ImageView zhuboiv = holder.getView(R.id.zhubolol_iv);
                TextView zhubotv = holder.getView(R.id.zhubolol_tv);
                TextView descri = holder.getView(R.id.lol_describtion);
                GlideUtils.getInstance().displayRoundImg(playiv, dataBean.thumb, 15);
                numtv.setText(dataBean.view);
                GlideUtils.getInstance().displayCircleImg(zhuboiv, dataBean.avatar);
                zhubotv.setText(dataBean.nick);
                descri.setText(dataBean.title);
            }
        };
        lolRecycle.setLayoutManager(new GridLayoutManager(getActivity(), 2, GridLayoutManager.VERTICAL, false));
        lolRecycle.setAdapter(recycleCommonAdapter);
        lolRecycle.addOnItemTouchListener(new RecyclerViewClickListener2(getActivity(), lolRecycle, new RecyclerViewClickListener2.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                T.showShort(getActivity(),position+"");
                Intent intent = new Intent(getActivity(), PlayerActivity.class);
                startActivity(intent);
            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        }));



    }
}
