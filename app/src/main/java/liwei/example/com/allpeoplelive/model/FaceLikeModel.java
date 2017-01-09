package liwei.example.com.allpeoplelive.model;

import com.example.library.mvp.BaseModel;
import com.example.library.utils.L;
import com.example.library.utils.netutils.ICallback;
import com.example.library.utils.netutils.Retrofit2Helper;

import liwei.example.com.allpeoplelive.apiinterface.IApiInterface;
import liwei.example.com.allpeoplelive.bean.FaceControlBean;
import liwei.example.com.allpeoplelive.interfaces.IFaceCallBack;
import retrofit2.Retrofit;
import rx.Observable;

/**
 * 1.类的用途
 * 2.@author:liwei
 * 3.@2017/1/4
 */

public class FaceLikeModel extends BaseModel{
    //    /list-android.json?11241742&v=2.2.4&os=1&ver=4
    private String recommonBaseUrl = "http://www.quanmin.tv/json/app/index/recommend/";

    private String headBaseUrl = "http://www.quanmin.tv/json/page/app-data/";
    //    http://www.quanmin.tv/json/page/app-data/info.json?v=2.2.4&os=1&ver=4
    public void getDataModeFace(final IFaceCallBack iFaceCallBack){
        Retrofit retrofit = Retrofit2Helper.getInstance().getRetrofit(recommonBaseUrl);
        IApiInterface iApiInterface = retrofit.create(IApiInterface.class);
        Observable<FaceControlBean> faceData = iApiInterface.getFaceData("2.2.4", "1", "4");
        deploy(faceData, new ICallback<FaceControlBean>() {
            @Override
            public void onCompleted(FaceControlBean faceControlBean) {
                L.e("成功");
               iFaceCallBack.success(faceControlBean);
            }

            @Override
            public void onFailed(String errMsg) {
                L.e("失败"+errMsg);

                iFaceCallBack.failure(errMsg);
            }
        });

    }





}
