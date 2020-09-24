package Arvore_Binaria;

/**
 *
 * @author John Keven
 */
public class No<T extends Comparable>
{
    public T valor;
    
    public No<T> noEsquerdo;
    public No<T> noDireito;

    
    public No(T valor) 
    {
        this.valor = valor;
        this.noDireito = this.noEsquerdo = null;
    }   
}
