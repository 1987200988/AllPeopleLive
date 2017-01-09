package liwei.example.com.allpeoplelive.adapter;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import com.blankj.utilcode.utils.ToastUtils;
import com.bumptech.glide.Glide;
import com.example.library.adapter.recyclecommonadapter.BaseViewHolder;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerClickListener;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import liwei.example.com.allpeoplelive.R;
import liwei.example.com.allpeoplelive.bean.FaceControlBean;
import liwei.example.com.allpeoplelive.view.fragment.FaceLikeFrag;

import static android.R.id.list;

/**
 * 1.类的用途
 * 2.@author:liwei
 * 3.@2017/1/4
 */

public class FaceLikeHolderHeader extends BaseViewHolder<FaceControlBean.RoomBean> {

    private final Banner banner;

    public FaceLikeHolderHeader(View itemView) {
        super(itemView);
        banner = (Banner) itemView.findViewById(R.id.face_viewpager);
    }

    @Override
    public void setData(final Context context, FaceControlBean.RoomBean roomBean) {
        List<FaceControlBean.RoomBean.ListBean> list = roomBean.list;


        List<String> listStr = new ArrayList<>();
        List<String> listImg = new ArrayList<>();
        for(FaceControlBean.RoomBean.ListBean title:list){
            listStr.add(title.title);
        }
        for(FaceControlBean.RoomBean.ListBean title:list){
            listImg.add(title.thumb);
        }

        //设置banner样式
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        banner.setImages(listImg);
        //设置banner动画效果
        banner.setBannerAnimation(Transformer.FlipHorizontal);
        //设置标题集合（当banner样式有显示title时）

        banner.setBannerTitles(listStr);
        //设置自动轮播，默认为true
        banner.isAutoPlay(true);
        //设置轮播时间
//        banner.setDelayTime(1500);
        //设置指示器位置（当banner模式中有指示器时）
        banner.setIndicatorGravity(BannerConfig.CENTER);
        //banner设置方法全部调用完毕时最后调用
        banner.start();
        banner.setOnBannerClickListener(new OnBannerClickListener() {
            @Override
            public void OnBannerClick(int position) {
                int i = position - 1;
                ToastUtils.showShortToast(context,""+i);
            }
        });


    }
    public class GlideImageLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            /**
             注意：
             1.图片加载器由自己选择，这里不限制，只是提供几种使用方法
             2.返回的图片路径为Object类型，由于不能确定你到底使用的那种图片加载器，
             传输的到的是什么格式，那么这种就使用Object接收和返回，你只需要强转成你传输的类型就行，
             切记不要胡乱强转！
             */


            //Glide 加载图片简单用法
            Glide.with(context).load(path).into(imageView);

            //Picasso 加载图片简单用法
//            Picasso.with(context).load(path).into(imageView)

            //用fresco加载图片简单用法，记得要写下面的createImageView方法
//            Uri uri = Uri.parse((String) path);
//            imageView.setImageURI(uri);
        }

        //提供createImageView 方法，如果不用可以不重写这个方法，主要是方便自定义ImageView的创建

    }
}
