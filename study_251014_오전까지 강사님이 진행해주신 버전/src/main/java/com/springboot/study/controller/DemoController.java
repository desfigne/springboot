package com.springboot.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// 1. 롤 부여 - 컨트롤러의 역할 부여
@Controller
public class DemoController {
    // 2.
    @GetMapping("/demo")
    // 3. 도메인 주소에서의 경로 이름
    public String demo() {
        System.out.println("------> DemoController!!!");
        // 4. 리소스 폴더에 있는 뷰 이름
        return "demo";
    }
}
