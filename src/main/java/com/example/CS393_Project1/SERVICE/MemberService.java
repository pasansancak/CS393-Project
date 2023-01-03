package com.example.CS393_Project1.SERVICE;

import com.example.CS393_Project1.DTO.MemberDTO;
import com.example.CS393_Project1.ENTITY.Member;
import com.example.CS393_Project1.MAPPER.MemberMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.example.CS393_Project1.REPO.MemberRepo;

@Service
public class MemberService {

    @Autowired
    private MemberRepo memberRepo;

    @Transactional
    public MemberDTO getMemberById(int id) {
        Member member = memberRepo.findById(id);
        return MemberMapper.INSTANCE.MembertoMemberDTO(member);
    }

    @Transactional
    public MemberDTO saveMember(MemberDTO MemberDTO) {
        Member member = MemberMapper.INSTANCE.MemberDTOtoMember(MemberDTO);
        memberRepo.save(member);
        return MemberMapper.INSTANCE.MembertoMemberDTO(member);
    }

    @Transactional
    public List<MemberDTO> getAllMembers() {
        List<Member> members = memberRepo.findAll();
        List<MemberDTO> memberDTOs = new ArrayList<>();
        for (Member member : members){ memberDTOs.add(MemberMapper.INSTANCE.MembertoMemberDTO(member));}
        return memberDTOs;
    }

    @Transactional
    public void deleteMember(int id) {
        Member member = memberRepo.findById(id);
        memberRepo.delete(member);
    }
}
