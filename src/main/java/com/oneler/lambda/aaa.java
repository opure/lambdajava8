package com.oneler.lambda;



import java.util.Collections;
import java.util.Map;
import java.util.HashMap;

/**
 * Created by opure on 2017/4/21.
 */
public class aaa {
    public static void main(String[] args) {

        Map<String,Object> map = new HashMap<>();
        map.put("21",true);
        map.put("left",41);
        Result result = new Result();
        result.setObject(map);
        Map<String,Object> map1 = (Map<String, Object>) result.getObject();
        System.out.println(map1.get("21").toString().equals("true"));
    }
}
