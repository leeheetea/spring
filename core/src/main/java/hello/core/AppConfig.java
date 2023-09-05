package hello.core;

import discount.DiscountPolicy;
import discount.RateDiscountPolicy;
import member.MemberRepository;
import member.MemberService;
import member.MemberServiceImpl;
import member.MemoryMemberRepository;
import order.OrderService;
import order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService () {

        return new MemberServiceImpl(MemberRepository());
    }

    @Bean
    public OrderService orderService(){

        return new OrderServiceImpl(MemberRepository(), dicountPolicy());
    }

    @Bean
    public static MemberRepository MemberRepository() {

        return new MemoryMemberRepository();
    }

    @Bean
    public static DiscountPolicy dicountPolicy() {
        return new RateDiscountPolicy();
    }
}
