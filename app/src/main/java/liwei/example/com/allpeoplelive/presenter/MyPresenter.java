package liwei.example.com.allpeoplelive.presenter;

import com.blankj.utilcode.utils.ToastUtils;
import com.example.library.mvp.BasePresenter;
import com.example.library.utils.L;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import liwei.example.com.allpeoplelive.bean.DayNewsBean;
import liwei.example.com.allpeoplelive.bean.HomeBean;
import liwei.example.com.allpeoplelive.bean.WetChatBean;
import liwei.example.com.allpeoplelive.interfaces.Contract;
import liwei.example.com.allpeoplelive.interfaces.IBaseModel;
import liwei.example.com.allpeoplelive.interfaces.IColumnCallBack;
import liwei.example.com.allpeoplelive.interfaces.IWetCallBack;
import liwei.example.com.allpeoplelive.interfaces.MyCallBack;
import liwei.example.com.allpeoplelive.model.MyModel;
import liwei.example.com.allpeoplelive.view.MainActivity;

/**
 * 1.类的用途
 * 2.@author:liwei
 * 3.@2016/12/29
 */

public class MyPresenter extends BasePresenter<IBaseModel,Contract.IBaseMvpActivity> implements Contract.IBasePresenter{

    private List<WetChatBean.NewslistBean> listWet = new ArrayList<>();
    public MyPresenter(MainActivity mainActivity) {
        super(mainActivity);
        EventBus.getDefault().register(this);
    }

    @Override
    protected MyModel createModel() {
        return new MyModel();
    }


    @Override
    public void getDataFirst() {
        getModel().getDataFirst(new MyCallBack() {
            @Override
            public void success(DayNewsBean dayNewsBean) {
                getView().getDataFirstSuccess(dayNewsBean);
            }
            @Override
            public void failure(String errMsg) {
                getView().getDataFirstFailure();
                L.e(errMsg);

            }
        });
    }

    @Override
    public void getDataSpecialColumn() {
        getModel().getDataSpecialColumn(new IColumnCallBack() {
            @Override
            public void success(List<HomeBean.DataBean> list) {
                    getView().getDataColumn(list);
            }

            @Override
            public void failure(String errMsg) {
                ToastUtils.showShortToast((MainActivity)getView(),"专栏请求数据失败");
                L.e(errMsg);
            }
        });



    }

    @Override
    public void getDataWetChat() {
        getModel().getDataWeChat(new IWetCallBack() {
            @Override
            public void success(List<WetChatBean.NewslistBean> list) {
                listWet.addAll(list);
                getView().getDataWetSuccess(listWet);

            }

            @Override
            public void failure(String errMsg) {
                ToastUtils.showShortToast((MainActivity)getView(),"微信请求数据失败");
                L.e(errMsg);
            }
        });


    }
    @Override
    public void getDataMore() {

    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void helloEventBus(String message){
        L.e("mypresenter++++++++++");
        getModel().getDataMore(new IWetCallBack() {
            @Override
            public void success(List<WetChatBean.NewslistBean> list) {
                listWet.addAll(list);
                getView().getDataWetSuccess(listWet);

            }

            @Override
            public void failure(String errMsg) {
                L.e(errMsg);
            }
        });


    }
    @Override
    public void getDataHot() {


    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
