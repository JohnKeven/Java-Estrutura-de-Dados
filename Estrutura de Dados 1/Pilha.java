package Estrutura_De_Dados;

/**
 *
 * @author John Keven
 */
public class Pilha <T> {
    private T[] elementos;
    private int tamanho;
    public Pilha(int capacidade){
        elementos = (T[]) new Object[capacidade];
        tamanho = 0;
    }

    public boolean Empilhar(T elemento){
        this.AumentaCapacidade();
        if(this.tamanho < this.elementos.length){
            this.elementos[this.tamanho] = elemento;
            tamanho++;
            return false;
        }
        return false;
    }
    public T Desempilhar(){
        if(this.estaVazia()){
            return null;
        }
        T elemento =  this.elementos[tamanho-1];
        tamanho--;
        return elemento;
    }
    public T topo(){
        if(this.estaVazia()){
            return null;
        }
        return this.elementos[tamanho-1];
    }
    private void AumentaCapacidade(){
        if(this.tamanho == this.elementos.length){
            T[] ElementosNovos = (T[])new Object[this.elementos.length*2];
            for (int i = 0; i < this.elementos.length; i++) {
                ElementosNovos[i] = this.elementos[i];
            }
            this.elementos = ElementosNovos;
        }
    }
    public int tamanho(){
        return this.tamanho;
    }
    public boolean estaVazia(){
        return this.tamanho == 0;
    }
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("[");
        for (int i = 0; i < this.tamanho-1 ; i++) {
            s.append(this.elementos[i]);
            s.append(", ");
        }
        if(this.tamanho>0){
            s.append(this.elementos[this.tamanho-1]);
        }
        s.append("]");
        return s.toString();
    }
}
