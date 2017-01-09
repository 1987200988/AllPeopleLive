package liwei.example.com.allpeoplelive.interfaces;

import com.example.library.mvp.ibase.IBaseView;

import java.util.List;

import liwei.example.com.allpeoplelive.bean.DayNewsBean;
import liwei.example.com.allpeoplelive.bean.HomeBean;
import liwei.example.com.allpeoplelive.bean.WetChatBean;

/**
 * 1.类的用途
 * 2.@author:liwei
 * 3.@2016/12/28
 */

public class Contract {
    public interface IBasePresenter {

        void getDataFirst();
        void getDataSpecialColumn();
        void getDataWetChat();
        void getDataHot();
        void getDataMore();
        void onDestroy();

    }
    public interface IBaseMvpActivity extends IBaseView {

        void getDataFirstSuccess(DayNewsBean dayNewsBean);
        void getDataFirstFailure();
        void getDataColumn(List<HomeBean.DataBean> list);
        void getDataWetSuccess(List<WetChatBean.NewslistBean> newslistBeanList);
        void getDataMoreSuccess();
        void getDataMoreFailure();

    }

}
