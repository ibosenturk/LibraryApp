package org.senturk.app.service.library.data.repository;

import org.senturk.app.service.library.data.entity.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface IBookRepository extends CrudRepository<Book, Integer> {

}
