package com.springboot.study.controller;

import com.springboot.study.dto.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/member")
@Controller
public class MemberController {
    /**
     * REST API 로그인 화면 (리액트 연동하면 필요없음)
     */
    @GetMapping("/restLogin")
    public String restLogin() {
        return "restLogin"; // view name
    }
    
    @GetMapping("/login")
    public String login() {
        return "login"; // 로그인 화면, view name --> templates
    }

    // Spring legacy (레거시 버전) 매핑 --> ModelAndView 객체를 활용하여 데이터 및 view 전송
//    @PostMapping("/login")
//    public ModelAndView login(@RequestParam String id, @RequestParam String pass) {
//        ModelAndView model = new ModelAndView();
//        String result = "";
//        if(id.equals("test") && pass.equals("1234")) result="[ModelAndView] 로그인 성공!!";
//        else result="[ModelAndView] 로그인 실패";
//
//        model.addObject("result", result);
//        model.setViewName("loginResult");
//
//        return model;
//    }

//    @PostMapping("/login")
//    // 맨처음 코드 작성시 파라미터가 없고, 이름이 같아 오버로딩이 불가함, 파라미터 추가 시 에러 사라짐
//    public String login(
//            @RequestParam String id,
//            @RequestParam String pass,
//            Model model) {
////        System.out.println("id --> " + id);
////        System.out.println("pass --> " + pass);
//        String result = "";
//        if(id.equals("test") && pass.equals("1234")) result="로그인 성공!!";
//        else result="로그인 실패";
//
//        model.addAttribute("result", result);
//
//        return "loginResult"; // view name : templates ==> loginResult.html
//    }

    @PostMapping("/login")
    // < 1. 여기부터
    // 스프링이 모델과 맴버 각각의 객체를 IoC 컨테이너로 생성하고 주소만 가져와서 사용함
    // 단일로 처리할때는 RequestParam, 한꺼번에 처리할때는 Member로 처리
    public String login(Member member, Model model) {
        // < 2. 여기부터
        String result = "";
        if(member.getId().equals("test") && member.getPass().equals("1234")) result="로그인 성공!!";
        else result="로그인 실패";
        // > 2. 여기까지 비즈니스 처리를 서비스 단에서 수행

        model.addAttribute("result", result);
        // > 1. 여기까지 리액트로도 처리가 가능함

        return "loginResult"; // view name : templates ==> loginResult.html
    }

    /**
     * REST API 회원가입 화면
     */
    @GetMapping("/restSignup")
    public String restSignup() {
        return "restSignup"; // view name
    }

    @GetMapping("/signup")
    public String signup() {
        return "signup"; // 로그인 화면, view name --> templates
    }

    @PostMapping("/signup")
    public String signup(Member member, Model model) {
        model.addAttribute("member", member);
        return "signupResult"; // 회원가입 화면, view name --> templates
    }
}
