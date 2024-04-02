package org.hello.hellospring.repository;

import java.util.List;
import java.util.Optional;
import org.hello.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository {

  Member save(Member member);
  Optional<Member> findByID(Long id);
  Optional<Member> findByName(String name);
  List<Member> findAll();
}
