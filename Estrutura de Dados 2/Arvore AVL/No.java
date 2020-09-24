package Arvore_AVL;

/**
 *
 * @author John Keven
 */
public class No<T extends Comparable>
{
    public T valor;
    
    public No<T> noPai;
    public No<T> noEsquerdo;
    public No<T> noDireito;

    
    public No(T valor) 
    {
        this.valor = valor;
        this.noDireito = this.noEsquerdo = null;
    }
    
    public No(No<T> pai, T valor)
    {
        this(valor);
        
        this.noPai = pai;        
    }
}

