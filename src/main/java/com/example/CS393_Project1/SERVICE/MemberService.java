package com.example.CS393_Project1.SERVICE;

import com.example.CS393_Project1.DTO.CarDTO;
import com.example.CS393_Project1.DTO.MemberDTO;
import com.example.CS393_Project1.ENTITY.Car;
import com.example.CS393_Project1.ENTITY.Member;
import com.example.CS393_Project1.MAPPER.CarMapper;
import com.example.CS393_Project1.MAPPER.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.example.CS393_Project1.REPO.MemberRepo;

@Service
public class MemberService {

    @Autowired
    private MemberRepo memberRepo;

    public MemberDTO getMemberById(int id) {
        Member member = memberRepo.findById(id);
        return MemberMapper.INSTANCE.MembertoMemberDTO(member);
    }

    public void saveMember(MemberDTO MemberDTO) {
        Member member = MemberMapper.INSTANCE.MemberDTOtoMember(MemberDTO);
        memberRepo.save(member);
    }

    public List<MemberDTO> getAllMembers() {
        List<Member> members = memberRepo.findAll();
        List<MemberDTO> memberDTOs = new ArrayList<>();
        for (Member member : members){ memberDTOs.add(MemberMapper.INSTANCE.MembertoMemberDTO(member));}
        return memberDTOs;
    }

    public void deleteMember(int id) {
        Member member = memberRepo.findById(id);
        memberRepo.delete(member);
    }
}
