package liwei.example.com.allpeoplelive.model;

import com.example.library.mvp.BaseModel;
import com.example.library.utils.netutils.ICallback;
import com.example.library.utils.netutils.Retrofit2Helper;


import java.util.ArrayList;
import java.util.List;

import liwei.example.com.allpeoplelive.apiinterface.IApiInterface;
import liwei.example.com.allpeoplelive.bean.DayNewsBean;
import liwei.example.com.allpeoplelive.bean.WetChatBean;
import liwei.example.com.allpeoplelive.interfaces.IBaseModel;
import liwei.example.com.allpeoplelive.bean.HomeBean;
import liwei.example.com.allpeoplelive.interfaces.IColumnCallBack;
import liwei.example.com.allpeoplelive.interfaces.IWetCallBack;
import liwei.example.com.allpeoplelive.interfaces.MyCallBack;
import retrofit2.Retrofit;

import static android.R.id.list;

/**
 * 1.类的用途
 * 2.@author:liwei
 * 3.@2016/12/29
 */

public class MyModel extends BaseModel implements IBaseModel {

    private String baseUrlDayNews = "http://news-at.zhihu.com/api/4/news/";
    private static final String baseUrlColumn = "http://news-at.zhihu.com/api/4/";
    private static final String baseUrlWet = "http://api.tianapi.com/";
    private int position = 1;

    @Override
    public void getDataFirst(final MyCallBack myCall) {
        Retrofit retrofit = Retrofit2Helper.getInstance().getRetrofit(baseUrlDayNews);
        IApiInterface iApiInterface = retrofit.create(IApiInterface.class);
        deploy(iApiInterface.getDataNews(), new ICallback<DayNewsBean>() {
            @Override
            public void onCompleted(DayNewsBean homeBean) {

                myCall.success(homeBean);
            }
            @Override
            public void onFailed(String errMsg) {
                myCall.failure(errMsg);
            }
        });
    }
    @Override
    public void getDataMore(final IWetCallBack myCallBack) {
        Retrofit retrofit = Retrofit2Helper.getInstance().getRetrofit(baseUrlWet);
        IApiInterface iApiInterface = retrofit.create(IApiInterface.class);
        position++;
        deploy(iApiInterface.getWetData("0fa92a1789cb883d0254ce24862385a3","10",position+""), new ICallback<WetChatBean>() {
            @Override
            public void onCompleted(WetChatBean wetChatBean) {
                myCallBack.success(wetChatBean.newslist);
            }
            @Override
            public void onFailed(String errMsg) {
                myCallBack.failure(errMsg);
            }
        });
    }
    @Override
    public void getDataSpecialColumn(final IColumnCallBack myCallBack) {

        Retrofit retrofit = Retrofit2Helper.getInstance().getRetrofit(baseUrlColumn);
        IApiInterface iApiInterface = retrofit.create(IApiInterface.class);
        deploy(iApiInterface.getColumnData(), new ICallback<HomeBean>() {
            @Override
            public void onCompleted(HomeBean homeBean) {
                myCallBack.success(homeBean.data);
            }
            @Override
            public void onFailed(String errMsg) {
                myCallBack.failure(errMsg);
            }
        }) ;
    }

    @Override
    public void getDataWeChat(final IWetCallBack myCallBack) {
        Retrofit retrofit = Retrofit2Helper.getInstance().getRetrofit(baseUrlWet);
        IApiInterface iApiInterface = retrofit.create(IApiInterface.class);

        deploy(iApiInterface.getWetData("0fa92a1789cb883d0254ce24862385a3","10","1"), new ICallback<WetChatBean>() {
            @Override
            public void onCompleted(WetChatBean wetChatBean) {
                myCallBack.success(wetChatBean.newslist);
            }

            @Override
            public void onFailed(String errMsg) {
                myCallBack.failure(errMsg);

            }
        });

    }

    @Override
    public void getDataHot(final MyCallBack myCallBack) {



    }
}
