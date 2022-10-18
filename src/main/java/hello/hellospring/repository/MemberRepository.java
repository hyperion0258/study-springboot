package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id); // OPtional은 가져온 값이 null일 경우 null을 처리하는 방법중 하나
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
