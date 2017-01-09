package liwei.example.com.allpeoplelive.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.library.adapter.recyclecommonadapter.BaseViewHolder;

import java.util.List;

import liwei.example.com.allpeoplelive.R;
import liwei.example.com.allpeoplelive.bean.FaceControlBean;

/**
 * 1.类的用途
 * 2.@author:liwei
 * 3.@2017/1/4
 */

public class FaceLikeRecycleAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private Context mContext;
    private List<FaceControlBean.RoomBean> mList;

    public FaceLikeRecycleAdapter(Context context, List<FaceControlBean.RoomBean> roomBeanList){
        mContext = context;
        mList = roomBeanList;

    }



    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType==0){
            View view = LayoutInflater.from(mContext).inflate(R.layout.facelikeheader, parent, false);
            return new FaceLikeHolderHeader(view);

        }else if(viewType==1){
            View view = LayoutInflater.from(mContext).inflate(R.layout.facelikerecycleitem1, parent, false);
            return new FaceLikeHolderFirst(view);
        }else {
            View view = LayoutInflater.from(mContext).inflate(R.layout.facelikerecycleitem, parent, false);
            return new FaceLikeHolder(view);

        }

    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
       if(position==1){
           holder.setData(mContext,mList.get(0));
            return;
       }
        holder.setData(mContext,mList.get(position));

    }

    @Override
    public int getItemCount() {
        return mList.size();

    }

    @Override
    public int getItemViewType(int position) {
        switch (position){
            case 0:
                return 0;
            case 1:
                return 1;


        }


        return 2;
    }
}
