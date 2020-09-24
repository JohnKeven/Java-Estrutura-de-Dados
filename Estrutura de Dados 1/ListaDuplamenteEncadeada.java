package Estrutura_De_Dados;

/**
 *
 * @author John Keven
 */
public class ListaDuplamenteEncadeada <T> {
    public No<T> primeiro;
    public No<T> ultimo;
    public int quantidade;

    public ListaDuplamenteEncadeada(){

    }

    public void addNoInicio(T objeto) {
        No<T> no = new No(objeto);
        if (estaVazia()) {
            primeiro = ultimo = no;
        } else {
            no.setProximo(primeiro);
            no.getProximo().setAnterior(no);
            primeiro = no;
        }
        quantidade++;
    }

    public void addNoFim(T objeto) {
        if(objeto == null) {
            System.out.println("O elemento inserido e nulo.");
        } else if(estaVazia()) {
            addNoInicio(objeto);
        }else {
            No<T> no = new No(objeto);
            ultimo.setProximo(no);
            no.setAnterior(ultimo);
            ultimo = no;
            quantidade++;
        }
    }

    public void addNaPosicao(int posicao,T objeto) {
        if(posicaoInvalida(posicao)) {
            System.out.println("Posição Invalida!");
        }else if(posicao == 0)
            addNoInicio(objeto);
        else if(posicao == tamanho()) {
            No no = new No(objeto);
            no.setAnterior(ultimo);
            no.getAnterior().setProximo(no);
            ultimo = no;
            quantidade++;
        }else{
            No<T> no = new No(objeto);
            No<T> aux = primeiro;
            for (int i = 0; i < tamanho(); i++) {
                if(i == posicao) {
                    no.setProximo(aux);
                    no.setAnterior(no.getProximo().getAnterior());
                    no.getProximo().getAnterior().setProximo(no);
                    aux.setAnterior(no);
                    break;
                }
                aux = aux.getProximo();
            }
            quantidade++;
        }
    }

    public void removerObjeto(T objeto) {
        if(estaVazia()) {
            System.out.println("A lista esta vazia.");
        }else if(primeiro.getObjeto().equals(objeto)) {
            removerNoInicio();
        }else if(ultimo.getObjeto().equals(objeto)) {
            removerNoFim();
        }else {
            No aux = primeiro;
            for(int i = 0; i < tamanho(); i++) {
                if(aux.getObjeto().equals(objeto)) {
                    aux.getAnterior().setProximo(aux.getProximo());
                    aux.getProximo().setAnterior(aux.getAnterior());
                    quantidade--;
                    break;
                }
                aux = aux.getProximo();
            }
        }
    }

    public void removerNaPosicao(int posicao) {
        if(estaVazia()) {
            System.out.println("A lista esta vazia.");
        }else if(posicaoInvalida(posicao)) {
            System.out.println("A posicao e invalida.");
        }else if(posicao == 0) {
            removerNoInicio();
        }else if(posicao == tamanho()-1) {
            removerNoFim();
        }else {
            No<T> aux = primeiro;
            for (int i = 0; i < tamanho(); i++) {
                if(i == posicao) {
                    aux.getAnterior().setProximo(aux.getProximo());
                    aux.getProximo().setAnterior(aux.getAnterior());
                    break;
                }
                aux = aux.getProximo();
            }
            quantidade--;
        }
    }

    private void removerNoInicio() {
        primeiro = primeiro.getProximo();
        primeiro.setAnterior(null);
        quantidade--;
    }

    private void removerNoFim() {
        ultimo = ultimo.getAnterior();
        ultimo.setProximo(null);
        quantidade--;
    }

    public void limpar(){
        primeiro = null;
        ultimo = null;
        quantidade = 0;
    }

    public T find(T objeto) {
        No<T> aux = null;
        if(estaVazia()) {
            return null;
        }else if(this.primeiro.getObjeto().equals(objeto)){
            return primeiro.getObjeto();
        }else if(ultimo.getObjeto().equals(objeto)){
            return ultimo.getObjeto();
        }else {
            aux = primeiro;
            for (int i = 0; i < tamanho(); i++) {
                if(aux.getObjeto().equals(objeto)) {
                    return aux.getObjeto();
                }
                aux = aux.getProximo();
            }
        }
        return null;
    }

    public T pegar(int index) {
        No<T> aux = primeiro;
        if(posicaoInvalida(index)) {
            return null;
        }else if(estaVazia()){
            return null;
        }else if(index == 0){
            return primeiro.getObjeto();
        }else if(index == tamanho()){
            return ultimo.getObjeto();
        }else {
            for(int i = 0; i < index; i++) {
                aux = aux.getProximo();
            }
            return aux.getObjeto();
        }
    }

    public boolean contem(T objeto){
        No<T> aux = null;
        if(estaVazia()) {
            return false;
        }else if(objeto == null){
            return false;
        }else if(ultimo.getObjeto().equals(objeto)){
            return true;
        }else {
            aux = primeiro;
            for(int i = 0; i < tamanho(); i++) {
                if(aux.getObjeto().equals(objeto)) {
                    return true;
                }
                aux = aux.getProximo();
            }
        }
        return false;
    }

    public int tamanho() {
        return quantidade;
    }

    public boolean posicaoInvalida(int posicao) {
        return posicao < 0 || posicao > tamanho();
    }

    public boolean estaVazia(){
        return quantidade == 0;
    }

    public String toString() {
        String print = "Lista Duplamente Encadeada [ ";
        if(this.estaVazia()) {
            return "Lista Duplamente Encadeada []";
        }else {
            No aux = this.primeiro;
            for (int i = 0; i < this.tamanho() - 1; i++) {
                print = print + aux.getObjeto() + ", ";
                aux = aux.getProximo();
            }
            print = print + aux.getObjeto() + " ] - Tamanho = " + this.tamanho();
        }
        return print;
    }
}
