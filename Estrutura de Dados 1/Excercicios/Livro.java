package estrutura_de_dados.excercicios;

/**
 *
 * @author John Keven
 */
public class Livro {
    private String autor;
    private String nome;
    private String isbn;
    private int ano;

    public Livro(){

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "autor='" + autor + '\'' +
                ", nome='" + nome + '\'' +
                ", isbn='" + isbn + '\'' +
                ", ano=" + ano +
                '}';
    }
}
