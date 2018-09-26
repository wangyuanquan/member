package com.example.demo;


import com.alibaba.fastjson.JSONObject;
import com.rechenggit.MemberManageServiceApplication;
import com.rechenggit.core.domainservice.repository.MemberRepository;
import com.rechenggit.core.domainservice.repository.SequenceRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MemberManageServiceApplication.class)
public class MemberManageServiceApplicationTests {
@Autowired
    SequenceRepository sequenceRepository;
    @Autowired
    MemberRepository memberRepository;


    @Test
    public void contextLoads() {
        System.out.println(111);
       // sequenceRepository.flush();
        System.out.println("seq_member_id");
        System.out.println(sequenceRepository.next("seq_member_id"));
    }
    @Test
    public void memberRepositoryTest() {
        System.out.println(111);
        // sequenceRepository.flush();
        System.out.println("200001380005");
    }

}
