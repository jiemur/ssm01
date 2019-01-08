package com.wzn.web;

import com.wzn.pojo.User;
import com.wzn.service.IuserService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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
}
