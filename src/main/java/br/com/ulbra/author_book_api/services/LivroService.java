package br.com.ulbra.author_book_api.services;

import br.com.ulbra.author_book_api.dtos.request.LivroRequestDTO;
import br.com.ulbra.author_book_api.dtos.response.LivroAutorResponseDTO;
import br.com.ulbra.author_book_api.dtos.response.LivroResponseDTO;
import br.com.ulbra.author_book_api.entities.Autor;
import br.com.ulbra.author_book_api.entities.Livro;
import br.com.ulbra.author_book_api.repositories.LivroRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class LivroService {
    private LivroRepository livroRepository;
    private final AutorService autorService;

    public LivroService(LivroRepository livroRepository, AutorService autorService) {
        this.livroRepository = livroRepository;
        this.autorService = autorService;
    }

    public Livro consultarLivroPorId(Long id){
        return this.livroRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Livro com o ID " + id + " não foi encontrado."));
    }

    public Page<LivroResponseDTO> listarTodosLivros(Pageable pageable){
        return this.livroRepository.findAll(pageable).map(
                item -> new LivroResponseDTO(item.getTitulo(), item.getEditora(), item.getAnoPublicacao(), item.getQtdPaginas(), new LivroAutorResponseDTO(item.getAutor().getNome())));
    }

    public Livro cadastrarLivro(LivroRequestDTO livroRequest){
        Autor autor  = autorService.consultarAutorPorId(livroRequest.getAutorId());

        Livro livro =  new Livro();
        livro.setTitulo(livroRequest.getTitulo());
        livro.setEditora(livroRequest.getEditora());
        livro.setQtdPaginas(livroRequest.getQtdPaginas());
        livro.setAnoPublicacao(livroRequest.getAnoPublicacao());
        livro.setAutor(autor);

        return this.livroRepository.save(livro);
    }

    public Livro atualizarLivro(LivroRequestDTO livroRequest, Long id){
        Livro livro = this.livroRepository.getReferenceById(id);
        livro.setTitulo(livroRequest.getTitulo());
        livro.setEditora(livroRequest.getEditora());
        livro.setQtdPaginas(livroRequest.getQtdPaginas());
        livro.setAnoPublicacao(livroRequest.getAnoPublicacao());

        Autor autor = autorService.consultarAutorPorId(livroRequest.getAutorId());
        livro.setAutor(autor);

        return this.livroRepository.save(livro);
    }

    public void deletarLivro(Long id){
        if (!livroRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Livro com o id " + id + " não foi encontrado.");
        }
        livroRepository.deleteById(id);
    }
}
