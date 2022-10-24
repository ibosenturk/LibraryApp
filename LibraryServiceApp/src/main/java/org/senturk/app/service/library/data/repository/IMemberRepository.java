package org.senturk.app.service.library.data.repository;

import org.senturk.app.service.library.data.entity.Member;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface IMemberRepository extends CrudRepository<Member, Integer> {

    //@Query("select m from Member m where m.name like :name")

    Optional<Member> findByName(String name);
    Iterable<Member> findByNameContains(String text);
    Iterable<Member> findByNameAndSurname(String name, String surname);
}
