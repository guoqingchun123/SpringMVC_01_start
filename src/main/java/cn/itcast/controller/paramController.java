package cn.itcast.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author GuoQingchun
 * @date 2020/5/20  - 13:52
 */
@RequestMapping("/param")
@Controller
public class paramController {

    @RequestMapping("/paramTest")
    public String paramTest(String name,String password){
        System.out.println("name = " + name);
        System.out.println("password = " + password);
        return "success";

    }
}
