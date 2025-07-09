package br.com.ulbra.author_book_api.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;


@Entity
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String titulo;
    private String editora;
    private int qtdPaginas;
    private int anoPublicacao;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    @JsonBackReference
    private Autor autor;

    public Livro(){}

    public Livro(Long id, String titulo, String editora, int qtdPaginas, int anoPublicacao, Autor autor) {
        this.id = id;
        this.titulo = titulo;
        this.editora = editora;
        this.qtdPaginas = qtdPaginas;
        this.anoPublicacao = anoPublicacao;
        this.autor = autor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public int getQtdPaginas() {
        return qtdPaginas;
    }

    public void setQtdPaginas(int qtdPaginas) {
        this.qtdPaginas = qtdPaginas;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }
}
