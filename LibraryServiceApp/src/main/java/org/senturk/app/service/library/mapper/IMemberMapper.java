package org.senturk.app.service.library.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.senturk.app.service.library.data.entity.Member;
import org.senturk.app.service.library.dto.MemberDTO;
import org.senturk.app.service.library.dto.MembersDTO;

import java.util.List;

@Mapper(implementationName = "MemberMapperImpl", componentModel = "spring")
public interface IMemberMapper {
    Member toMember(MemberDTO memberDTO);

    @Mapping(source = "book", target = "data")
    MemberDTO toMemberDTO(Member member);

    default MembersDTO toMembersDTO(List<MemberDTO> members)
    {
        var result = new MembersDTO();
        result.members = members;

        return result;
    }
}
