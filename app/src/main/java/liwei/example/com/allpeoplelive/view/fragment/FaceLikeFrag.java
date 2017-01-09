package liwei.example.com.allpeoplelive.view.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.library.mvp.MvpFragment;
import com.example.library.mvp.ibase.IBasePresenter;
import com.example.library.mvp.ibase.IBaseView;
import com.example.library.utils.L;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import liwei.example.com.allpeoplelive.R;
import liwei.example.com.allpeoplelive.adapter.FaceLikeRecycleAdapter;
import liwei.example.com.allpeoplelive.bean.FaceControlBean;
import liwei.example.com.allpeoplelive.presenter.FaceLikePresenter;

/**
 * 1.类的用途
 * 2.@author:liwei
 * 3.@2017/1/4
 */

public class FaceLikeFrag extends MvpFragment<FaceLikePresenter> {


    private Banner banner;
    private RecyclerView faceRecycle;

    @Override
    protected FaceLikePresenter createPresenter(IBaseView view) {
        return new FaceLikePresenter(this);
    }

    @Override
    public int bindLayout() {
        return R.layout.facelikefrag;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        View rootView = getmRootView();
        banner = (Banner) rootView.findViewById(R.id.face_viewpager);
        faceRecycle = (RecyclerView) rootView.findViewById(R.id.face_recycle);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mPresenter.getDataPresenterFace();
    }

    public void requestSuccessFaceBody(FaceControlBean faceControlBean){
//        L.e(faceControlBean.room.get(0).icon);
//        L.e("我成功了");
        List<FaceControlBean.RoomBean> room = faceControlBean.room;
//        for (int i = 0; i <room.size() ; i++) {
//            L.e("sdfs",room.get(i).name);
//        }
        FaceLikeRecycleAdapter faceLikeRecycleAdapter = new FaceLikeRecycleAdapter(getActivity(), room);
        faceRecycle.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        faceRecycle.setAdapter(faceLikeRecycleAdapter);









    }



}
