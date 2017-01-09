package liwei.example.com.allpeoplelive.model;

import com.example.library.mvp.BaseModel;
import com.example.library.utils.L;
import com.example.library.utils.netutils.ICallback;
import com.example.library.utils.netutils.Retrofit2Helper;

import liwei.example.com.allpeoplelive.apiinterface.IApiInterface;
import liwei.example.com.allpeoplelive.bean.LolBean;
import liwei.example.com.allpeoplelive.interfaces.ILolCallBack;
import retrofit2.Retrofit;
import rx.Observable;

/**
 * 1.类的用途
 * 2.@author:liwei
 * 3.@2017/1/4
 */

public class LolModel extends BaseModel {
//    http://www.quanmin.tv/json%2Fcategories%2Fbeauty%2Flist.json?11211639&os=1&v=2.2.4&os=1&ver=4
//    private String lolBaseUrl = "http://www.quanmin.tv/";

    private String baseUrl = "http://www.quanmin.tv/";
    private Observable<LolBean> mLolData;

    public void getModelDataLol(final ILolCallBack lolCallBack,int position){
        Retrofit retrofit = Retrofit2Helper.getInstance().getRetrofit(baseUrl);
        IApiInterface iApiInterface = retrofit.create(IApiInterface.class);
        if(position==0){
            mLolData = iApiInterface.getLolData("1","2.2.4","1","4");
        }else if(position==1){
            mLolData = iApiInterface.getLolData1("1","2.2.4","1","4");

        }else if(position==2){
            mLolData = iApiInterface.getLolData2("1","2.2.4","1","4");

        }else if(position==3){
            mLolData = iApiInterface.getLolData3("1","2.2.4","1","4");

        }else if(position==4){
            mLolData = iApiInterface.getLolData4("1","2.2.4","1","4");

        }else if(position==5){
            mLolData = iApiInterface.getLolData5("1","2.2.4","1","4");

        }else if(position==6){
            mLolData = iApiInterface.getLolData6("1","2.2.4","1","4");

        }else if(position==7){
            mLolData = iApiInterface.getLolData7("1","2.2.4","1","4");

        }else if(position==8){
            mLolData = iApiInterface.getLolData8("1","2.2.4","1","4");

        }else if(position==9){
            mLolData = iApiInterface.getLolData9("1","2.2.4","1","4");

        }else if(position==10){
            mLolData = iApiInterface.getLolData10("1","2.2.4","1","4");

        }else if(position==11){
            mLolData = iApiInterface.getLolData11("1","2.2.4","1","4");

        }else if(position==12){
            mLolData = iApiInterface.getLolData12("1","2.2.4","1","4");

        }else if(position==13){
            mLolData = iApiInterface.getLolData13("1","2.2.4","1","4");

        }else if(position==14){
            mLolData = iApiInterface.getLolData14("1","2.2.4","1","4");

        }else if(position==15){
            mLolData = iApiInterface.getLolData15("1","2.2.4","1","4");

        }else if(position==16){
            mLolData = iApiInterface.getLolData16("1","2.2.4","1","4");

        }else if(position==17){
            mLolData = iApiInterface.getLolData17("1","2.2.4","1","4");

        }else if(position==18){
            mLolData = iApiInterface.getLolData18("1","2.2.4","1","4");

        }else if(position==19){
            mLolData = iApiInterface.getLolData19("1","2.2.4","1","4");

        }else if(position==20){
            mLolData = iApiInterface.getLolData20("1","2.2.4","1","4");

        }
        position++;
        deploy(mLolData, new ICallback<LolBean>() {
            @Override
            public void onCompleted(LolBean lolBean) {
                lolCallBack.success(lolBean);
            }

            @Override
            public void onFailed(String errMsg) {
                L.e(errMsg);

                lolCallBack.failure(errMsg);
            }
        });



    }



}
