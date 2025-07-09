package br.com.ulbra.author_book_api.dtos.response;

public class LivroResponseDTO {
    private String titulo;
    private String editora;
    private int qtdPaginas;
    private int anoPublicacao;
    private LivroAutorResponseDTO autor;

    public LivroResponseDTO() {}

    public LivroResponseDTO(String titulo, String editora, int qtdPaginas, int anoPublicacao, LivroAutorResponseDTO autor) {
        this.titulo = titulo;
        this.editora = editora;
        this.qtdPaginas = qtdPaginas;
        this.anoPublicacao = anoPublicacao;
        this.autor = autor;
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
}
