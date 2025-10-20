package com.springboot.shoppy_fullstack_app.service;

import com.springboot.shoppy_fullstack_app.dto.Member;
import com.springboot.shoppy_fullstack_app.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService{ // MemberService memberService

    private final MemberRepository memberRepository;

    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public int signup(Member member) {
        return memberRepository.save(member);
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
}
