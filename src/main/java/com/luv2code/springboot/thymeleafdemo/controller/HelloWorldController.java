package com.luv2code.springboot.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {
    @GetMapping("/showForm")
    public String showForm(){
        return "helloworld-form";
    }

    @GetMapping("/processForm")
    public String processForm(){
        return "helloworld";
    }

    @RequestMapping("/processFormVersionTwo")
    public String letsShoutDude(HttpServletRequest req, Model model){
        String theName = req.getParameter("studentName");
        theName = theName.toUpperCase();
        String result = "yo "+ theName;
        model.addAttribute("message",result);
        return "helloworld";

    }


    @PostMapping("/processFormVersionThree")
    public String processFormVersionThree(@RequestParam("studentName") String theName, Model model){

        theName = theName.toUpperCase();
        String result = "Hey My Friend from v3 "+ theName;
        model.addAttribute("message",result);
        return "helloworld";

    }


}
