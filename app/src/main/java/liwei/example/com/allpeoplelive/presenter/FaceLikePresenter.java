package liwei.example.com.allpeoplelive.presenter;

import com.example.library.mvp.BasePresenter;
import com.example.library.mvp.ibase.IBaseModel;
import com.example.library.mvp.ibase.IBaseView;
import com.example.library.utils.L;

import liwei.example.com.allpeoplelive.bean.FaceControlBean;
import liwei.example.com.allpeoplelive.interfaces.IFaceCallBack;
import liwei.example.com.allpeoplelive.model.FaceLikeModel;
import liwei.example.com.allpeoplelive.view.fragment.FaceLikeFrag;

/**
 * 1.类的用途
 * 2.@author:liwei
 * 3.@2017/1/4
 */

public class FaceLikePresenter extends BasePresenter<FaceLikeModel, IBaseView> {
    public FaceLikePresenter(IBaseView iBaseView) {
        super(iBaseView);
    }

    @Override
    protected FaceLikeModel createModel() {
        return new FaceLikeModel();
    }

    public void getDataPresenterFace() {
        getModel().getDataModeFace(new IFaceCallBack() {
            @Override
            public void success(FaceControlBean faceControlBean) {
                FaceLikeFrag faceLikeFrag = (FaceLikeFrag) getView();
                faceLikeFrag.requestSuccessFaceBody(faceControlBean);
            }

            @Override
            public void failure(String errMsg) {
                L.e(errMsg);

            }
        });
    }


}
