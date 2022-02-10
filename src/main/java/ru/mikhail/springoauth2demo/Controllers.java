package ru.mikhail.springoauth2demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

@Controller
public class Controllers {
    @GetMapping("/")
    public String hello(){
        return "/index";
    }
    @GetMapping("/secrets")
    public String restricted(Principal p, Model model){
        String temp = p.toString();
        temp = temp.substring(temp.indexOf("given_name="));
        String name = temp.substring(0, temp.indexOf(",")).replace("given_name=","");
        temp = p.toString();
        temp = temp.substring(temp.indexOf("email="));
        String email = temp.substring(0, temp.indexOf("}")).replace("email=","");
        model.addAttribute("email", email);
        model.addAttribute("name", name);
        return "/secret";
    }
}
