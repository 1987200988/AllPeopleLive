package liwei.example.com.allpeoplelive.presenter;

import com.example.library.mvp.BasePresenter;
import com.example.library.mvp.ibase.IBaseModel;
import com.example.library.mvp.ibase.IBaseView;
import com.example.library.utils.L;

import liwei.example.com.allpeoplelive.bean.LolBean;
import liwei.example.com.allpeoplelive.interfaces.ILolCallBack;
import liwei.example.com.allpeoplelive.model.LolModel;
import liwei.example.com.allpeoplelive.view.fragment.LolFrag;

/**
 * 1.类的用途
 * 2.@author:liwei
 * 3.@2017/1/4
 */

public class LolPresenter extends BasePresenter<LolModel,IBaseView> {
    public LolPresenter(IBaseView iBaseView) {
        super(iBaseView);

    }

    @Override
    protected LolModel createModel() {
        return new LolModel();

    }
    public void getDataLol(int position){
        getModel().getModelDataLol(new ILolCallBack() {
            @Override
            public void success(LolBean lolBean) {
                LolFrag view = (LolFrag) getView();
                view.requestLolData(lolBean);

            }

            @Override
            public void failure(String errMsg) {
                L.e(errMsg);

            }
        },position);


    }



}
