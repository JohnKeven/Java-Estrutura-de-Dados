package Estrutura_De_Dados;

/**
 *
 * @author John Keven
 */
public class FilaComPrioridade <T> extends Fila <T> {
    private T[] elementos;
    private int tamanho;

    public FilaComPrioridade(int capacidade) {
        super(capacidade);
    }

    public boolean Enfileirar(T elemento){
        Comparable <T> chave = (Comparable<T>)elemento;
        int i;
        for (i = 0; i <= this.tamanho; i++) {
            if(chave.compareTo(this.elementos[i]) < 0){
                break;
            }
        }
        this.AdicionaNaPosicao(i, elemento);
        return true;
    }

    public boolean AdicionaNaPosicao(int posicao, T elemento){
        if(!(posicao >= 0 && posicao < tamanho)){
            throw new IllegalArgumentException("Posicao Invalida!");
        }
        //Movendo todos elementos
        if(posicao == 0){
            this.elementos[0] = elemento;
        }
        for (int i = this.tamanho-1; i > posicao; i--) {
            this.elementos[i+1] = this.elementos[i];
        }
        this.elementos[posicao] = elemento;
        this.tamanho++;
        return true;
    }
}
