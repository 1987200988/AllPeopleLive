package liwei.example.com.allpeoplelive.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.library.adapter.recyclecommonadapter.BaseViewHolder;
import com.example.library.utils.L;

import liwei.example.com.allpeoplelive.R;
import liwei.example.com.allpeoplelive.bean.DayNewsBean;

/**
 * 1.类的用途
 * 2.@author:liwei
 * 3.@2016/12/31
 */

public class DayNewsRecyclerAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private DayNewsBean mDayNewsBean;
    private Context mContext;
    public DayNewsRecyclerAdapter(DayNewsBean dayNewsBean, Context context){
        mDayNewsBean = dayNewsBean;
        mContext = context;
    }


    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType==0){
            View view = LayoutInflater.from(mContext).inflate(R.layout.dayrecycleheader, parent, false);
           return new RecycleHeaderHolder(view);

        }else if(viewType==1){
            View view = LayoutInflater.from(mContext).inflate(R.layout.dayrecyclebody, parent, false);
            return new RecycleBodyHolder(view);

        }

        return null;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
            holder.setData(mContext,mDayNewsBean);


    }

    @Override
    public int getItemCount() {


        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        L.e(position+"");
        switch (position){
            case 0:
            return 0;
            case 1:
            return 1;

        }
        return 0;
    }
}
