package br.com.ulbra.author_book_api.services;

import br.com.ulbra.author_book_api.dtos.response.AutorLivroResponseDTO;
import br.com.ulbra.author_book_api.dtos.response.AutorResponseDTO;
import br.com.ulbra.author_book_api.entities.Autor;
import br.com.ulbra.author_book_api.repositories.AutorRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AutorService {
    private AutorRepository autorRepository;

    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    public Autor consultarAutorPorId(Long id){
        return this.autorRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Autor(a) com o ID " + id + " não foi encontrado(a)."));
    }

    public Page<AutorResponseDTO> listarTodosAutores(Pageable pageable){
        return this.autorRepository.findAll(pageable).map(item ->
                new AutorResponseDTO(
                        item.getNome(), item.getPaisOrigem(), item.getDataNascimento(), item.getLivros().stream().map(livros -> new AutorLivroResponseDTO(livros.getTitulo())).toList()));
    }


    public Autor criarAutor(Autor autor){
        return this.autorRepository.save(autor);
    }

    public Autor atualizarAutor(Autor autorRequest, Long id){
        Autor autor = this.autorRepository.getReferenceById(id);
        autor.setNome(autorRequest.getNome());
        autor.setPaisOrigem(autorRequest.getPaisOrigem());
        autor.setDataNascimento(autorRequest.getDataNascimento());

        return this.autorRepository.save(autor);
    }

    public void deletarAutor(Long id){
        if (!autorRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Autor(a) com o id " + id + " não foi encontrado(a).");
        }
        autorRepository.deleteById(id);
    }
}
