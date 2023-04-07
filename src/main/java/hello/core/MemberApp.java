package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {
//        MemberService memberService = new MemberServiceImpl(); //AppConfig의 등장으로 더이상 직접 생성하여 DIP위반을 안해도된다.

//        AppConfig appConfig = new AppConfig(); //아래에서 Spring을 이용하여 호출하는 코드로 바뀜
//        MemberService memberService = appConfig.memberService();

        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class); //spring container에
                                                                                         //AppConfig에서 @Bean으로 지정한
                                                                                         //모든 객체를 등록해서 관리해준다.
        MemberService memberService = ac.getBean("memberService", MemberService.class);
                                            //AppConfig에 등록한 매서드이름, 반환타입

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());
    }
}
