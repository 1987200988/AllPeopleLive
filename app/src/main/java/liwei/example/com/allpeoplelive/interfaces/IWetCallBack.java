package liwei.example.com.allpeoplelive.interfaces;

import java.util.List;

import liwei.example.com.allpeoplelive.bean.WetChatBean;

/**
 * 1.类的用途
 * 2.@author:liwei
 * 3.@2017/1/2
 */

public interface IWetCallBack {
    void success(List<WetChatBean.NewslistBean> list);
    void failure(String errMsg);



}
