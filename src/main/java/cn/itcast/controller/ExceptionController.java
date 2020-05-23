package cn.itcast.controller;

import cn.itcast.pojo.SysException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author GuoQingchun
 * @date 2020/5/21  - 16:16
 */
@Controller
@RequestMapping("/exception")
public class ExceptionController  {

    @RequestMapping("testException")
    public String testException() throws Exception{
        try {
            int a = 8/0;
        } catch (Exception e) {
            e.printStackTrace();
            throw new SysException("没有查询到该用户信息...");
        }
        return "success";
    }
}
