package liwei.example.com.allpeoplelive.interfaces;

import liwei.example.com.allpeoplelive.bean.FaceControlBean;

/**
 * 1.类的用途
 * 2.@author:liwei
 * 3.@2017/1/4
 */

public interface IFaceCallBack {
    void success(FaceControlBean faceControlBean);
    void failure(String errMsg);


}
