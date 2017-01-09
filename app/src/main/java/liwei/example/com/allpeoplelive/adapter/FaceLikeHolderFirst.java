package liwei.example.com.allpeoplelive.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.utils.ToastUtils;
import com.example.library.adapter.recyclecommonadapter.BaseViewHolder;
import com.example.library.adapter.recyclecommonadapter.RecycleCommonAdapter;
import com.example.library.adapter.recyclecommonadapter.RecycleCommonViewHolder;
import com.example.library.utils.glideutils.imageutils.GlideUtils;
import com.example.library.utils.recyclerviewutils.RecyclerViewClickListener2;

import java.util.List;

import liwei.example.com.allpeoplelive.R;
import liwei.example.com.allpeoplelive.bean.FaceControlBean;

/**
 * 1.类的用途
 * 2.@author:liwei
 * 3.@2017/1/4
 */

public class FaceLikeHolderFirst extends BaseViewHolder<FaceControlBean.RoomBean> {

    private final RecyclerView recyclerView;
    private final TextView textView;

    public FaceLikeHolderFirst(View itemView) {
        super(itemView);
        recyclerView = (RecyclerView) itemView.findViewById(R.id.facelike_recycle);
        textView = (TextView) itemView.findViewById(R.id.facelike_tv);

    }

    @Override
    public void setData(final Context context, FaceControlBean.RoomBean roomBean) {
        textView.setText(roomBean.name);
        List<FaceControlBean.RoomBean.ListBean> list = roomBean.list;
    /*    thumb播放前的画面 nick主播昵称 view观看数量
        avatar主播的图片    title标题 */
        RecycleCommonAdapter<FaceControlBean.RoomBean.ListBean> recycleCommonAdapter = new RecycleCommonAdapter<FaceControlBean.RoomBean.ListBean>(context, R.layout.facelikerecycleitemitem1, list) {

            @Override
            public void convert(RecycleCommonViewHolder holder, FaceControlBean.RoomBean.ListBean listBean) {

                ImageView playiv = holder.getView(R.id.facelikeitemitem_playiv);
                TextView playnum = holder.getView(R.id.playnum_tv);
                ImageView zhuboiv = holder.getView(R.id.zhubo_iv);
                TextView zhubotv = holder.getView(R.id.zhubo_tv);
                TextView descri = holder.getView(R.id.face_describtion);
                GlideUtils.getInstance().displayRoundImg(playiv,listBean.thumb,15);
                playnum.setText(listBean.view);
                GlideUtils.getInstance().displayCircleImg(zhuboiv,listBean.avatar);
                zhubotv.setText(listBean.nick);
                descri.setText(listBean.title);
            }
        };
        recyclerView.setLayoutManager(new GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(recycleCommonAdapter);
        recyclerView.addOnItemTouchListener(new RecyclerViewClickListener2(context, recyclerView,
                new RecyclerViewClickListener2.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        ToastUtils.showShortToast(context,""+position);
                    }

                    @Override
                    public void onItemLongClick(View view, int position) {

                    }
                }));


    }
}
