package Arvore_AVL;

/**
 *
 * @author John Keven
 */
import java.util.ArrayList;

public class Arvore<T extends Comparable>
{  
    public No<T> raiz;
    protected int numElementos = 0;
    
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
        if(EstaVazia())
        {
            this.raiz = new No(valor);
            this.numElementos++;
        }
        else
        {
            InserirDepois(this.raiz, valor);
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
    
    
    public No<T> PesquisarNo(T valor)
    {
        if(EstaVazia())
        {
            return null;
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
                        return noAtual;
                }
            }
            
            return null;
        }
    }
      
    
    /**
     * Insere um novo valor depois de um nó existente na lista
     */
    private void InserirDepois(No<T> noAtual, T valor)
    {
        //Caso o novo nó seja menor que o atual
        if(valor.compareTo(noAtual.valor) == -1)
        {
            if(noAtual.noEsquerdo == null)
            {
                noAtual.noEsquerdo = new No(noAtual, valor);
                
                ChecarBalanceamento(this.raiz);
            }
            else
            {
                InserirDepois(noAtual.noEsquerdo, valor);
            }
        }
        
        //Caso o novo nó seja maior que o atual
        else if(valor.compareTo(noAtual.valor) == 1)
        {
            if(noAtual.noDireito == null)
            {
                noAtual.noDireito = new No(noAtual, valor);
                
                ChecarBalanceamento(this.raiz);
            }
            else
            {
                InserirDepois(noAtual.noDireito, valor);
            }
        }
        
        else
        {
            throw new IllegalArgumentException("Valor já existe");
        }
    }
    
    /**
     * Insere um novo nó depois de um nó existente na lista
     */
    protected void InserirDepois(No<T> noAtual, No<T> noNovo)
    {
        //Caso o novo nó seja menor que o atual
        if(noNovo.valor.compareTo(noAtual.valor) == -1)
        {
            if(noAtual.noEsquerdo == null)
            {
                noAtual.noEsquerdo = noNovo;
                noNovo.noPai = noAtual;
                
                ChecarBalanceamento(this.raiz);
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
                noNovo.noPai = noAtual;
                
                ChecarBalanceamento(this.raiz);
            }
            else
            {
                InserirDepois(noAtual.noDireito, noNovo);
            }
        }
        
        else
        {
            throw new IllegalArgumentException("Valor já existe");
        }
    }
    
    
    public void Remover(T valor)
    {
        No<T> noExclusao = PesquisarNo(valor);
        
        if(noExclusao != null)
        {
            if(noExclusao.noDireito != null)
            {
                noExclusao.noDireito.noPai = noExclusao.noPai;
            }
            
            if(noExclusao.noPai == null)
            {
                if(noExclusao.noDireito != null)
                {
                    this.raiz = noExclusao.noDireito;
                }
                else
                {
                    this.raiz = noExclusao.noEsquerdo;
                    this.numElementos--;
                    return;
                }            
            }
            else
            {
                //Checa qual direção que o pai está referênciando o alvo a ser removido
                if(noExclusao.noPai.noDireito != null && noExclusao.noPai.noDireito.equals(noExclusao))
                {                
                    noExclusao.noPai.noDireito = noExclusao.noDireito;
                }
                else
                {
                    noExclusao.noPai.noEsquerdo = noExclusao.noDireito;
                }
            }
            
            if(noExclusao.noEsquerdo != null)
            {
                InserirDepois(this.raiz, noExclusao.noEsquerdo);
            }
            
            this.numElementos--;
        }
    } //FIM FUNÇÃO
    
    
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
        
        
        if( Rotacionar(noAtual, pontuacao) )
        {
            return ChecarBalanceamento(noAtual);
        }
        else
        {
            return pontuacao;
        }     
    }
    
    
    private boolean Rotacionar(No<T> desbalanco, int pontuacao)
    {
        if(Math.abs(pontuacao) < 2)
        {
            return false;
        }
        
        //Desequilibrio no nó esquerdo
        if(pontuacao > 0)
        {
            if(desbalanco.noEsquerdo.noEsquerdo == null)
            {
                GirarDuploDireita(desbalanco);
            }
            else
            {
                GirarDireita(desbalanco);
            }
            
                       
        }
        
        //Desequilibrio no nó direito
        else
        {
            if(desbalanco.noDireito.noDireito == null)
            {
                GirarDuploEsquerda(desbalanco);
            }
            else
            {
                GirarEsquerda(desbalanco);
            }         
        }
        
        return true;
    }
    
    
    protected void GirarDireita(No<T> alvo)
    {
        No<T> rotacao = alvo.noEsquerdo;
        
        if(alvo.noPai == null)
        {
            rotacao.noPai = null;
            this.raiz = rotacao;
        }
        else
        {
            //Checa qual direção que o pai está referênciando o alvo a ser balanceado
            if(alvo.noPai.noDireito != null && alvo.noPai.noDireito.equals(alvo))
            {
                rotacao.noPai = alvo.noPai;
                alvo.noPai.noDireito = rotacao;
            }
            else
            {
                rotacao.noPai = alvo.noPai;
                alvo.noPai.noEsquerdo = rotacao;
            }
        }
        

        alvo.noEsquerdo = rotacao.noDireito;
        
        if(alvo.noEsquerdo != null)
        {
            alvo.noEsquerdo.noPai = alvo;
        }
        
        alvo.noPai = rotacao;
        rotacao.noDireito = alvo;
        
    }
    
    
    protected void GirarEsquerda(No<T> alvo)
    {
        No<T> rotacao = alvo.noDireito;
        
        if(alvo.noPai == null)
        {
            rotacao.noPai = null;
            this.raiz = rotacao;
        }
        else
        {
            //Checa qual direção que o pai está referênciando o alvo a ser balanceado
            if(alvo.noPai.noDireito != null && alvo.noPai.noDireito.equals(alvo))
            {
                rotacao.noPai = alvo.noPai;
                alvo.noPai.noDireito = rotacao;
            }
            else
            {
                rotacao.noPai = alvo.noPai;
                alvo.noPai.noEsquerdo = rotacao;
            }
        }
        

        alvo.noDireito = rotacao.noEsquerdo;

        if(alvo.noDireito != null)
        {
            alvo.noDireito.noPai = alvo;
        }
        
               
        alvo.noPai = rotacao;
        rotacao.noEsquerdo = alvo;
    }
    
    
    protected void GirarDuploDireita(No<T> alvo)
    {
        GirarEsquerda(alvo.noEsquerdo);
        
        GirarDireita(alvo);
    }
    
    
    protected void GirarDuploEsquerda(No<T> alvo)
    {
        GirarDireita(alvo.noDireito);
        
        GirarEsquerda(alvo);
    }
}

