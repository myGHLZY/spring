package org.example.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
public class ParamsController {

//    http://localhost:8080/param1?username=zhangsan&age=20
    @GetMapping("/param1")
    public String Param1(String username,Integer age){
        System.out.println("params1");
        System.out.println("username = "+username);
        System.out.println("age = "+age);
        return "index.jsp";
    }

    @GetMapping("/param2")
    public String Param2(@RequestParam("username") String name, Integer age){
        System.out.println("params2");
        System.out.println("username = "+name);
        System.out.println("age = "+age);
        return "index.jsp";
    }


//    http://localhost:8080/param3?hobby=op&hobby=ui&hobby=90
    @GetMapping("/param3")
    public String Param3(String[] hobby){
        System.out.println("param3");
        for(String hb:hobby){
            System.out.println(hb);
        }
        return "index.jsp";
    }

    @GetMapping("/param4")
    public String Param4(@RequestParam() List<String> hobby){
        System.out.println("param4");
        for(String hb:hobby){
            System.out.println(hb);
        }
        return "index.jsp";
    }

//    http://localhost:8080/param5?name=zhangsan&age=20&hobby=op&hobby=ui&hobby=90&city.cityName=tianjin&city.cityNum=222
    @GetMapping("/param5")
    public String Param5(User user){
        System.out.println("param5");
        System.out.println(user);
        return "index.jsp";
    }


    @PostMapping ("/param6")
    public String Param6(@RequestBody String body) throws JsonProcessingException {
        System.out.println("param6");
        System.out.println(body);

        ObjectMapper objectMapper = new ObjectMapper();
        User user = objectMapper.readValue(body, User.class);
        System.out.println(user);
        return "index.jsp";
    }

    @PostMapping ("/param7")
    public String Param7(@RequestBody User user) throws JsonProcessingException {
        System.out.println("param7");

        System.out.println(user);
        return "index.jsp";
    }

    @PostMapping("/param8")
    public String Param8(@RequestBody MultipartFile myFile) throws JsonProcessingException {
        System.out.println("param8");
        System.out.println(myFile);
        return "index.jsp";
    }

}
