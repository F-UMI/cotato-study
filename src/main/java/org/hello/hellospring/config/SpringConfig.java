package org.hello.hellospring.config;

import jakarta.persistence.EntityManager;
import javax.sql.DataSource;
import org.hello.hellospring.repository.JpaMemberRepository;
import org.hello.hellospring.repository.MemberRepository;
import org.hello.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

  private final DataSource dataSource;
  private final EntityManager em;

  public SpringConfig(DataSource dataSource, EntityManager em) {
    this.dataSource = dataSource;
    this.em = em;
  }

  @Bean
  public MemberService memberService() {
    return new MemberService(memberRepository());
  }

  @Bean
  public MemberRepository memberRepository() {
// return new MemoryMemberRepository();
// return new JdbcMemberRepository(dataSource);
// return new JdbcTemplateMemberRepository(dataSource);
    return new JpaMemberRepository(em);
  }
}
