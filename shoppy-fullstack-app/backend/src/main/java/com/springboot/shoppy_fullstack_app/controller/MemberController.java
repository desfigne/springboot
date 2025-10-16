package com.springboot.shoppy_fullstack_app.controller;

import com.springboot.shoppy_fullstack_app.dto.Member;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
@CrossOrigin(origins = {"http://localhost:3000"})
public class MemberController {
    @PostMapping("/login")
    public boolean login(@RequestBody Member member) {
        boolean result = false;
//        System.out.println(member.getId());
//        System.out.println(member.getPwd());
        if(member.getId().equals("test") && member.getPwd().equals("1234"));

        return result;
    }
}
