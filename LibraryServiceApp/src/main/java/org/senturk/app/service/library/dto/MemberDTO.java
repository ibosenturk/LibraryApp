package org.senturk.app.service.library.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDate;
import java.util.Set;

public class MemberDTO {
    private String m_name;
    private String m_surname;
    private LocalDate m_dateOfMembership;
    private boolean m_active;

    private Set<BookDTO> m_data;


    public String getName() {
        return m_name;
    }

    public String getSurname() {
        return m_surname;
    }

    public LocalDate getDateOfMembership() {
        return m_dateOfMembership;
    }

    public boolean isActive() {
        return m_active;
    }

    public void setName(String name) {
        m_name = name;
    }

    public void setSurname(String surname) {
        m_surname = surname;
    }

    @JsonFormat(pattern = "dd/MM/yyyy")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public void setDateOfMembership(LocalDate dateOfMembership) {
        m_dateOfMembership = dateOfMembership;
    }

    public void setActive(boolean active) {
        m_active = active;
    }
    public Set<BookDTO> getData()
    {
        return m_data;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public void setData(Set<BookDTO> data)
    {
        m_data = data;
    }
}






