package com.example.filmdemoenkelspring;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloWorldParameterController {

    @RequestMapping("/helloparam")
    public String helloWorld(@RequestParam String fName){
        return "Hello " + fName;
    }

    @RequestMapping("/helloparamMany")
    public String helloWorld2(@RequestParam String fName,
                              @RequestParam String lName){
        return "Hello " + fName+" "+lName;
    }


    @RequestMapping("/helloparamDefault")
    public String helloWorldDefault(@RequestParam(defaultValue="Sigrun") String fName,
                              @RequestParam(defaultValue="Olafsdottir") String lName){
        return "Hello " + fName+" "+lName;
    }

    @RequestMapping("/helloparamOptional")
    public String helloWorldOptional(@RequestParam (required = false) String fName,
                              @RequestParam(required = false)String lName){

        if (fName==null){
            fName= "";
        }
        if (lName==null){
            lName= "";
        }
        return "Hello " + fName+" "+lName;
    }

    //http://localhost:8080/helloparamList?list=1&list=2&list=hej
    //http://localhost:8080/helloparamList?list=1,2,hej
    @RequestMapping("/helloparamList")
    public String helloWorldList(@RequestParam List<String> list){
        return "Hello " + list;
    }

    @RequestMapping("/hellopathparam/{id}/hej/")
    public String helloWorldPathParam(@PathVariable String id){
        return "Hello " +id;
    }

    @RequestMapping("/helloHTML")
    public String helloWorldHTML(@RequestParam String fName){
        return "<HTML><HEAD><TITLE>hello</TITLE></HEAD><BODY><H1>Hello " + fName+"<H1></BODY></HTML>";
    }

}
