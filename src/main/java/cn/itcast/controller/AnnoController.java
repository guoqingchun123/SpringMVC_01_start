package cn.itcast.controller;

import cn.itcast.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;


/**
 * @author GuoQingchun
 * @date 2020/5/20  - 17:02
 */
@Controller
@RequestMapping("/anno")
@SessionAttributes(value = "attr")
public class AnnoController {

    @RequestMapping("/requestParamTest")
    public String requestParamTest(@RequestParam("name") String username){
        System.out.println(username);
        return "success";
    }

    @RequestMapping("/requestBodyTest")
    public String requestBodyTest(@RequestBody String body){
        System.out.println(body);
        return "success";
    }

    @RequestMapping(value = "/pathVariableTest/{id}",method = RequestMethod.GET)
    public String pathVariableTest(@PathVariable(name = "id") String name){
        System.out.println(name);
        return "success";
    }

    /**
     * 获取请求头的值requestHeader
     * @param
     * @return
     */
    @RequestMapping("/testRequestHeader")
    public String testRequestHeader(@RequestHeader(name = "Accept") String header){
        System.out.println(header);
        return "success";
    }

    /**
     * 获取JsessionID
     * @param
     * @return
     */
    @RequestMapping("/testCookieValue")
    public String testCookieValue(@CookieValue(name = "JSESSIONID") String header){
        System.out.println(header);
        return "success";
    }

    /**
     * ModelAttribute注解演示
     * @param
     * @return
     */
    @RequestMapping("/testModelAttribute")
    public String testModelAttribute(@ModelAttribute("abc") User user){
        System.out.println(user);
        return "success";
    }

    /*@ModelAttribute
    public void modelAttr(String uname,Integer age,HashMap<String,User> map){
        System.out.println("modelAttr");
        User user = new User();
        user.setUname(uname);
        user.setAge(age);
        user.setBirthday(new Date());
        map.put("abc",user);
    }*/

    /**
     * ModelAttribute注解演示 存值
     * @param
     * @return
     */
    @RequestMapping("/testSessionAttribute")
    public String testSessionAttribute(Model model){
        System.out.println("testSessionAttribute");
        model.addAttribute("attr","美美");
        return "success";
    }

    /**
     * ModelAttribute注解演示 取值
     * @param
     * @return
     */
    @RequestMapping("/getSessionAttribute")
    public String getSessionAttribute(ModelMap modelMap){
        System.out.println("getSessionAttribute");

        System.out.println(modelMap.getAttribute("attr"));

        return "success";
    }

    /**
     * ModelAttribute注解演示 清除
     * @param
     * @return
     */
    @RequestMapping("/deleteSessionAttribute")
    public String deleteSessionAttribute(SessionStatus status){
        System.out.println("deleteSessionAttribute");
        status.setComplete();
        return "success";
    }

}
