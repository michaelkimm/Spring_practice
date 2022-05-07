package hello.hellospring.repository;

import hello.hellospring.Domain.Member;
import hello.hellospring.Repository.MemberRepository;
import hello.hellospring.Repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    void afterEach() {
        repository.clearAll();
    }

    @Test
    void save() {
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member member1 = repository.findById(member.getId()).get();
        Assertions.assertThat(member).isEqualTo(member1);
    }

    @Test
    void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");

        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");

        repository.save(member2);

        Member spring1 = repository.findByName("spring1").get();
        Assertions.assertThat(spring1).isEqualTo(member1);
    }

    @Test
    void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");

        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");

        repository.save(member2);

        List<Member> all = repository.findAll();
        Assertions.assertThat(all.size()).isEqualTo(2);
    }
}
