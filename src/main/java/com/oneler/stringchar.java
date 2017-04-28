package com.oneler;

import com.sun.javafx.collections.MappingChange;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by opure on 2017/4/18.
 */
public class stringchar {
    public static void main(String[] args) {
        String s = "何维波       ③号餐--花生炖猪脚饭\n" +
                "冷鹤敏       ⑦号餐--红烧排骨饭\n" +
                "刘梦丽       ④号餐--酸辣鸡杂饭\n" +
                "刘洋(小包)    ⑤号餐--鸡腿饭\n" +
                "刘莹(小包)    ⑦号餐--红烧排骨饭\n" +
                "向志彬       ⑤号餐--鸡腿饭\n" +
                "宋威        ③号餐--花生炖猪脚饭\n" +
                "彭林成       ②号餐--糖醋鱼饭\n" +
                "杨文娣       ④号餐--酸辣鸡杂饭\n" +
                "林莉华       ⑦号餐--红烧排骨饭\n" +
                "沈二妹       ⑧号餐--蒜薹炒肉饭\n" +
                "肖赟        ③号餐--花生炖猪脚饭\n" +
                "胡中央       ⑦号餐--红烧排骨饭\n" +
                "董慧越       ③号餐--花生炖猪脚饭\n" +
                "袁小红       ⑦号餐--红烧排骨饭\n" +
                "裴志生       ①号餐--啤酒鸭饭\n" +
                "谢秀敏       ⑥号餐--尖椒肉片饭\n" +
                "赵一萍       ⑧号餐--蒜薹炒肉饭\n" +
                "邓敏娴       ⑦号餐--红烧排骨饭\n" +
                "钱永红       ⑤号餐--鸡腿饭\n" +
                "陈妍君       ⑧号餐--蒜薹炒肉饭\n" +
                "陈妍君       ⑧号餐--蒜薹炒肉饭\n" +
                "陈妍君       ⑧号餐--蒜薹炒肉饭\n" +
                "陈妍君       ⑧号餐--蒜薹炒肉饭\n" +
                "陈妍君       ⑧号餐--蒜薹炒肉饭\n" +
                "陈妍君       ⑧号餐--蒜薹炒肉饭\n" +
                "陈妍君       ⑧号餐--蒜薹炒肉饭\n" +
                "陈妍君       ⑧号餐--蒜薹炒肉饭\n" +
                "陈妍君       ⑧号餐--蒜薹炒肉饭\n" +
                "董慧越       ③号餐--花生炖猪脚饭\n" +
                "袁小红       ⑦号餐--红烧排骨饭\n" +
                "裴志生       ①号餐--啤酒鸭饭\n" +
                "谢秀敏       ⑥号餐--尖椒肉片饭\n" +
                "赵一萍       ⑧号餐--蒜薹炒肉饭\n" +
                "邓敏娴       ⑦号餐--红烧排骨饭\n" +
                "钱永红       ⑤号餐--鸡腿饭\n" +
                "陈妍君       ⑧号餐--蒜薹炒肉饭\n" +
                "陈妍君       ⑧号餐--蒜薹炒肉饭\n" +
                "陈妍君       ⑧号餐--蒜薹炒肉饭\n" +
                "陈妍君       ⑧号餐--蒜薹炒肉饭\n" +
                "陈妍君       ⑧号餐--蒜薹炒肉饭\n" +
                "陈妍君       ⑧号餐--蒜薹炒肉饭\n" +
                "陈妍君       ⑧号餐--蒜薹炒肉饭\n" +
                "陈妍君       ⑧号餐--蒜薹炒肉饭\n" +
                "陈妍君       ⑧号餐--蒜薹炒肉饭\n" +
                "董慧越       ③号餐--花生炖猪脚饭\n" +
                "袁小红       ⑦号餐--红烧排骨饭\n" +
                "裴志生       ①号餐--啤酒鸭饭\n" +
                "谢秀敏       ⑥号餐--尖椒肉片饭\n" +
                "赵一萍       ⑧号餐--蒜薹炒肉饭\n" +
                "邓敏娴       ⑦号餐--红烧排骨饭\n" +
                "钱永红       ⑤号餐--鸡腿饭\n" +
                "陈妍君       ⑧号餐--蒜薹炒肉饭\n" +
                "陈妍君       ⑧号餐--蒜薹炒肉饭\n" +
                "陈妍君       ⑧号餐--蒜薹炒肉饭\n" +
                "陈妍君       ⑧号餐--蒜薹炒肉饭\n" +
                "陈妍君       ⑧号餐--蒜薹炒肉饭\n" +
                "陈妍君       ⑧号餐--蒜薹炒肉饭\n" +
                "陈妍君       ⑧号餐--蒜薹炒肉饭\n" +
                "陈妍君       ⑧号餐--蒜薹炒肉饭\n" +
                "陈妍君       ⑧号餐--蒜薹炒肉饭\n" +
                "陈妍君       ⑧号餐--蒜薹炒肉饭\n" +
                "陈妍君       ⑧号餐--蒜薹炒肉饭\n" +
                "陈妍君       ⑧号餐--蒜薹炒肉饭\n" +
                "陈妍君       ⑧号餐--蒜薹炒肉饭\n" +
                "陈妍君       ⑧号餐--蒜薹炒肉饭\n" +
                "陈妍君       ⑧号餐--蒜薹炒肉饭\n" +
                "陈妍君       ⑧号餐--蒜薹炒肉饭\n" +
                "陈妍君       ⑧号餐--蒜薹炒肉饭\n" +
                "陈妍君       ⑧号餐--蒜薹炒肉饭\n" +
                "陈妍君       ⑧号餐--蒜薹炒肉饭\n" +
                "陈妍君       ⑧号餐--蒜薹炒肉饭\n" +
                "陈妍君       ⑧号餐--蒜薹炒肉饭\n" +
                "陈妍君       ⑧号餐--蒜薹炒肉饭\n" +
                "陈妍君       ⑧号餐--蒜薹炒肉饭\n" +
                "陈妍君       ⑧号餐--蒜薹炒肉饭\n" +
                "陈妍君       ⑧号餐--蒜薹炒肉饭\n" +
                "陈妍君       ⑧号餐--蒜薹炒肉饭\n" +
                "陈妍君       ⑧号餐--蒜薹炒肉饭\n" +
                "陈妍君       ⑧号餐--蒜薹炒肉饭\n" +
                "陈妍君       ⑧号餐--蒜薹炒肉饭\n" +
                "陈妍君       ⑧号餐--蒜薹炒肉饭\n" +
                "陈妍君       ⑧号餐--蒜薹炒肉饭\n" +
                "陈妍君       ⑧号餐--蒜薹炒肉饭\n" +
                "陈妍君       ⑧号餐--蒜薹炒肉饭\n" +
                "陈妍君       ⑧号餐--蒜薹炒肉饭\n" +
                "陈妍君       ⑧号餐--蒜薹炒肉饭\n" +
                "陈妍君       ⑧号餐--蒜薹炒肉饭\n" +
                "陈妍君       ⑧号餐--蒜薹炒肉饭\n" +
                "陈妍君       ⑧号餐--蒜薹炒肉饭\n" +
                "陈妍君       ⑧号餐--蒜薹炒肉饭\n" +
                "陈妍君       ⑧号餐--蒜薹炒肉饭\n" +
                "沈二妹       ⑧号餐--蒜薹炒肉饭\n" +
                "肖赟        ③号餐--花生炖猪脚饭\n" +
                "肖赟        ③号餐--花生炖猪脚饭\n" +
                "胡中央       ⑦号餐--红烧排骨饭\n" +
                "董慧越       ③号餐--花生炖猪脚饭\n" +
                "袁小红       ⑦号餐--红烧排骨饭\n" +
                "陈敏华  ⑦号餐--红烧排骨饭\n";

        Matcher m = Pattern.compile("(?m)^.*$").matcher(s);
        int length = 0;
        String firstMesaage = "";
        String secondMessage = "";
        while (m.find()) {
            length += m.group().getBytes().length;
            if(length<=1900) {
                firstMesaage += m.group()+"\n";

            }else {
                secondMessage += m.group()+"\n";
            }
        }
        System.out.println(s.length());
        System.out.println(firstMesaage.length());
        System.out.println("dd"+secondMessage.length());
    }
}
