package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>(); // Map은 key값으로 value를 얻어내는 자료형
    private static long sequnce = 0L; // 0, 1, 2, ... key값을 생성해준다

    @Override
    public Member save(Member member) {
        member.setId(++sequnce);
        store.put(member.getId(), member); // put은 Map의 메서드로 자료를 넣어준다(put)
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id)); // Optional.ofNullable는 반환값이 null이여도 감쌀수 있다, get은 Map의 메서드로 key에 해당하는 value를 가져온다(get)
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream() // values()는 value의 모든 요소들이 저장된 객체를 반환
                .filter(member -> member.getName().equals(name)) // member에서 member.getName이 name(findByName의 파라미터)과 같을경우에만 필터링
                .findAny(); // findAny()는 하나라도 찾으면 반환한다
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values()); // values는 Map의 value값 Member
    }
}
