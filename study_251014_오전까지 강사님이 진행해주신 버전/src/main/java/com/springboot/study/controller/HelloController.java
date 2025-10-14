package com.springboot.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    /**
     * http로 호출하는 서비스 context path 주소를 매핑하는 작업
     * 예) /hello
     * 이름은 하나여야 함, 중복되면 에러 뜸
     */
    // URL 호출
    @GetMapping("/hello")
    public String hello(Model model) {
//        System.out.println("------> HelloController!!!");
        model.addAttribute("pathName","hello");
        model.addAttribute("data","홍길동");
        // 리턴하는 view name
        return "hello";
    }

    @GetMapping("/hello2")
    public String hello2(Model model) {
//        System.out.println("------> HelloController2!!!");
        model.addAttribute("pathName","hello2");
        model.addAttribute("data","홍길동 친구");
        return "hello";
    }

}
