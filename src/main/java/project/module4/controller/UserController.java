package project.module4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import project.module4.dto.request.FormLogin;
import project.module4.dto.request.FormRegister;
import project.module4.model.Account;
import project.module4.service.accountService.AccountService;
import project.module4.validate.FormLoginValidate;
import project.module4.validate.FormRegisterValidate;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    private AccountService accountService;
    @Autowired
    private FormLoginValidate formLoginValidate;
    @Autowired
    private FormRegisterValidate formRegisterValidate;

    @RequestMapping("/login")
    public String login(Model model) {
        model.addAttribute("form_login", new FormLogin());
        return "login-register/login";
    }

    @RequestMapping(value = "/handle-login", method = RequestMethod.POST)
    public String doLogin(HttpSession httpSession, @ModelAttribute FormLogin formLogin,  BindingResult bindingResult,Model model) {
        formLoginValidate.validate(formLogin, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("form_login", formLogin);
            return "login-register/login";
        }
        Account userLogin = accountService.login(formLogin);
        if (userLogin == null) {
            model.addAttribute("form_login", formLogin);
            model.addAttribute("login_fail", "UserName or password incorrect");
            return "login-register/login";
        }
        httpSession.setAttribute("user-login", userLogin);
        return "user/chamb/index";
    }
    @RequestMapping("/register")
    public String register(Model model){
        model.addAttribute("form_register", new FormRegister());
        return "login-register/register";
    }
    @RequestMapping(value = "handle-register", method = RequestMethod.POST)
    public String doRegister(@ModelAttribute("form-register") FormRegister formRegister, BindingResult bindingResult){
        formRegisterValidate.validate(formRegister,bindingResult);
        if (bindingResult.hasErrors()){
            return "login-register/register";
        }
        accountService.register(formRegister);
        return "redirect:/login";
    }
}
