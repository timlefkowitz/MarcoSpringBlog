package com.codeup.spingblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {




    @GetMapping("/")
    @ResponseBody
    public String landingPage(){
        return "This is the landing page!";
    }

    @GetMapping("/home")
    public String Welcome(){

//        try{
//            (
//        }catch)
        return "home";
    }

    @GetMapping("/partials/navbar")
    private String Navbar() {
        return "navbar";
    }









}
