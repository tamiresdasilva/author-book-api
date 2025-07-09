package br.com.ulbra.author_book_api.repositories;

import br.com.ulbra.author_book_api.entities.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
}
