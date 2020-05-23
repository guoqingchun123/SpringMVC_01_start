package cn.itcast.controller;

import cn.itcast.pojo.Account;
import cn.itcast.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @author GuoQingchun
 * @date 2020/5/19  - 23:03
 */
@Controller
@RequestMapping(value = "/user")
public class HelloController {

    @RequestMapping(value="/hello", method = {RequestMethod.GET},
            params = "name=haha",headers = "Accept")
    public String satHello(){
        System.out.println("hello");

//        HandlerInterceptor
        return "success";
    }

    @RequestMapping("/saveAccount")
    public String saveAccount(Account account){
        System.out.println(account);
        return "success";
    }

    /**
     * 自定义类型转换器
     * @param user
     * @return
     */
    @RequestMapping("/converte")
    public String converte(User user){
        System.out.println("user = " + user);
        return "success";

    }

    /**
     * servlet原生注解
     * @param
     * @return
     */
    @RequestMapping("/servlet")
    public String servlet(HttpServletRequest request, HttpServletResponse response){
        System.out.println(request);
        System.out.println("response = " + response);
        System.out.println("Session() = " + request.getSession());
        System.out.println("ServletContext() = " + request.getSession().getServletContext());

        return "success";

    }
}
