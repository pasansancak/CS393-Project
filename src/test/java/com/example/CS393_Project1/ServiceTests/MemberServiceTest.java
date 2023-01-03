package com.example.CS393_Project1.ServiceTests;

//package com.example.CS393_Project1.SERVICE;

import com.example.CS393_Project1.DTO.MemberDTO;
import com.example.CS393_Project1.ENTITY.Member;
import com.example.CS393_Project1.MAPPER.MemberMapper;
import com.example.CS393_Project1.REPO.MemberRepo;
import com.example.CS393_Project1.SERVICE.MemberService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class MemberServiceTest {

    @Mock
    private MemberRepo memberRepo;

    private MemberService memberService;

    private Member member;
    private MemberDTO memberDTO;

    @BeforeEach
    void setUp() {
        memberService = new MemberService();

        member = new Member();
        member.setId(1);
        member.setFirstName("John");
        member.setLastName("Doe");
        member.setEmail("john.doe@example.com");

        memberDTO = MemberMapper.INSTANCE.MembertoMemberDTO(member);
    }

    @Test
    void getMemberById() {
        // given
        Mockito.when(memberRepo.findById(member.getId())).thenReturn(member);

        // when
        MemberDTO result = memberService.getMemberById(member.getId());

        // then
        assertThat(result).isEqualToComparingFieldByField(memberDTO);
    }

    @Test
    void saveMember() {
        // given
        Mockito.when(memberRepo.save(member)).thenReturn(member);

        // when
        MemberDTO result = memberService.saveMember(memberDTO);

        // then
        assertThat(result).isEqualToComparingFieldByField(memberDTO);
    }

    @Test
    void getAllMembers() {
        // given
        List<Member> members = new ArrayList<>();
        members.add(member);
        Mockito.when(memberRepo.findAll()).thenReturn(members);

        // when
        List<MemberDTO> result = memberService.getAllMembers();

        // then
        assertThat(result).isEqualTo(List.of(memberDTO));
    }

    @Test
    void deleteMember() {
        // when
        memberService.deleteMember(member.getId());

        // then
        Mockito.verify(memberRepo).delete(member);
    }
}

