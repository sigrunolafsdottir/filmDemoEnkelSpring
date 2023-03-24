package com.example.filmdemoenkelspring;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HelloWorldViewController {


    @RequestMapping("/hello")
    public String helloWorld(){
        return "helloWorld.html";
    }

    @RequestMapping("/helloesp")
    public String holaMundo(){
        return "holaMundo.html";
    }


}
