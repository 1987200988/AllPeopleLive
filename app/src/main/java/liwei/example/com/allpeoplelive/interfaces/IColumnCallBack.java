package liwei.example.com.allpeoplelive.interfaces;

import java.util.List;

import liwei.example.com.allpeoplelive.bean.HomeBean;

/**
 * 1.类的用途
 * 2.@author:liwei
 * 3.@2016/12/30
 */

public interface IColumnCallBack {
    void success(List<HomeBean.DataBean> list);
    void failure(String errMsg);

}
