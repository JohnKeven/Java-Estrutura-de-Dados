package Arvore_Binaria;

/**
 *
 * @author John Keven
 */
import java.util.ArrayList;

public class Arvore<T extends Comparable>
{  
    public No<T> raiz;
    private int numElementos = 0;
    
    /**
     * Verifica se a árvore está vazia
     */
    public boolean EstaVazia()
    {
        return this.raiz == null;
    }
    
    
    /**
     * Insere um valor na árvore
     */
    public void Inserir(T valor) throws Exception
    {
        No<T> novoNo = new No(valor);
        
        if(EstaVazia())
        {
            this.raiz = novoNo;
            this.numElementos++;
        }
        else
        {
            InserirDepois(this.raiz, novoNo);
            this.numElementos++;
        }
    }
    
    
    /**
     * Pesquisa se um determinado valor existe na árvore
     */
    public boolean Pesquisar(T valor)
    {
        if(EstaVazia())
        {
            return false;
        }
        else
        {
            No<T> noAtual = this.raiz;
            
            while(noAtual != null)
            {
                switch (noAtual.valor.compareTo(valor)) 
                {
                    //Caso o valor atual seja menor que o buscado...
                    case -1:
                        noAtual = noAtual.noDireito;
                        break;
                     
                    //Caso o valor atual seja maior que o buscado
                    case 1:                     
                        noAtual = noAtual.noEsquerdo;
                        break;
                    
                    //Caso Igual
                    default:
                        return true;
                }
            }
            
            return false;
        }
    }
      
    
    /**
     * Insere um novo valor depois de um nó existente na lista
     */
    private void InserirDepois(No<T> noAtual, No<T> noNovo) throws Exception
    {
        //Caso o novo nó seja menor que o atual
        if(noNovo.valor.compareTo(noAtual.valor) == -1)
        {
            if(noAtual.noEsquerdo == null)
            {
                noAtual.noEsquerdo = noNovo;
            }
            else
            {
                InserirDepois(noAtual.noEsquerdo, noNovo);
            }
        }
        
        //Caso o novo nó seja maior que o atual
        else if(noNovo.valor.compareTo(noAtual.valor) == 1)
        {
            if(noAtual.noDireito == null)
            {
                noAtual.noDireito = noNovo;
            }
            else
            {
                InserirDepois(noAtual.noDireito, noNovo);
            }
        }
        
        else
        {
            throw new Exception("Valor já existe");
        }
    }
    
    
    public Object[] ParaVetor()
    {
        ArrayList<T> retorno = new ArrayList<>();
        
        PercorreOrdenado(this.raiz, retorno);
        
        return retorno.toArray();
    }
    
    
    /**
     * Percorre a arvore de forma ordenada (E N D) Ex.: [1,3,4,5,6,7]
     */
    private void PercorreOrdenado(No<T> noAtual, ArrayList<T> lista)
    {
        if(noAtual.noEsquerdo != null)
        {
            PercorreOrdenado(noAtual.noEsquerdo, lista);
        }
        
        lista.add(noAtual.valor);
        
        if(noAtual.noDireito != null)
        {
            PercorreOrdenado(noAtual.noDireito, lista);
        }
    }
    
    
    /**
     * Percorre a árvore em Pré Ordem (N E D) Ex.: [5,3,1,4,7,6]
     */
    private void PercorrePreOrdenado(No<T> noAtual, ArrayList<T> lista)
    {
        if(noAtual != null)
        {
            lista.add(noAtual.valor);         
        }
        else
        {
            return;
        }
       
        PercorrePreOrdenado(noAtual.noEsquerdo, lista);
        PercorrePreOrdenado(noAtual.noDireito, lista);
    }
    
    
    /**
     * Percorre a árvore em Pós Ordem (E D N) Ex.: [1,4,3,5,6,7]
     */
    private void PercorrePosOrdenado(No<T> noAtual, ArrayList<T> lista)
    {
        if(noAtual.noEsquerdo != null)
        {
            PercorrePosOrdenado(noAtual.noEsquerdo, lista);
        }
        
        if(noAtual.noDireito != null)
        {
            PercorrePosOrdenado(noAtual.noDireito, lista);
        }
        
        lista.add(noAtual.valor);
    }
    
    
    /**
     * Verifica se determinado nó está balanceado
     */
    public int ChecarBalanceamento(No<T> noAtual)
    {
        int pontuacao = 0;
                
        if(noAtual.noEsquerdo != null)
        {
            pontuacao++;
            pontuacao += ChecarBalanceamento(noAtual.noEsquerdo);
        }
        
        if(noAtual.noDireito != null)
        {
            pontuacao--;
            pontuacao += ChecarBalanceamento(noAtual.noDireito);
        }
        
        return pontuacao;
    }
}

