package Estrutura_De_Dados;
import java.lang.reflect.Array;

/**
 *
 * @author John Keven
 */
public class ListaSequencial <T> {
        private T[] elementos;
        private int tamanho;

        public ListaSequencial(int capacidade){
            this.elementos = (T[])new Object[capacidade];
            this.tamanho = 0;
        }

        public ListaSequencial(int capacidade,Class<T> tipoClasse){
            this.elementos = (T[]) Array.newInstance(tipoClasse, capacidade);
            this.tamanho = 0;
        }
        //---------------- ADICIONAR ---------------//
        //opcao de add 1
        public void adicionar1(T elemento){
            this.AumentaCapacidade();
            for (int i = 0; i < this.elementos.length; i++){
                if(this.elementos[i] == null){
                    this.elementos[i] = elemento;
                    break;
                }
            }
        }
        //opcao de add 2
        public void adicionar2(T elemento) throws Exception {
            this.AumentaCapacidade();
            if (this.tamanho < this.elementos.length) {
                this.elementos[this.tamanho] = elemento;
                this.tamanho++;
            } else {
                throw new Exception("Vetor preenchido!");
            }
        }
        //opcao de add 3 (Melhor opcao)
        public boolean adicionar3(T elemento){
            this.AumentaCapacidade();
            if(this.tamanho < this.elementos.length){
                this.elementos[this.tamanho] = elemento;
                tamanho++;
                return false;
            }
            return false;
        }

        //-------------------BUSCA------------------//
        public T Busca(int posicao){
            if(!(posicao >= 0 && posicao < tamanho)){
                throw new IllegalArgumentException("Posicao Invalida!");
            }
            return this.elementos[posicao];
        }

        //----------VERIFICAR EXISTENCIA------------//
        // retorna booleando
        public boolean Contem(T elemento){
     /*   int posicao = Existe2(elemento);
        if(posicao > -1){
            return true;        DETALHANDO O FIZ ABAIXO NO RETORNO
        }
        return false; */
            return Existe(elemento) > -1;
        }
        // retorna apenas o index

        public int Existe(T elemento){
            //busca sequencial//
            for (int i = 0; i < this.tamanho; i++) {
                if(this.elementos[i].equals(elemento)){
                    return i;
                }
            }
            return -1;
        }

        //---COLOCAR ELEMENTO EM QUALQUER POSICAO---//
        public boolean AdicionaNaPosicao(int posicao, T elemento){
            if(!(posicao >= 0 && posicao < tamanho)){
                throw new IllegalArgumentException("Posicao Invalida!");
            }
            //Movendo todos elementos
            for (int i = this.tamanho-1; i >= posicao; i--) {
                this.elementos[i+1] = this.elementos[i];
            }
            this.elementos[posicao] = elemento;
            this.tamanho++;
            return true;
        }

        //----ADICIONAR MAIS CAPACIDADE NO VETOR----//
        private void AumentaCapacidade(){
            if(this.tamanho == this.elementos.length){
                T[] ElementosNovos = (T[])new Object[this.elementos.length*2];
                for (int i = 0; i < this.elementos.length; i++) {
                    ElementosNovos[i] = this.elementos[i];
                }
                this.elementos = ElementosNovos;
            }
        }

        //------------------REMOVER----------------//
        public void Remover(int posicao){
            if(!(posicao >= 0 && posicao < tamanho)){
                throw new IllegalArgumentException("Posicao Invalida!");
            }
            for (int i = posicao; i < this.tamanho-1; i++) {
                this.elementos[i] = this.elementos[i+1];
            }
            this.tamanho--;
        }

        public void Remover(T elemento){ // removendo utilizando o mesmo tipo de elemento como parametro
            int posicao = this.Existe(elemento);
            if(posicao > -1){
                this.Remover(posicao);
            }
        }

        //------RETORNAR ULTIMO INDEX QUE O ELEMENTO APARECE------//
        public int RetornaUltimoIndex(T elemento){
            for (int i = this.tamanho-1; i >= 0; i--) {
                if(this.elementos[i].equals(elemento)){
                    return i;
                }
            }
            return -1;
        }

        //------METODO BUSCA MELHORADO, PARA OBTER ELEMENTO DA POSICAO "X"------//
        public T Obtem(int posicao){
            return this.Busca(posicao);
        }

        //------DELETANDO TODOS ELEMENTOS-----//
        public void limpar(){
            //opcao 1
            this.elementos = (T[]) new Object[this.elementos.length];
            //opcao 2
            this.tamanho = 0;
            //opcao 3
            for (int i = 0; i < this.tamanho; i++) {
                this.elementos[i] = null;
            }
            this.tamanho = 0;
        }

        public int getTamanho(){
            return tamanho;
        }
        @Override
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
