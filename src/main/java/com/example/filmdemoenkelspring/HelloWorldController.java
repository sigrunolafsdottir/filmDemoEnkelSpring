package com.example.filmdemoenkelspring;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

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

    @RequestMapping("/listTest")
    public List<Integer> listTest(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        return list;
    }

}
