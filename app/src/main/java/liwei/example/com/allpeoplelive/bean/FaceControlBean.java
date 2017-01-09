package liwei.example.com.allpeoplelive.bean;

import com.example.library.utils.netutils.ResponseBean;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * 1.类的用途
 * 2.@author:liwei
 * 3.@2017/1/4
 */

public class FaceControlBean extends ResponseBean{

    public List<RoomBean> room;
    public List<?> ad;

    public static List<FaceControlBean> arrayFaceControlBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<FaceControlBean>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static class RoomBean {
        /**
         * id : 0
         * name : 精彩推荐
         * is_default : 1
         * icon :
         * slug :
         * category_more :
         * type : 1
         * screen : 0
         * list : [{"beauty_cover":"","first_play_at":"2016-03-03 15:56:58","category_name":"英雄联盟","thumb":"http://snap.quanmin.tv/1247683-1483500722-408.jpg?imageView2/2/w/390/","last_play_at":"2017-01-03 09:00:33","screen":0,"video":"http://thumb.quanmin.tv/1247683.mp4?t=1483500600","title":"双目失明丝毫不影响我带蹦三路","recommend_image":"http://image.quanmin.tv/62ed828c3de80b726ba50ffade5a6125jpg","is_shield":false,"nick":"琦琦7","uid":1247683,"view":"61907","category_id":1,"slug":"","love_cover":"","level":0,"like":0,"weight":29082200,"avatar":"http://image.quanmin.tv/avatar/2cf9527652639992012f25691fcd728djpg?imageView2/2/w/300/","check":true,"follow":53834,"play_count":293,"play_true":806,"max_view":9692,"grade":0,"default_image":null,"last_end_at":"2016-03-03 15:56:58","create_at":"2017-01-04 09:00:39","category_slug":"lol","last_thumb":"1247683-1483422182-588.jpg","play_status":true,"anniversary":6,"status":1,"coin":1564224,"link":"http://www.quanmin.tv/v/1247683","icontext":""},{"beauty_cover":"","first_play_at":"2016-11-12 18:51:26","category_name":"颜值控","thumb":"http://image.quanmin.tv/love/e6a4d49bede4d80637c7c8519147f33ejpg?imageView2/2/w/500/","last_play_at":"2017-01-03 08:33:39","screen":1,"video":"http://thumb.quanmin.tv/8905858.mp4?t=1483500600","title":"专毁小清新","recommend_image":null,"is_shield":false,"nick":"LJ丶林妹妹","uid":8905858,"view":"2740","category_id":29,"slug":"","love_cover":"http://image.quanmin.tv/love/e6a4d49bede4d80637c7c8519147f33ejpg","level":0,"like":5962,"weight":0,"avatar":"http://image.quanmin.tv/avatar/d84050df49ecbb6e408dfa4b2c12e2adjpg?imageView2/2/w/300/","check":true,"follow":406,"play_count":90,"play_true":48,"max_view":102,"grade":0,"default_image":null,"last_end_at":"2016-11-12 18:51:26","create_at":"2017-01-04 08:30:34","category_slug":"love","last_thumb":"http://image.quanmin.tv/love/e6a4d49bede4d80637c7c8519147f33ejpg?imageView2/2/w/500/","play_status":true,"anniversary":1,"status":1,"coin":0,"link":"http://www.quanmin.tv/v/8905858","icontext":""},{"beauty_cover":"","first_play_at":"2016-05-24 09:34:33","category_name":"王者荣耀","thumb":"http://snap.quanmin.tv/3139574-1483500722-185.jpg?imageView2/2/w/390/","last_play_at":"2017-01-04 01:39:07","screen":0,"video":"http://thumb.quanmin.tv/3139574.mp4?t=1483500600","title":"早，开波车~！","recommend_image":null,"is_shield":false,"nick":"伊人醉丶七夜","uid":3139574,"view":"29708","category_id":17,"slug":"","love_cover":"http://image.quanmin.tv/love/0f2ee475e6034aa65bcb4cc553de705ajpg","level":0,"like":114,"weight":2210060,"avatar":"http://image.quanmin.tv/avatar/d86b0e0b94479a74d67d84114703b257?imageView2/2/w/300/","check":true,"follow":3347,"play_count":542,"play_true":340,"max_view":2780,"grade":0,"default_image":null,"last_end_at":"2016-05-24 09:34:33","create_at":"2017-01-04 08:52:01","category_slug":"wangzhe","last_thumb":"3139574-1483466462-864.jpg","play_status":true,"anniversary":8,"status":1,"coin":359557,"link":"http://www.quanmin.tv/v/3139574","icontext":""},{"beauty_cover":"","first_play_at":"2016-05-07 16:56:04","category_name":"炉石传说","thumb":"http://snap.quanmin.tv/2845343-1483500745-174.jpg?imageView2/2/w/390/","last_play_at":"2017-01-02 10:05:33","screen":0,"video":"http://thumb.quanmin.tv/2845343.mp4?t=1483500600","title":"霍金：鸽子海回归啦。！","recommend_image":"http://image.quanmin.tv/c585edf7fe97b08fe7722f5d6c0cf1afjpg","is_shield":false,"nick":"全民丶海老板威武","uid":2845343,"view":"147899","category_id":3,"slug":"hailaoban","love_cover":"","level":0,"like":0,"weight":9545220,"avatar":"http://image.quanmin.tv/avatar/2afb2abbbde5124e6b15db20bf2957ef?imageView2/2/w/300/","check":true,"follow":27246,"play_count":208,"play_true":974,"max_view":5276,"grade":0,"default_image":null,"last_end_at":"2016-05-07 16:56:04","create_at":"2017-01-04 09:58:46","category_slug":"heartstone","last_thumb":"2845343-1483337381-489.jpg","play_status":true,"anniversary":5,"status":1,"coin":695906,"link":"http://www.quanmin.tv/v/hailaoban","icontext":""},{"beauty_cover":"","first_play_at":"2016-12-21 21:29:07","category_name":"全民户外","thumb":"http://snap.quanmin.tv/10067415-1483500722-322.jpg?imageView2/2/w/390/","last_play_at":"2017-01-03 15:45:46","screen":0,"video":"http://thumb.quanmin.tv/10067415.mp4?t=1483500600","title":"极限挑战雪屋生存第14天 零下30度","recommend_image":null,"is_shield":false,"nick":"老秃吕户外","uid":10067415,"view":"7498","category_id":13,"slug":"","love_cover":"","level":0,"like":0,"weight":1037220,"avatar":"http://image.quanmin.tv/avatar/e3c8f939a1ab6c6a91011c21d9f270f0jpg?imageView2/2/w/300/","check":true,"follow":1553,"play_count":32,"play_true":220,"max_view":6700,"grade":0,"default_image":null,"last_end_at":"2016-12-21 21:29:07","create_at":"2017-01-04 09:43:51","category_slug":"huwai","last_thumb":"10067415-1483445462-649.jpg","play_status":true,"anniversary":0,"status":1,"coin":33266,"link":"http://www.quanmin.tv/v/10067415","icontext":""},{"beauty_cover":"","first_play_at":"2016-05-10 13:06:14","category_name":"英雄联盟","thumb":"http://snap.quanmin.tv/333-1483500721-744.jpg?imageView2/2/w/390/","last_play_at":"2017-01-02 10:00:21","screen":0,"video":"http://thumb.quanmin.tv/333.mp4?t=1483500600","title":"国服最强猴王，嘴缝了几针，少说话","recommend_image":"http://image.quanmin.tv/94c7901bce10d0636e704bba43a01045jpg","is_shield":false,"nick":"孙悟空zzzz","uid":333,"view":"399251","category_id":1,"slug":"","love_cover":"","level":0,"like":16,"weight":195814500,"avatar":"http://image.quanmin.tv/avatar/ac45513f9123f49adc064f02f835f6f6?imageView2/2/w/300/","check":true,"follow":543684,"play_count":250,"play_true":18772,"max_view":69058,"grade":0,"default_image":null,"last_end_at":"2016-05-10 13:06:14","create_at":"2017-01-04 10:01:19","category_slug":"lol","last_thumb":"333-1483346402-751.jpg","play_status":true,"anniversary":7,"status":1,"coin":2955780,"link":"http://www.quanmin.tv/v/333","icontext":""}]
         */

        public int id;
        public String name;
        public int is_default;
        public String icon;
        public String slug;
        public String category_more;
        public int type;
        public int screen;
        public List<ListBean> list;

        public static List<RoomBean> arrayRoomBeanFromData(String str) {

            Type listType = new TypeToken<ArrayList<RoomBean>>() {
            }.getType();

            return new Gson().fromJson(str, listType);
        }

        public static class ListBean {
            /**
             * beauty_cover :
             * first_play_at : 2016-03-03 15:56:58
             * category_name : 英雄联盟
             * thumb : http://snap.quanmin.tv/1247683-1483500722-408.jpg?imageView2/2/w/390/
             * last_play_at : 2017-01-03 09:00:33
             * screen : 0
             * video : http://thumb.quanmin.tv/1247683.mp4?t=1483500600
             * title : 双目失明丝毫不影响我带蹦三路
             * recommend_image : http://image.quanmin.tv/62ed828c3de80b726ba50ffade5a6125jpg
             * is_shield : false
             * nick : 琦琦7
             * uid : 1247683
             * view : 61907
             * category_id : 1
             * slug :
             * love_cover :
             * level : 0
             * like : 0
             * weight : 29082200
             * avatar : http://image.quanmin.tv/avatar/2cf9527652639992012f25691fcd728djpg?imageView2/2/w/300/
             * check : true
             * follow : 53834
             * play_count : 293
             * play_true : 806
             * max_view : 9692
             * grade : 0
             * default_image : null
             * last_end_at : 2016-03-03 15:56:58
             * create_at : 2017-01-04 09:00:39
             * category_slug : lol
             * last_thumb : 1247683-1483422182-588.jpg
             * play_status : true
             * anniversary : 6
             * status : 1
             * coin : 1564224
             * link : http://www.quanmin.tv/v/1247683
             * icontext :
             */

            public String beauty_cover;
            public String first_play_at;
            public String category_name;
            public String thumb;
            public String last_play_at;
            public int screen;
            public String video;
            public String title;
            public String recommend_image;
            public boolean is_shield;
            public String nick;
            public int uid;
            public String view;
            public int category_id;
            public String slug;
            public String love_cover;
            public int level;
            public int like;
            public int weight;
            public String avatar;
            public boolean check;
            public int follow;
            public int play_count;
            public int play_true;
            public int max_view;
            public int grade;
            public Object default_image;
            public String last_end_at;
            public String create_at;
            public String category_slug;
            public String last_thumb;
            public boolean play_status;
            public int anniversary;
            public int status;
            public int coin;
            public String link;
            public String icontext;

            public static List<ListBean> arrayListBeanFromData(String str) {

                Type listType = new TypeToken<ArrayList<ListBean>>() {
                }.getType();

                return new Gson().fromJson(str, listType);
            }
        }
    }
}
