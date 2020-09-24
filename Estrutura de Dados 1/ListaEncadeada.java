package Estrutura_De_Dados;

/**
 *
 * @author John Keven
 */
public class ListaEncadeada <T> implements ILista <T>{
        private No inicio, ultimo;
        private T dado;
        private int quantidade;

        public ListaEncadeada() {
            this.inicio = null;
            this.quantidade = 0;
        }

        //---- METODOS DE ADICIONAR ----//
        public void addNoFim(T dado) {
            No novo = new No();
            novo.setObjeto(dado);
            novo.setProximo(null);
            if (inicio == null) { //vai ser o primeiro no?
                inicio = novo;
            } else { //ja existe um no?
                No auxiliar;
                auxiliar = inicio;
                while (auxiliar.getProximo() != null) {
                    auxiliar = auxiliar.getProximo();
                }
                auxiliar.setProximo(novo);
            }
        } //Com Laço O(n), pior opcao
        public void addNoFim2(T dado) {
            No novo = new No();
            novo.setObjeto(dado);
            if (isNull()) {
                inicio = novo;
                ultimo = inicio;
                quantidade++;
            } else {
                ultimo.setProximo(novo);
                ultimo = novo;
                quantidade++;
            }
        } //Sem laço O(1) Ok
        public void addNoInicio(T dado) {
            No novo = new No();
            novo.setObjeto(dado);
            if (isNull()) {
                inicio = ultimo;
                ultimo = novo;
            } else {
                novo.setProximo(inicio);
                inicio = novo;
            }
            quantidade++;
        } //Sem laço O(1) Ok
        public void addNaPosicao(int posicao, T dado) {
            if (posicao == 0) {
                this.addNoInicio(dado);
            } else if (posicao == this.quantidade) {
                addNoFim2(dado);
            } else {
                No novo = new No();
                novo.setObjeto(dado);
                No anterior = pegarPosicao(posicao - 1);
                novo.setProximo(anterior.getProximo());
                anterior.setProximo(novo);
                quantidade++;
            }
        } //Sem laço O(1) Ok
        public void addOrdenado(Comparable elemento){
            No novo = new No();
            No atual = this.inicio;
            No anterior = null;
            novo.setObjeto(elemento);

            if(atual == null){
                novo.setProximo(null);
                this.inicio = novo;
                this.ultimo = inicio;
            } else {
                while (atual != null && elemento.compareTo(atual.getObjeto()) > 0){
                    anterior = atual;
                    atual = atual.getProximo();
                }
                novo.setProximo(atual);
                if(anterior == null){
                    this.inicio = novo;
                } else {
                    anterior.setProximo(novo);
                }
            }
            this.quantidade++;
        }

        //---- METODOS DE REMOVER ----//
        public Object removerNoInicio() {
            if (inicio == null) {
                System.out.println("Lista vazia");
                return null;
            }
            No auxiliar = inicio;
            Object dado = auxiliar.getObjeto();
            inicio = auxiliar.getProximo();
            quantidade--;
            return dado;
        } //Sem laço O(1) Ok
        @Override
        public void removerNoFim() {
        if (isNull()) {
            System.out.println("Lista vazia");
        } else if (this.quantidade == 1) {
            removerNoInicio();
        } else {
            No auxiliar = this.inicio;
            for (int i = 0; auxiliar.getProximo() != ultimo; i++) {
                auxiliar = auxiliar.getProximo();
            }
            ultimo = auxiliar;
            ultimo.setProximo(null);
            quantidade--;
        }
    } //Com laço O(n) Ok
        @Override
        public void removerNaPosicao(int posicao) {
            if (!contemPosicaoOcupada(posicao)) {
                throw new IllegalArgumentException("Posicao invalida");
            }
            if (posicao == 0) {
                removerNoInicio();
            } else if (posicao == this.quantidade) {
                removerNoFim();
            } else {
                No auxiliar = inicio;
                No temporario = auxiliar;
                for (int i = 0; i < quantidade; i++) {
                    if (i == posicao) {
                        temporario.setProximo(auxiliar.getProximo());
                        break;
                    }
                    temporario = auxiliar;
                    auxiliar = auxiliar.getProximo();
                }
                quantidade--;
            }
        } //Com laço O(n) Ok
        public void removerObjeto(T objeto) {
            if (isNull()) {
                System.out.println("Lista vazia");
            } else if (!contem(objeto)) {
                System.out.println("Objeto nao existe na lista");
            } else {
                No auxiliar = inicio;
                No temporario = null;
                for (int i = 0; i < tamanho(); i++) {
                    if (auxiliar.getObjeto().equals(objeto)) {
                        temporario.setProximo(auxiliar.getProximo());
                        break;
                    }
                    temporario = auxiliar;
                    auxiliar = auxiliar.getProximo();
                }
                quantidade--;
            }
        }

        //---- METODOS CONTEM ----//
        private boolean contemPosicaoOcupada(int posicao) {
            if (posicao >= 0 && posicao < this.quantidade) {
                return true;
            }
            return false;
        } //Ok
        public boolean contem(T objeto){
            No atual = this.inicio;
            while(atual != null){
                if(atual.getObjeto().equals(objeto)){
                    return true;
                }
                atual = atual.getProximo();
            }
            return false;
        } //Com laço O(n) Ok

        //---- METODOS PEGAR ----//
        private No pegarPosicao(int posicao){
            if(!this.contemPosicaoOcupada(posicao)){
                throw new IllegalArgumentException("Posicao invalida");
            }
            No atual = inicio;
            for (int i = 0; i < posicao; i++) {
                atual = atual.getProximo();
            }
            return atual;
        } //Pega a posicao anterior do Listas.No a ser deletado | Ok
        private No PegarPosicaoParaListarDoSFim(int posicao){
            No atual = inicio;
            for (int i = 0; i < posicao; i++) {
                atual = atual.getProximo();
            }
            return atual;
        }
        public Object pegar(int posicao){
            return pegarPosicao(posicao).getObjeto();
        } //Pega objeto da posicao informada | Ok

        //---- METODOS DE LISTAR ----//
        public void listar(){
            if(inicio == null){
                System.out.println("Lista vazia!");
            } else {
                No auxiliar = inicio;
                while(auxiliar != null){
                    System.out.println("Elemento: " + auxiliar.getObjeto());
                    auxiliar = auxiliar.getProximo();
                }
            }
        } // O(n) Ok
        public void listardofim(){
            if(inicio == null){
                System.out.println("Lista vazia!");
            } else {
                No auxiliar = PegarPosicaoParaListarDoSFim(quantidade-1);
                while(quantidade > 0){
                    System.out.println("Elemento: " + auxiliar.getObjeto());
                    quantidade--;
                    auxiliar = PegarPosicaoParaListarDoSFim(quantidade-1);
                }
            }
        }

        //---- TOSTRING ----//
        public String toString2(){
            if(isNull()) {
                return "Lista Simplismente Encadeada []";
            }
            String print = "Lista Simplismente Encadeada [ ";
            No aux;
            for (aux = inicio; aux != ultimo; aux = aux.getProximo()) {
                print = print + aux.getObjeto() + ", ";
            }
            return print + aux.getObjeto() + " ] - Tamanho = " + tamanho();
        } //Esse funciona

        //---- UTEIS ----//
        public boolean isNull(){
            return quantidade == 0;
        }
        public void limpar(){
            this.inicio = null;
            this.quantidade = 0;
        }
        public int tamanho(){
            return this.quantidade;
        }
}
