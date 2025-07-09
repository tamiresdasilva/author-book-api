package br.com.ulbra.author_book_api.dtos.response;

public class AutorLivroResponseDTO {
    private String titulo;

    public AutorLivroResponseDTO() {}

    public AutorLivroResponseDTO(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
