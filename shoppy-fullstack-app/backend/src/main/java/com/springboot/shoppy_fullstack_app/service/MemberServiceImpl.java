package com.springboot.shoppy_fullstack_app.service;

import com.springboot.shoppy_fullstack_app.dto.Member;
import com.springboot.shoppy_fullstack_app.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@Transactional
// @Transactional DB가 auto-commit 모드이면 생략 가능
public class MemberServiceImpl implements MemberService{ // MemberService memberService

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository, PasswordEncoder passwordEncoder) {
        this.memberRepository = memberRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public int signup(Member member) {
        // 패스워드 인코딩
        String encodePwd = passwordEncoder.encode(member.getPwd()); // UUID 타입으로 생성됨
        member.setPwd(encodePwd);

//        System.out.println("encodePwd ==> "+encodePwd);
        return memberRepository.save(member);
//        return 0;
    }

    @Override
    public boolean idCheck(String id) {
        boolean result = true;

        // 변환 작업은 서버가 아닌 서비스가 담당하는 부분
        Long count = memberRepository.findById(id);
        System.out.println("count" + count);
        if(count == 0) result = false;

        return result;
    }

    @Override
    public boolean login(Member member) {
        boolean result = false;
        passwordEncoder.memberRepository.login(member.getId());
        return result;
    }
}
