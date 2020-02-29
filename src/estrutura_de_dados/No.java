package Estrutura_De_Dados;

/**
 *
 * @author John Keven
 */
    public class No <T> {
    private No<T> proximo;
    private T objeto;
    private No<T> anterior;

    public No(T objeto) {
        this.proximo = null;
        this.objeto = objeto;
        this.anterior = null;
    }
    public No (){
        this.proximo = null;
    }
    
    public No getProximo() {
        return proximo;
    }

    public void setProximo(No proximo) {
        this.proximo = proximo;
    }

    public T getObjeto() {
        return objeto;
    }

    public void setObjeto(T objeto) {
        this.objeto = objeto;
    }

    public No getAnterior() {
        return anterior;
    }

    public void setAnterior(No anterior) {
        this.anterior = anterior;
    }
}

