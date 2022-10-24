package org.senturk.app.service.library.dto;

public class BookDTO {
    private String m_name;
    private String m_author;

    public void setName(String name) {
        m_name = name;
    }

    public void setAuthor(String author) {
        m_author = author;
    }

    public String getName() {
        return m_name;
    }

    public String getAuthor() {
        return m_author;
    }
}
