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
 * 3.@2016/12/29
 */

public class HomeBean extends ResponseBean{


    public List<DataBean> data;

    public static List<HomeBean> arrayHomeBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<HomeBean>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static class DataBean {
        /**
         * description : 看别人的经历，理解自己的生活
         * id : 1
         * name : 深夜惊奇
         * thumbnail : http://pic3.zhimg.com/91125c9aebcab1c84f58ce4f8779551e.jpg
         */

        public String description;
        public int id;
        public String name;
        public String thumbnail;

        public static List<DataBean> arrayDataBeanFromData(String str) {

            Type listType = new TypeToken<ArrayList<DataBean>>() {
            }.getType();

            return new Gson().fromJson(str, listType);
        }
    }
}
