package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach // 어떤 메서드가 끝날때마다 아래의 메서드 실행 (콜백 메서드라고 생각하면됨)
    public void afterEach() {
        repository.clearStore(); // 테스트가 한번씩 끝날때마다 repository를 지운다
    }

    @Test // @Test 어노테이션을 붙여주면 아래의 메서드를 실행 가능 Test는 순서가 보장이 안되기 때문에 순서와 상관없이(의존관계없이) 메서드별로 따로 동작하게 설계해야함
    public void save() {
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get(); // 반환타입이 Optional이므로 꺼낼때는 get()메서드 사용
//        System.out.println("result = " + (result == member));
//        Assertions.assertEquals(member, result); // Assertions.assertEquals()는 member값을 기대값으로 설정하고 result를 실제값으로 설정한다. 그래서 둘이 동일하면 테스트를 통과 동일하지 않으면 테스트를 실패한다.
//        Assertions.assertEquals(member, null);
//        Assertions.assertThat(member).isEqualTo(result); // org.assertj.core.api의 Assertions를 사용하면 직관적이다. member가 result과 동일하면 테스트 통과 그렇지 않으면 실패
        assertThat(member).isEqualTo(member); // Assertions을 static import한것
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1); // member1 save(회원가입)

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2); // member2 save(회원가입)

        Member result = repository.findByName("spring1").get();
//        Member result = repository.findByName("spring2").get(); // 다른 객체이므로 오류

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() { // class레벨에서 Test를 할때 findAll에서 객체를 이미 만들었기 때문에 findByName에서 에러가 난다(다른 객체) 따라서 Test가 끝날때마다 repository를 깔끔하게 지워주는 코드를 짜야 한다
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll(); // List는 배열과 비슷하나 자료를 넣는 만큼 자동적으로 사이즈가 들어나기 때문에 동적으로 활용하기 유리하다

        assertThat(result.size()).isEqualTo(2); // result의 size메서드는 List의 길이를 반환하는 함수
//        assertThat(result.size()).isEqualTo(3);
    }
}
