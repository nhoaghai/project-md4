package project.module4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping({"/",""})
    public String home(){
        return "user/chamb/index";
    }
    @RequestMapping({"/admin"})
    public String dashboard() {
        return "admin/index";
    }

    @RequestMapping({"/catalog"})
    public String category() {
        return "admin/category";
    }

    @RequestMapping({"/product"})
    public String product() {
        return "admin/product";
    }

    @RequestMapping({"/user"})
    public String user() {
        return "admin/user";
    }
}
