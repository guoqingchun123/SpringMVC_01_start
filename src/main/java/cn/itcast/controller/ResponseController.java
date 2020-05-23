package cn.itcast.controller;

import cn.itcast.pojo.User;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * @author GuoQingchun
 * @date 2020/5/20  - 21:21
 */
@Controller
@RequestMapping("/user")
public class ResponseController {

    @RequestMapping("/testString")
    public String testString(Model model){
        User user = new User();
        user.setUname("小李");
        user.setAge(20);
        model.addAttribute("user",user);
        return "success";
    }

    @RequestMapping("/testVoid")
    public void testVoid(Model model, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("testVoid");
        //编写请求转发的程序
        //request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request,response);
        //重定向
        //String contextPath = request.getContextPath();
        //response.sendRedirect(request.getContextPath()+"/index.jsp");

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        //直接进行相应

        response.getWriter().print("你好!!");
        return;
    }

    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView(){
        ModelAndView mv = new ModelAndView();
        User user = new User();
        user.setUname("小李");
        user.setAge(20);
        mv.addObject("user",user);
        mv.setViewName("success");
        return mv;
    }

    @RequestMapping("/testForwardOrRedirect")
    public String testString(){
        //转发:
        //return "forward:/WEB-INF/pages/success.jsp";
        //重定向
        return "redirect:/index.jsp";
    }

    @RequestMapping("/testAjax")
    public @ResponseBody User testAjax(@RequestBody User user){

        System.out.println(user);
        user.setUname("hei");
        user.setAge(50);
        return user;
    }

    @RequestMapping("/testFileUpload")
    public String testFileUpload(HttpServletRequest request) throws Exception {
        System.out.println("testFileUpload");
        String realPath = request.getSession().getServletContext().getRealPath("/uploads/");
        File file = new File(realPath);
        if (!file.exists()){
            file.mkdirs();
        }
        //解析request对象,获取上传文件项
        DiskFileItemFactory itemFactory = new DiskFileItemFactory();
        ServletFileUpload fileUpload = new ServletFileUpload(itemFactory);
        //解析request
        List<FileItem> items = fileUpload.parseRequest(request);
        //遍历
        for (FileItem item : items) {
            //进行判断当前item项是否是上传项
            if (item.isFormField()){
            //说明普通表单项
            }else {
                //说明上传文件项
                //获取上传文件的名称
                String name = item.getName();
                //把文件的名称设置成唯一值
                String uuid = UUID.randomUUID().toString().replace("-", "");
                name = uuid + "_" + name ;
                //完成文件上传
                item.write(new File(realPath,name));
                //删除临时文件
                item.delete();
            }
        }
        return "success";
    }

    @RequestMapping("/testSpringVMCFileUpload")
    public String testSpringVMCFileUpload(HttpServletRequest request,MultipartFile upload) throws Exception {
        System.out.println("testSpringVMCFileUpload");
        String realPath = request.getSession().getServletContext().getRealPath("/uploads/");
        File file = new File(realPath);
        if (!file.exists()){
            file.mkdirs();
        }
        //说明上传文件项
        //获取上传文件的名称
        String name = upload.getOriginalFilename();
        //把文件的名称设置成唯一值
        String uuid = UUID.randomUUID().toString().replace("-", "");
        name = uuid + "_" + name ;
        //完成文件上传
        upload.transferTo(new File(realPath,name));
        return "success";
    }

    /**
     * 夸服务器文件上传
     * @param
     * @param upload
     * @return
     * @throws Exception
     */
    @RequestMapping("/testFileUpload3")
    public String testFileUpload3(MultipartFile upload) throws Exception {
        System.out.println("夸服务器文件上传");
        //定义上传服务器路径
        String path = "http://localhost:8081/uploads/";
        //说明上传文件项
        //获取上传文件的名称
        String name = upload.getOriginalFilename();
        //把文件的名称设置成唯一值
        String uuid = UUID.randomUUID().toString().replace("-", "");
        name = uuid + "_" + name ;
        //创建客户端对象
        Client client = Client.create();
        //进行跨服务器连接
        WebResource resource = client.resource(path + name);
        //上传文件
        resource.put(upload.getBytes());
        return "success";
    }
    /**
     * 拦截器
     * @param
     * @param
     * @return
     * @throws Exception
     */
    @RequestMapping("/testInterceptor")
    public String testInterceptor() {
        System.out.println("testInterceptorController执行了");

        return "success";
    }
}
