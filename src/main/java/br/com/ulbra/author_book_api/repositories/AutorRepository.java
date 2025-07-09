package br.com.ulbra.author_book_api.repositories;

import br.com.ulbra.author_book_api.entities.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository  extends JpaRepository<Autor, Long> {
}
