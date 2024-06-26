package org.hello.hellospring.service;

import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.hello.hellospring.domain.Member;
import org.hello.hellospring.repository.MemberRepository;

@Transactional
public class MemberService {


  private final MemberRepository memberRepository;

  public MemberService(MemberRepository memberRepository) {
    this.memberRepository = memberRepository;
  }


  /**
   * 회원 가입
   */
  public Long join(Member member) {
    //같은 이름이 있는 중복 회원X
    validateDuplicateMember(member);
    memberRepository.save(member);
    return member.getId();
  }


  /**
   * 전체 회원 조회
   */
  public List<Member> findMembers() {
    return memberRepository.findAll();
  }

  public Optional<Member> findOne(Long memberId) {
    return memberRepository.findByID(memberId);
  }

  private void validateDuplicateMember(Member member) {
    memberRepository.findByName(member.getName()).ifPresent(m -> {
      throw new IllegalStateException("이미 존재하는 회원입니다.");
    });
  }
}
