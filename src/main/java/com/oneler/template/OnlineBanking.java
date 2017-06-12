package com.oneler.template;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.util.ISO8601DateFormat;

import java.text.ParseException;
import java.util.Date;

/**
 * Created by opure on 2017/6/1.
 */
public abstract class OnlineBanking {
    public static void main(String[] args) throws ParseException {
     /*   DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        df1.setTimeZone(TimeZone.getTimeZone("UTC"));
        System.out.println(df1.parse("2017-06-01T19:16:43.127Z").toString());*/
        ISO8601DateFormat df = new ISO8601DateFormat();
        System.out.println(df.parse("2017-06-01T19:16:43.127Z").toString());

        System.out.println(JSON.toJSONString(new Date()));
        System.out.println(new Date().getTime());
    }
}
