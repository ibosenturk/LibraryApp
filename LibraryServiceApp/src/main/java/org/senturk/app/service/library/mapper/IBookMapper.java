package org.senturk.app.service.library.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import org.senturk.app.service.library.data.entity.Book;
import org.senturk.app.service.library.dto.BookDTO;

import java.util.Set;

@Mapper(implementationName = "BookMapperImpl", componentModel = "spring")
public interface IBookMapper {
    @Mapping(source = "name", target = "name")
    @Mapping(source = "author", target = "author")
    BookDTO toBookDTO(Book book);

    @Mapping(target = "name", source = "name")
    @Mapping(target = "author", source = "author")
    Book toBook(BookDTO bookDTO);

    Set<BookDTO> toBookDTOs(Set<Book> book);
}
