package br.com.ulbra.author_book_api.dtos.response;

public class LivroAutorResponseDTO {
    private String nome;

    public LivroAutorResponseDTO() {}

    public LivroAutorResponseDTO(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
