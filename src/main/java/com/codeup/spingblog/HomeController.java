package com.codeup.spingblog;

import org.springframework.web.bind.annotation.*;

public class HomeController {




    @GetMapping("/")
    @ResponseBody
    public String landingPage(){
        return "This is the landing page!";
    }



}
