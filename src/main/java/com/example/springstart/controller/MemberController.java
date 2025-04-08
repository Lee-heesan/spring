package com.example.springstart.controller;

import com.example.springstart.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {
     //생성자를 통해 들어온 것. (권장함)
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }

    //2. 필드 주입
//    @Autowired private MemberService memberService;


    // 3. setter
//    private MemberService memberService;
//
//    @Autowired
//    public void setMemberService(MemberService memberService){
//        this.memberService = memberService;
//    }


}
