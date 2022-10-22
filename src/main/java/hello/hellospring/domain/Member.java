package hello.hellospring.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // @Entity가 붙으면 jpa가 관리한다는 뜻
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) // @Id는 pk이고 @GeneratedValue(strategy = GenerationType.IDENTITY)의 IDENTITY는 db가 알아서 생성해준다
    private Long id; // 임의의 값, 고객이 정하는 id가 아닌 시스템이 정하는 id
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
