package br.com.ulbra.author_book_api.dtos.response;

import java.time.LocalDate;
import java.util.List;

public class AutorResponseDTO {
    private String nome;
    private String paisOrigem;
    private LocalDate dataNascimento;
    private List<AutorLivroResponseDTO> livros; //O relacionamento diz que eu vou poder ter muitos livros, por isso lista

    public AutorResponseDTO(String nome, String paisOrigem, LocalDate dataNascimento, List<AutorLivroResponseDTO> livros) {
        this.nome = nome;
        this.paisOrigem = paisOrigem;
        this.dataNascimento = dataNascimento;
        this.livros = livros;
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

    public List<AutorLivroResponseDTO> getLivros() {
        return livros;
    }

    public void setLivros(List<AutorLivroResponseDTO> livros) {
        this.livros = livros;
    }
}
