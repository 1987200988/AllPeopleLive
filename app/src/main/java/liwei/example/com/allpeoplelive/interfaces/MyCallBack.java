package liwei.example.com.allpeoplelive.interfaces;

import java.util.List;

import liwei.example.com.allpeoplelive.bean.DayNewsBean;
import liwei.example.com.allpeoplelive.bean.HomeBean;

/**
 * 1.类的用途
 * 2.@author:liwei
 * 3.@2016/12/29
 */

public interface MyCallBack {

    void success(DayNewsBean dayNewsBean);
    void failure(String errMsg);

}
