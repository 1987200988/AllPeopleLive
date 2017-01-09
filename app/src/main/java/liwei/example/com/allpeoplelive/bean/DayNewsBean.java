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
 * 3.@2016/12/30
 */

public class DayNewsBean extends ResponseBean{

    /**
     * date : 20161230
     * stories : [{"images":["http://pic1.zhimg.com/40e42971c222a8a02ec508d9daac2620.jpg"],"type":0,"id":9109113,"ga_prefix":"123014","title":"中国埃博拉疫苗研究获得重大突破，但是还不能下定论"},{"images":["http://pic1.zhimg.com/4997a1f56128d0b45a21ddc430baa1bc.jpg"],"type":0,"id":9109102,"ga_prefix":"123013","title":"哪些思维方式是你刻意训练过的？"},{"images":["http://pic4.zhimg.com/7173dc18bffda3acc555a49a3f7af9c7.jpg"],"type":0,"id":9107792,"ga_prefix":"123012","title":"大误 · 我很欣赏你，不如我把女儿嫁给你？"},{"title":"想为《魔兽世界》里牺牲的兔子们默哀三秒","ga_prefix":"123011","images":["http://pic4.zhimg.com/78dcb7e2f546823df87ddcf6e21fcb37.jpg"],"multipic":true,"type":0,"id":9108424},{"images":["http://pic1.zhimg.com/099efceb17f9ea7d52dcc61ebe82e880.jpg"],"type":0,"id":9088824,"ga_prefix":"123010","title":"不习惯直系领导的管理风格，应该怎么办？"},{"images":["http://pic4.zhimg.com/90acad2b4705405f5f14c5d77f02239f.jpg"],"type":0,"id":9107334,"ga_prefix":"123009","title":"有哪些大牛在自己相关领域被打脸的故事？"},{"images":["http://pic3.zhimg.com/b8c62ca71fb016116db5e294fa8aa326.jpg"],"type":0,"id":8678472,"ga_prefix":"123008","title":"孩子说话爱用叠词，因为他们比我们想象的要聪明多了"},{"images":["http://pic1.zhimg.com/d4fdc01009ed51588b2f702e2ca23db8.jpg"],"type":0,"id":9108309,"ga_prefix":"123007","title":"这个百变的原生木材家具，却常常被我们浪费"},{"images":["http://pic3.zhimg.com/f32511a9a89ee288f49b8ea0e2b121ba.jpg"],"type":0,"id":9108380,"ga_prefix":"123007","title":"微信小程序和网页版程序的区别在哪里？"},{"images":["http://pic2.zhimg.com/9b71f6843759543390fb4b9843480079.jpg"],"type":0,"id":9108397,"ga_prefix":"123007","title":"2016 年度盘点 · 你被哪一波商业潮流影响了？"},{"images":["http://pic2.zhimg.com/ba40280ffbff7068cd33b717886f347d.jpg"],"type":0,"id":9106695,"ga_prefix":"123006","title":"瞎扯 · 如何正确地吐槽"}]
     * top_stories : [{"image":"http://pic2.zhimg.com/0a7ea9c1e56ba8937959d791124d26cd.jpg","type":0,"id":9108424,"ga_prefix":"123011","title":"想为《魔兽世界》里牺牲的兔子们默哀三秒"},{"image":"http://pic1.zhimg.com/051d54d521840485725dc9588fb1d63c.jpg","type":0,"id":9108397,"ga_prefix":"123007","title":"2016 年度盘点 · 你被哪一波商业潮流影响了？"},{"image":"http://pic2.zhimg.com/f388ad82ffe062736aeb3ada3a981129.jpg","type":0,"id":9108380,"ga_prefix":"123007","title":"微信小程序和网页版程序的区别在哪里？"},{"image":"http://pic2.zhimg.com/1c5fca7f9f79287e91ed260cbd143d21.jpg","type":0,"id":9107334,"ga_prefix":"123009","title":"有哪些大牛在自己相关领域被打脸的故事？"},{"image":"http://pic1.zhimg.com/a401147f1e886be5e268bed525e65edc.jpg","type":0,"id":9107484,"ga_prefix":"122917","title":"知乎好问题 · 初为人父觉得时间被孩子剥夺，该如何调整？"}]
     */

    public String date;
    public List<StoriesBean> stories;
    public List<TopStoriesBean> top_stories;

    public static List<DayNewsBean> arrayDayNewsBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<DayNewsBean>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static class StoriesBean {
        /**
         * images : ["http://pic1.zhimg.com/40e42971c222a8a02ec508d9daac2620.jpg"]
         * type : 0
         * id : 9109113
         * ga_prefix : 123014
         * title : 中国埃博拉疫苗研究获得重大突破，但是还不能下定论
         * multipic : true
         */

        public int type;
        public int id;
        public String ga_prefix;
        public String title;
        public boolean multipic;
        public List<String> images;

        public static List<StoriesBean> arrayStoriesBeanFromData(String str) {

            Type listType = new TypeToken<ArrayList<StoriesBean>>() {
            }.getType();

            return new Gson().fromJson(str, listType);
        }
    }

    public static class TopStoriesBean {
        /**
         * image : http://pic2.zhimg.com/0a7ea9c1e56ba8937959d791124d26cd.jpg
         * type : 0
         * id : 9108424
         * ga_prefix : 123011
         * title : 想为《魔兽世界》里牺牲的兔子们默哀三秒
         */

        public String image;
        public int type;
        public int id;
        public String ga_prefix;
        public String title;

        public static List<TopStoriesBean> arrayTopStoriesBeanFromData(String str) {

            Type listType = new TypeToken<ArrayList<TopStoriesBean>>() {
            }.getType();

            return new Gson().fromJson(str, listType);
        }
    }
}
