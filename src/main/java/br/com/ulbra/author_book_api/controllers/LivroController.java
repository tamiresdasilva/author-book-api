package br.com.ulbra.author_book_api.controllers;

import br.com.ulbra.author_book_api.dtos.AutorDTO;
import br.com.ulbra.author_book_api.dtos.request.LivroRequestDTO;
import br.com.ulbra.author_book_api.dtos.response.LivroResponseDTO;
import br.com.ulbra.author_book_api.entities.Autor;
import br.com.ulbra.author_book_api.entities.Livro;
import br.com.ulbra.author_book_api.services.LivroService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/livros")
public class LivroController {
    private final LivroService livroService;

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

//    @GetMapping
//    public List<LivroResponseDTO> getAllLivros() {
//        return this.livroService.getAllLivros();
//    }

    @GetMapping
    public Page<LivroResponseDTO> listarTodosLivros(Pageable pageable) {
        return this.livroService.listarTodosLivros(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livro> consultarLivroPorId(@PathVariable Long id){
        return ResponseEntity.ok(this.livroService.consultarLivroPorId(id));
    }

    @PostMapping
    public ResponseEntity<Livro> cadastrarLivro(@RequestBody LivroRequestDTO livroRequest) {
        Livro livro = this.livroService.cadastrarLivro(livroRequest);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(livro.getId()).toUri();

        return ResponseEntity.created(uri).body(livro);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Livro> atualizarLivro(@RequestBody Livro livroRequest, @PathVariable Long id) {
        Livro livroAtualizado = this.livroService.atualizarLivro(livroRequest, id);
        return ResponseEntity.ok().body(livroAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarLivro(@PathVariable Long id) {
        livroService.deletarLivro(id);
        return ResponseEntity.noContent().build();
    }
}
