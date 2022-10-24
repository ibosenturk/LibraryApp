package org.senturk.app.service.library.dto;

public class MemberInfoNotFoundDTO {
    public String name;
    public String message;

    public MemberInfoNotFoundDTO(String name, String message)
    {
        this.name = name;
        this.message = message;
    }
}
