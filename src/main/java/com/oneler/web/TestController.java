package com.oneler.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by opure on 2017/6/2.
 */

@RequestMapping("/")
@RestController
public class TestController {



    @RequestMapping("/time")
    public void test(Date date) {
        System.out.println(date);
    }
}
