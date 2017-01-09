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

public class WetChatBean extends ResponseBean{

    /**
     * code : 200
     * msg : success
     * newslist : [{"ctime":"2016-12-27","title":"怎样穿羽绒服不土~","description":"海优优海淘","picUrl":"http://mmbiz.qpic.cn/mmbiz_jpg/HII0VIibc00ibibPuOBibQBPF3leZUD4cwetfq7ibDEhNgZic6SlickSOvdngPr0OjDyVVJJ7YAr0QO4bmjMwGLoVe2rQ/640?wx_fmt=jpeg","url":"http://mp.weixin.qq.com/s/-VmaeVUyn4TP73SAcostSA"},{"ctime":"2016-12-27","title":"历史上先披露年报的企业表现怎么样？","description":"韭菜投资学","picUrl":"http://mmbiz.qpic.cn/mmbiz_jpg/LoMAiblSOazLKd65HD0Pp5yN4TY1ggR8qF8icQ1iauvib3E57RibiaJnbpXjGq48aBAnHDJpDkrqLqib8UYTahylVoicfw/0?wx_fmt=jpeg","url":"http://mp.weixin.qq.com/s/0Gbpgg2L78m9Dh9HwWusZQ"},{"ctime":"2016-12-27","title":"知识变现为什么火？2017年四大趋势","description":"腾讯研究院","picUrl":"http://mmbiz.qpic.cn/mmbiz_jpg/ljT2Dmxwr8wTpic7QP8UamDZU0a38HaM2oUoYdtrBjv9mWmzdtcryaaYhEdeS466UCcGU4piaLGvzrtOfiaXP5Ycg/0?wx_fmt=jpeg","url":"http://mp.weixin.qq.com/s/in7p9wIFD5OHEhHR5MQyPA"},{"ctime":"2016-12-27","title":"宗庆后打脸马云：除了新技术，其它4个都是胡说八道！董明珠又狠补一刀......","description":"派代网","picUrl":"http://mmbiz.qpic.cn/mmbiz_jpg/loPNdyhwibFGbcgg8B9iaAGYfnXU0TWw0ic0qGLYDWRLmkxn238kuShHeL64XDjLnyUPbDVCQDRXkoKeJFfHNTGPg/0?wx_fmt=jpeg","url":"http://mp.weixin.qq.com/s/fbtsxKyMnh2CH9d--5saVg"},{"ctime":"2016-12-27","title":"这10样东西不需要任何天赋，却可能助你取得成功","description":"锐普PPT","picUrl":"http://mmbiz.qpic.cn/mmbiz_jpg/iaLiboDYic5KNVdxfl10IcxsbDOzxF1QrB86f3ZazaERbjVkNo3pSSllgxYFk6NjD3buDzdWzZxffWGMLvIKRfo2A/0?wx_fmt=jpeg","url":"http://mp.weixin.qq.com/s/Lp6SDz7UGtdrpJrd0lYPwg"},{"ctime":"2016-12-26","title":"警方扫黄之后，我读了一遍《孙子兵法》，恍然大悟","description":"小马宋","picUrl":"http://mmbiz.qpic.cn/mmbiz_jpg/O3jEfe0IImfoEfpt6zQCGbgbwgralzyia9Gft0WorLcwvyhPOpF4dVLZug5ODE0icxJoo7Z9Wo1x2CZsP6INC0Kw/0?wx_fmt=jpeg","url":"http://mp.weixin.qq.com/s/VQAE1IHl6T-DCXWYWwDWdw"},{"ctime":"2016-12-26","title":"那些看似古板的人，其实脑洞最大","description":"一条","picUrl":"http://mmbiz.qpic.cn/mmbiz_jpg/OsOjJJlzzCN68mNecib9Wu5Kq3Se9qhb4iaefgz3jj2QoS2gEPKTxYrU1ngTR4XuQ9l6szCziaxciaFdsic6nREupnw/0?wx_fmt=jpeg","url":"http://mp.weixin.qq.com/s/uoAuLsb8Orhv15Zua4hjew"},{"ctime":"2016-12-26","title":"战场上被炸瞎双眼，奥运会拿下5枚金牌，这个美国人还有一个可以触摸时间的神器","description":"最黑科技","picUrl":"http://mmbiz.qpic.cn/mmbiz_jpg/wwVvAtDpsGrdPMDMZz9k4CJrB7J0gqW7CDwic74sHfhLJOW1v3DzNDU9VMWJ5y0BXT2dFNblnbIoicM5icZVw8KuQ/0","url":"http://mp.weixin.qq.com/s/CxhHlS9kCcdi2HKXbsZ3KQ"},{"ctime":"2016-12-26","title":"比你帅，比你有钱，比你努力，还比你会生活的钻石王老五！","description":"差评","picUrl":"http://mmbiz.qpic.cn/mmbiz_jpg/yZPTcMGWibvtiaPFS0lgW0nNUJh7BXAoN7SrhhB0zFLOKm32fNcKlrE4iaibXsCJicqcDVezUUJtmuKxETuPf6WciaoA/0?wx_fmt=jpeg","url":"http://mp.weixin.qq.com/s/xkB9adJov73zMgdla0lAYQ"},{"ctime":"2016-12-25","title":"为什么微信头像是方的，而QQ头像是圆的？","description":"互联网新鲜事","picUrl":"http://mmbiz.qpic.cn/mmbiz_jpg/7rGQr7yPGJpkeBwKiaiaGpewgK5S7yHZzeHVBusyV6RCbmOHWkqqtGaQmMsE73E0UY6KfhlKz5ibMsaeXv3icUe39w/0?wx_fmt=jpeg","url":"http://mp.weixin.qq.com/s/odTyAd8-1krQFUv-AOj7tg"}]
     */

    public int code;
    public String msg;
    public List<NewslistBean> newslist;

    public static List<WetChatBean> arrayWetChatBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<WetChatBean>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static class NewslistBean {
        /**
         * ctime : 2016-12-27
         * title : 怎样穿羽绒服不土~
         * description : 海优优海淘
         * picUrl : http://mmbiz.qpic.cn/mmbiz_jpg/HII0VIibc00ibibPuOBibQBPF3leZUD4cwetfq7ibDEhNgZic6SlickSOvdngPr0OjDyVVJJ7YAr0QO4bmjMwGLoVe2rQ/640?wx_fmt=jpeg
         * url : http://mp.weixin.qq.com/s/-VmaeVUyn4TP73SAcostSA
         */

        public String ctime;
        public String title;
        public String description;
        public String picUrl;
        public String url;

        public static List<NewslistBean> arrayNewslistBeanFromData(String str) {

            Type listType = new TypeToken<ArrayList<NewslistBean>>() {
            }.getType();

            return new Gson().fromJson(str, listType);
        }
    }
}
