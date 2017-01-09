package liwei.example.com.allpeoplelive.apiinterface;

import liwei.example.com.allpeoplelive.bean.DayNewsBean;
import liwei.example.com.allpeoplelive.bean.FaceControlBean;
import liwei.example.com.allpeoplelive.bean.HomeBean;
import liwei.example.com.allpeoplelive.bean.LolBean;
import liwei.example.com.allpeoplelive.bean.WetChatBean;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

import static android.R.attr.key;
import static android.R.attr.path;
import static android.R.id.list;

/**
 * 1.类的用途
 * 2.@author:liwei
 * 3.@2016/12/29
 */

public interface IApiInterface {

     @GET("sections")
     Observable<HomeBean> getColumnData();
     @GET("latest")
     Observable<DayNewsBean> getDataNews();
 @GET("wxnew")
     Observable<WetChatBean> getWetData(@Query("key") String key, @Query("num") String num
 , @Query("page") String page);

    @GET("list-android.json?11241742")
    Observable<FaceControlBean> getFaceData(@Query("v") String version, @Query("os") String os,
                                            @Query("ver") String ver);
//    http://www.quanmin.tv/json%2Fcategories%2Fbeauty%2Flist.json?11211639&os=1&v=2.2.4&os=1&ver=4
@GET("json%2Fcategories%2Flol%2Flist.json?11211639")
Observable<LolBean> getLolData(@Query("os") String os1,
                               @Query("v") String v,
                               @Query("os") String os2
        ,@Query("ver") String ver);

    @GET("json%2Fcategories%2Fbeauty%2Flist.json?11211639")
    Observable<LolBean> getLolData1(@Query("os") String os1,
                                   @Query("v") String v,
                                   @Query("os") String os2
    ,@Query("ver") String ver);
    @GET("json%2Fcategories%2Foverwatch%2Flist.json?11211639")
    Observable<LolBean> getLolData2(@Query("os") String os1,
                                   @Query("v") String v,
                                   @Query("os") String os2
            ,@Query("ver") String ver);
    @GET("json%2Fcategories%2Fhuwai%2Flist.json?11211639")
    Observable<LolBean> getLolData3(@Query("os") String os1,
                                   @Query("v") String v,
                                   @Query("os") String os2
            ,@Query("ver") String ver);
    @GET("json%2Fcategories%2Fheartstone%2Flist.json?11211639")
    Observable<LolBean> getLolData4(@Query("os") String os1,
                                   @Query("v") String v,
                                   @Query("os") String os2
            ,@Query("ver") String ver);
@GET("json%2Fcategories%2Fmobilegame%2Flist.json?11211639")
    Observable<LolBean> getLolData5(@Query("os") String os1,
                                   @Query("v") String v,
                                   @Query("os") String os2
            ,@Query("ver") String ver);

@GET("json%2Fcategories%2Fwebgame%2Flist.json?11211639")
    Observable<LolBean> getLolData6(@Query("os") String os1,
                                   @Query("v") String v,
                                   @Query("os") String os2
            ,@Query("ver") String ver);
@GET("json%2Fcategories%2Ftvgame%2Flist.json?11211639")
    Observable<LolBean> getLolData7(@Query("os") String os1,
                                   @Query("v") String v,
                                   @Query("os") String os2
            ,@Query("ver") String ver);
@GET("json%2Fcategories%2Fwangzhe%2Flist.json?11211639")
    Observable<LolBean> getLolData8(@Query("os") String os1,
                                   @Query("v") String v,
                                   @Query("os") String os2
            ,@Query("ver") String ver);
@GET("json%2Fcategories%2F%2Flist.json?11211639")
    Observable<LolBean> getLolData9(@Query("os") String os1,
                                   @Query("v") String v,
                                   @Query("os") String os2
            ,@Query("ver") String ver);
@GET("json%2Fcategories%2Fdota2%2Flist.json?11211639")
    Observable<LolBean> getLolData10(@Query("os") String os1,
                                   @Query("v") String v,
                                   @Query("os") String os2
            ,@Query("ver") String ver);
@GET("json%2Fcategories%2Fcfpc%2Flist.json?11211639")
    Observable<LolBean> getLolData11(@Query("os") String os1,
                                   @Query("v") String v,
                                   @Query("os") String os2
            ,@Query("ver") String ver);
@GET("json%2Fcategories%2Fdnf%2Flist.json?11211639")
    Observable<LolBean> getLolData12(@Query("os") String os1,
                                   @Query("v") String v,
                                   @Query("os") String os2
            ,@Query("ver") String ver);
@GET("json%2Fcategories%2Fqqfeiche%2Flist.json?11211639")
    Observable<LolBean> getLolData13(@Query("os") String os1,
                                   @Query("v") String v,
                                   @Query("os") String os2
            ,@Query("ver") String ver);
@GET("json%2Fcategories%2Fwar3%2Flist.json?11211639")
    Observable<LolBean> getLolData14(@Query("os") String os1,
                                   @Query("v") String v,
                                   @Query("os") String os2
            ,@Query("ver") String ver);
@GET("json%2Fcategories%2Fnba2k%2Flist.json?11211639")
    Observable<LolBean> getLolData15(@Query("os") String os1,
                                   @Query("v") String v,
                                   @Query("os") String os2
            ,@Query("ver") String ver);
@GET("json%2Fcategories%2Fminecraft%2Flist.json?11211639")
    Observable<LolBean> getLolData16(@Query("os") String os1,
                                   @Query("v") String v,
                                   @Query("os") String os2
            ,@Query("ver") String ver);
    @GET("json%2Fcategories%2Ffifa%2Flist.json?11211639")
    Observable<LolBean> getLolData17(@Query("os") String os1,
                                   @Query("v") String v,
                                   @Query("os") String os2
            ,@Query("ver") String ver);
 @GET("json%2Fcategories%2Fblizzard%2Flist.json?11211639")
    Observable<LolBean> getLolData18(@Query("os") String os1,
                                   @Query("v") String v,
                                   @Query("os") String os2
            ,@Query("ver") String ver);
@GET("json%2Fcategories%2Fqiuqiu%2Flist.json?11211639")
    Observable<LolBean> getLolData19(@Query("os") String os1,
                                   @Query("v") String v,
                                   @Query("os") String os2
            ,@Query("ver") String ver);

@GET("json%2Fcategories%2Ferciyuan%2Flist.json?11211639")
    Observable<LolBean> getLolData20(@Query("os") String os1,
                                   @Query("v") String v,
                                   @Query("os") String os2
            ,@Query("ver") String ver);























}
