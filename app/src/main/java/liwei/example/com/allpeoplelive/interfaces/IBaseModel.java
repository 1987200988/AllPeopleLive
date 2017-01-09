package liwei.example.com.allpeoplelive.interfaces;

import java.util.List;

import liwei.example.com.allpeoplelive.bean.HomeBean;

/**
 * 1.类的用途
 * 2.@author:liwei
 * 3.@2016/12/28
 */

public interface IBaseModel extends com.example.library.mvp.ibase.IBaseModel{


    void getDataFirst(MyCallBack myCallBack);
    void getDataMore(IWetCallBack myCallBack);
    void onDestroy();
    void getDataSpecialColumn(IColumnCallBack myCallBack);
    void getDataWeChat(IWetCallBack myCallBack);
    void getDataHot(MyCallBack myCallBack);



}
