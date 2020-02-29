package estrutura_de_dados.excercicios;

/**
 *
 * @author John Keven
 */
public class Paciente {
    private String nome;
    private String cpf;
    private int prioridade;
    private int idade;

    public Paciente(String nome, String cpf, int prioridade, int idade) {
        this.nome = nome;
        this.cpf = cpf;
        this.prioridade = prioridade;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", prioridade='" + prioridade + '\'' +
                ", idade=" + idade +
                '}';
    }

    public int compareTo(Paciente o) {
        if(this.prioridade > o.getPrioridade()){
            return 1;
        } else if (this.prioridade < o.getPrioridade()){
            return -1;
        }
        //obj1 > obj2 retorna > 0 (1)
        //obj1 < obj2 retorna < 0 (-1)
        //obj1 = obj2 retorna 0
        return 0;
    }
}
