package br.com.ulbra.author_book_api.dtos.request;

public class LivroRequestDTO {
    private String titulo;
    private String editora;
    private int qtdPaginas;
    private int anoPublicacao;
    private Long autorId;

    public LivroRequestDTO(String titulo, String editora, int qtdPaginas, int anoPublicacao, Long autorId) {
        this.titulo = titulo;
        this.editora = editora;
        this.qtdPaginas = qtdPaginas;
        this.anoPublicacao = anoPublicacao;
        this.autorId = autorId;
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

    public Long getAutorId() {
        return autorId;
    }

    public void setAutorId(Long autorId) {
        this.autorId = autorId;
    }
}
