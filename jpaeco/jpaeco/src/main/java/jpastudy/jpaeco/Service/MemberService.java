package jpastudy.jpaeco.Service;

import jpastudy.jpaeco.domain.Member;
import jpastudy.jpaeco.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor  // final 되어있는애만 생성자를 잡아줌 주석의 코드가 한줄로 되게끔
public class MemberService {

//    @Autowired
//    private final MemberRepository memberRepository;
//
//    //생성자가 하나일시 스프링에서 자동으로 어노테이션 해줌
//    public MemberService(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }

    private final MemberRepository memberRepository;

    /**
     * 회원가입
     */
    @Transactional
    public Long join(Member member) {

        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }
    /**
     * 중복회원 검증 (동일한 아이디가있는지)
     */
    //실무에서는 한번더 보험을 둔다
    private void validateDuplicateMember(Member member) {

        //EXCEPTION

        List<Member> findMembersToid = memberRepository.findById(member.getUserid());
        if(!findMembersToid.isEmpty()){
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }

    }

    //로그인

    //연동로그인?

    //로그아웃


    // 회원 전체조회
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    //회원 단일조회
    public Member findOne(Long memberId){
        return memberRepository.findOne(memberId);
    }


    //연동로그인

    // 마이페이지

    // 아이디찾기

    //비밀번호찾기



}
