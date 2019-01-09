package com.wzn.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wzn.pojo.User;
import com.wzn.service.IuserService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class WebTest {
    @Autowired
    private IuserService service;
    @RequestMapping("/index.do")
    public String index(ModelMap map){
        List<User> lists=service.getUser();
        map.addAttribute("lists",lists);
        return "index";
    }
    @RequestMapping("/login.do")
    public  String login(){
        return "login";
    }
    @RequestMapping("/doLogin.do")
    public String doLogin(){
        return "logins";
    }
    @RequestMapping("/upload.do")
    public String upload(){
        return "upload";
    }
    @RequestMapping("/doUpload.do")
    public String doUpload(@RequestParam("files") MultipartFile[] files){
        for (MultipartFile mf:files
             ) {
            if(!mf.isEmpty()){
                try {
                    File fil=new File("C:\\Users\\wzn\\Desktop\\新建文件夹\\"+mf.getOriginalFilename());
                    FileUtils.copyInputStreamToFile(mf.getInputStream(),fil);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return "";
    }
    @RequestMapping("list.do")
    public String list(ModelMap map, HttpServletRequest req,User user){
        int pageNum=req.getParameter("pageNum")==null?1:Integer.parseInt(req.getParameter("pageNum"));

        int pageSize=3;
        PageHelper.startPage(pageNum,pageSize);
        List<User> lists=service.getUsername(user);
        System.out.println(user);
        PageInfo<User> page=new PageInfo<>(lists);
        map.addAttribute("lists",lists);
        map.addAttribute("page",page);
        return "list";
    }
}
