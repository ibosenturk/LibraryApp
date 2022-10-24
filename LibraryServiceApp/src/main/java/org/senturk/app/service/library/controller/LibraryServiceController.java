package org.senturk.app.service.library.controller;

import org.senturk.app.service.library.dto.MemberDTO;
import org.senturk.app.service.library.dto.MemberInfoNotFoundDTO;
import org.senturk.app.service.library.dto.MembersDTO;
import org.senturk.app.service.library.service.LibraryAppService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping("api/members")
public class LibraryServiceController {
    private final LibraryAppService m_libraryAppService;

    public LibraryServiceController(LibraryAppService libraryAppService)
    {
        m_libraryAppService = libraryAppService;
    }

    @GetMapping("/all")
    public List<MemberDTO> findAllMembers()
    {
        return m_libraryAppService.findAllMembers();
    }

    @GetMapping("/name")
    public Object findMemberByName(String name)
    {
        var so = m_libraryAppService.findMemberByName(name);

        return so.isPresent() ? so : new MemberInfoNotFoundDTO(name, "Member not found");
    }

    @GetMapping("/contains")
    public Iterable<MemberDTO> findMembersByNameContains(String text)
    {
        return m_libraryAppService.findMemberByNameContains(text);
    }

    @GetMapping("/detail/contains")
    public MembersDTO findMembersByNameContainsDetail(String text)
    {
        return m_libraryAppService.findMemberByNameContainsDetail(text);
    }
}
