package org.senturk.app.service.library.data.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "members")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    public int id;

    @Column(name = "member_name", nullable = false)
    public String name;

    @Column(name = "member_surname", nullable = false)
    public String surname;

    @Column(name = "member_phone_number", nullable = false)
    public String phone_number;

    @Column(name = "member_date_of_membership", nullable = false)
    public LocalDate dateOfMembership = LocalDate.now();

    @Column(name = "member_active", nullable = false)
    public boolean active;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public Set<Book> book;

}
