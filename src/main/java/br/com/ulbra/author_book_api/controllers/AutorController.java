package br.com.ulbra.author_book_api.controllers;

import br.com.ulbra.author_book_api.dtos.AutorDTO;
import br.com.ulbra.author_book_api.dtos.response.AutorResponseDTO;
import br.com.ulbra.author_book_api.entities.Autor;
import br.com.ulbra.author_book_api.services.AutorService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/autores")
public class AutorController {
    private final AutorService autorService;

    public AutorController(final AutorService autorService) {
        this.autorService = autorService;
    }

    @GetMapping
    public ResponseEntity<Page<AutorResponseDTO>> listarTodosAutores(@PageableDefault(sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        return ResponseEntity.ok(autorService.listarTodosAutores(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Autor> consultarAutorPorId(@PathVariable Long id) {
        return ResponseEntity.ok(autorService.consultarAutorPorId(id));
    }

    @PostMapping
    public ResponseEntity<Autor> criarAutor(@RequestBody Autor autor) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(autor.getId()).toUri();

        return ResponseEntity.created(uri).body(autorService.criarAutor(autor));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Autor> atualizarAutor(@RequestBody Autor autorRequest, @PathVariable Long id) {
        Autor autorAtualizado = this.autorService.atualizarAutor(autorRequest, id);
        return ResponseEntity.ok().body(autorAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAutor(@PathVariable Long id) {
        autorService.deletarAutor(id);
        return ResponseEntity.noContent().build();
    }


}
