package org.example.controller;

import org.example.service.QuickService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class QuickController {

    // 在Controller中直接注入Service

    @Autowired
    private QuickService quickService;

   //@RequestMapping(path = "/show",method = RequestMethod.GET)
    @GetMapping(path = "/show")
    public String show(){
        System.out.println("show running ....."+quickService);
        return "/index.jsp";
    }

    @RequestMapping("/show2")
    public String show2(){
        System.out.println("show running .....");
        return "/index2.jsp";
    }
}
