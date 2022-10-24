package org.senturk.app.service.library.data.dal;

import org.senturk.app.service.library.data.entity.Member;
import org.senturk.app.service.library.data.repository.IBookRepository;
import org.senturk.app.service.library.data.repository.IMemberRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static org.csystem.util.data.DatabaseUtil.doWorkForRepository;
import static org.csystem.util.data.DatabaseUtil.doWorkForRepositoryRunnable;

@Component
public class LibraryServiceHelper {
    private final IMemberRepository m_memberRepository;
    private final IBookRepository m_bookRepository;


    public LibraryServiceHelper(IMemberRepository memberRepository, IBookRepository bookRepository)
    {
        m_memberRepository = memberRepository;
        m_bookRepository = bookRepository;
    }

    public Iterable<Member> findAllMembers() //Asenkron yapılmalı ,webflux
    {
        return doWorkForRepository(m_memberRepository::findAll, "LibraryServiceHelper.findAllMembers");
    }

    public Optional<Member> findMemberByName(String name)
    {
        return doWorkForRepository(() -> m_memberRepository.findByName(name), "LibraryServiceHelper.findMemberByName");
    }

    public Iterable<Member> findMemberByNameContains(String text)
    {
        return doWorkForRepository(() -> m_memberRepository.findByNameContains(text), "LibraryServiceHelper.findMemberByNameContains");

    }

    public Iterable<Member> findMemberByNameAndSurname(String name, String surname)
    {
        return doWorkForRepository(() -> m_memberRepository.findByNameAndSurname(name, surname), "LibraryServiceHelper.findByNameAndSurname");

    }
}
