package org.senturk.app.service.library.service;


import org.senturk.app.service.library.data.dal.LibraryServiceHelper;
import org.senturk.app.service.library.data.entity.Member;
import org.senturk.app.service.library.dto.MemberDTO;
import org.senturk.app.service.library.dto.MembersDTO;
import org.senturk.app.service.library.mapper.IBookMapper;
import org.senturk.app.service.library.mapper.IMemberMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.csystem.util.collection.CollectionUtil.toList;
import static org.csystem.util.data.DatabaseUtil.doWorkForService;

@Service
public class LibraryAppService {
    private final LibraryServiceHelper m_libraryServiceHelper;
    private final IMemberMapper m_memberMapper;
    private final IBookMapper m_bookMapper;


    public LibraryAppService(LibraryServiceHelper libraryServiceHelper, IMemberMapper memberMapper, IBookMapper bookMapper) {
        m_libraryServiceHelper = libraryServiceHelper;
        m_memberMapper = memberMapper;
        m_bookMapper = bookMapper;
    }

    public Optional<MemberDTO> findMemberByName(String name)
    {
        return doWorkForService(() -> findMemberByNameCallback(name), "LibraryAppService.findMemberByName");
    }

    private Optional<MemberDTO> findMemberByNameCallback(String name)
    {
        var so = m_libraryServiceHelper.findMemberByName(name);

        return Optional.ofNullable(m_memberMapper.toMemberDTO(so.isEmpty() ? null : so.get()));
    }

    public Iterable<MemberDTO> findMemberByNameContains(String text)
    {
        return doWorkForService(() -> findMemberByNameContainsCallback(text), "LibraryAppService.findMemberByName");
    }

    private List<MemberDTO> findMemberByNameContainsCallback(String text)
    {
        return toList(m_libraryServiceHelper.findMemberByNameContains(text), m_memberMapper::toMemberDTO, false);
    }

    public List<MemberDTO> findAllMembers()
    {
        return doWorkForService(this::findAllMembersCallback, "LibraryAppService.findAllMembers");
    }

    private List<MemberDTO> findAllMembersCallback()
    {
        return toList(m_libraryServiceHelper.findAllMembers(), m_memberMapper::toMemberDTO, true);
    }

    public MembersDTO findMemberByNameContainsDetail(String text)
    {
        return doWorkForService(() -> findMemberByNameContainsCallbackDetail(text),
                "LibraryAppService.findMemberByNameContainsDetail");
    }

    private MembersDTO findMemberByNameContainsCallbackDetail(String text)
    {
        return m_memberMapper.toMembersDTO(StreamSupport.stream(m_libraryServiceHelper.findMemberByNameContains(text).spliterator(), false)
                .map(this::findMemberByNameContainsDetailMapCallback)
                .collect(Collectors.toList()));
    }
    private MemberDTO findMemberByNameContainsDetailMapCallback(Member member)
    {
        var dto = m_memberMapper.toMemberDTO(member);

        dto.setData(m_bookMapper.toBookDTOs(member.book));

        return dto;
    }

}
