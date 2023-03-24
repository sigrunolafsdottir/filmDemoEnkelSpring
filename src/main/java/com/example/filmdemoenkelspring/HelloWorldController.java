package com.example.filmdemoenkelspring;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {


    @RequestMapping("/")
    public String helloWorld(){
        return "Hello World!!!!!!!!!";
    }

    @RequestMapping("/esp")
    public String holaMundo(){
        return "Hola Mundo!!!!!!!!";
    }

}
