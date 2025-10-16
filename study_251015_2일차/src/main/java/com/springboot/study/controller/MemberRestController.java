package com.springboot.study.controller;

import com.springboot.study.dto.Member;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
// 1. 내부에 @ResponseBody를 포함하고 있음
// 2. Map 객체 생성없이 JSON, 변수 객체 바로 전송이 가능함 (Map 만들 필요 없음)
public class MemberRestController {
    // 레스트컨트롤러로 전환하면서 맴버 컨트롤러로 이동 처리함
//    @GetMapping("/restLogin")
////    @ResponseBody 를 명시적으로 포함하지 않아도 됨
//    public String restLogin() {
//        return "restLogin"; // view name
//    }

    @PostMapping("/restLogin")
//    @ResponseBody
//    public Map<String, Boolean> restLogin(@RequestBody Member member) {
//    public Boolean restLogin(@RequestBody Member member) {
    public Map<String, Object> restLogin(@RequestBody Member member) {
//        System.out.println(member.getId());
//        System.out.println(member.getPass());
        
        // 로그인 수행
        boolean result = false;
        if(member.getId().equals("test") && member.getPass().equals("1234")) result = true;

        // 호출한 페이지로 문자열 혹은 JSON 객체로 전송되는 결과
//        return "restLogin";
//        return {"result": "로그인 성공!!"};

        // Map 객체(key, value)를 생성하여 전송
        // --> 자동으로 JSON 객체로 변환
        // 부모로 정의하고, 자식으로 호출함
//        Map<String, Boolean> response = new HashMap<String, Boolean>();
//        response.put("result", result);
        Map<String, Object> response = new HashMap<String, Object>();
        response.put("result", result);
        response.put("member", member);

//        return response; // 호출한 페이지로 문자열 혹은 JSON 객체로 전송되는 결과 : { "result": true }
        return response;
    }

    @PostMapping("/restSignup")
    public Member restSignup(@RequestBody Member member) {
        return member;
    }
}