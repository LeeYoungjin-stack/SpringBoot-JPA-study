package jpastudy.jpaeco.Service;

import jpastudy.jpaeco.domain.Member;
import jpastudy.jpaeco.repository.MemberRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class MemberServiceTest {

        @Autowired MemberService memberService;
        @Autowired MemberRepository memberRepository;

    /**
     *  TDD
     */

    @Test
//    @Rollback(false) // 롤백하지말고 의심스러우니까 일단 db에 넣어줘봐 (확인완료)
    public void 회원가입() throws Exception{

        //given
        Member member = new Member();
        member.setUsername("lee");

        //when
        Long savedId = memberService.join(member);

        //then
        assertEquals(member, memberRepository.findOne(savedId));
    }

    @Test
    public void 중복_회원_방지() throws Exception{

        //given
        Member member1 = new Member();
        member1.setUserid("dudwls0505");

        Member member2 = new Member();
        member2.setUserid("dudwls0505");

        //when
        memberService.join(member1);
        try {
            memberService.join(member2); // 중복되는지 확인
        }catch (IllegalStateException e){
            return;
        }
        //then
        fail("예외가 발생해야함.");


    }


}