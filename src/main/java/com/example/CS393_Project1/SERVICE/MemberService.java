package com.example.CS393_Project1.SERVICE;

import com.example.CS393_Project1.ENTITY.Member;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import org.springframework.stereotype.Service;
import com.example.CS393_Project1.REPO.MemberRepo;

@Service
public class MemberService {

    @Autowired
    private MemberRepo memberRepo;

    public List<Member> getAllMembers() {
        return memberRepo.findAll();
    }

    public Member getMemberById(Long id) {
        return memberRepo.findById(id).orElse(null);
    }

    public Member saveMember(Member member) {
        return memberRepo.save(member);
    }

    public Member updateMember(Long id, Member member) {
        member.setId(id);
        return memberRepo.save(member);
    }

    public void deleteMember(Long id) {
        memberRepo.deleteById(id);
    }
}
