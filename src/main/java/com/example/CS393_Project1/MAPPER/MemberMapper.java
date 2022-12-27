package com.example.CS393_Project1.MAPPER;

import com.example.CS393_Project1.DTO.MemberDTO;
import com.example.CS393_Project1.ENTITY.Member;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MemberMapper {

    MemberMapper INSTANCE = Mappers.getMapper(MemberMapper.class);

    MemberDTO MembertoMemberDTO(Member member);
    Member MemberDTOtoMember(MemberDTO memberDTO);
}