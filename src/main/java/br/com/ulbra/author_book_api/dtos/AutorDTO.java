package br.com.ulbra.author_book_api.dtos;

import java.time.LocalDate;

public class AutorDTO {
    private Long id;
    private String nome;
    private String paisOrigem;
    private LocalDate dataNascimento;

    public AutorDTO(Long id, String nome, String paisOrigem, LocalDate dataNascimento) {
        this.id = id;
        this.nome = nome;
        this.paisOrigem = paisOrigem;
        this.dataNascimento = dataNascimento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPaisOrigem() {
        return paisOrigem;
    }

    public void setPaisOrigem(String paisOrigem) {
        this.paisOrigem = paisOrigem;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
