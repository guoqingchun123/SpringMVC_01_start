package cn.itcast.controller;

import cn.itcast.pojo.SysException;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author GuoQingchun
 * @date 2020/5/21  - 17:24
 */
@Controller
public class SysExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        SysException sysException = null;
        if (e instanceof SysException){
            sysException = (SysException) e;
        }else {
            sysException = new SysException("系统正在维护中...");
        }
        ModelAndView mv = new ModelAndView();
        mv.addObject("errorMessage",sysException.getMessage());
        mv.setViewName("error");
        return mv;
    }
}
