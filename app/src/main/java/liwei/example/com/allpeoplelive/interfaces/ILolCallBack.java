package liwei.example.com.allpeoplelive.interfaces;

import liwei.example.com.allpeoplelive.bean.LolBean;

/**
 * 1.类的用途
 * 2.@author:liwei
 * 3.@2017/1/4
 */

public interface ILolCallBack {
    void success(LolBean lolBean);
    void failure(String errMsg);


}
