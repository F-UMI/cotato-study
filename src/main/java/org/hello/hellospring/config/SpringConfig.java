package org.hello.hellospring.config;

import org.hello.hellospring.repository.MemberRepository;
import org.hello.hellospring.repository.MemoryMemberRepository;
import org.hello.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

  @Bean
  public MemberService memberService() {
    return new MemberService(memberRepository());
  }

  @Bean
  public MemberRepository memberRepository() {
    return new MemoryMemberRepository();
  }

}
