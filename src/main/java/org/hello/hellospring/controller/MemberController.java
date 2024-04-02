package org.hello.hellospring.controller;

import org.hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

  private final MemberService  memberService;


  @Autowired //컨테이너에서 서비스를 가져온다
  public MemberController(MemberService memberService) {
    this.memberService = memberService;
  }
}
