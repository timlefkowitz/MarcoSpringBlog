package com.codeup.spingblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("/hello")
    @ResponseBody
    public String hello(){
        return "Hello from Spring boot to my friends in Marco!";
    }

    @GetMapping("/hello/{name}")
    @ResponseBody
    public String sayhello(
            @PathVariable String name) {
        return "Hello from Spring boot to my friend " + name + " in Marco!";
    }


}
