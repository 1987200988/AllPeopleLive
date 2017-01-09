//package liwei.example.com.allpeoplelive.model;
//
//import com.example.library.mvp.BaseModel;
//import com.example.library.utils.netutils.Retrofit2Helper;
//
//import liwei.example.com.allpeoplelive.apiinterface.IApiInterface;
//import retrofit2.Retrofit;
//
///**
// * 1.类的用途
// * 2.@author:liwei
// * 3.@2016/12/29
// */
//
//public class MyBaseModel extends BaseModel<IApiInterface>{
//    private static final String baseUrl = "http://news-at.zhihu.com/api/4/";
//    public MyBaseModel() {
//        if(getApi()==null){
//            Retrofit retrofit = Retrofit2Helper.getInstance().getRetrofit(baseUrl);
//            IApiInterface iApiInterface = retrofit.create(IApiInterface.class);
//            setApi(iApiInterface);
//        }
//    }
//}
