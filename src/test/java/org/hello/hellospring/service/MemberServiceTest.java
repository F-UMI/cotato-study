package org.hello.hellospring.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.hello.hellospring.domain.Member;
import org.hello.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.annotation.Commit;

class MemberServiceTest {

  MemberService memberService;
  MemoryMemberRepository memberRepository;


  /**
   * DI (Dependency Injection)
   */
  @BeforeEach
  public void beforeEach() {
    memberRepository = new MemoryMemberRepository();
    memberService = new MemberService(memberRepository);
  }

  @AfterEach
  public void afterEach() {
    memberRepository.clearStore();
  }


  @Test
  @Commit
    // 실제 DB에 값을 삽입
  void 회원가입() {
    //given
    Member member = new Member();
    member.setName("hello");

    //when
    Long saveId = memberService.join(member);

    //then
    Member findMember = memberService.findOne(saveId).get();
    assertThat(member.getName()).isEqualTo(findMember.getName());
  }

  @Test
  public void 중복_회원_예외() {
    //given
    Member member1 = new Member();
    member1.setName("spring");

    Member member2 = new Member();
    member2.setName("spring");

    //when
    memberService.join(member1);
    IllegalStateException e = assertThrows(IllegalStateException.class,
        () -> memberService.join(member2));
    assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

/*    try {
      memberService.join(member2);
      fail();
    } catch (IllegalStateException e) {
      assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다. 123123");
    }*/

    //then
  }

  @Test
  void findMembers() {
    //given

    //when

    //then
  }

  @Test
  void findOne() {
    //given

    //when

    //then
  }
}