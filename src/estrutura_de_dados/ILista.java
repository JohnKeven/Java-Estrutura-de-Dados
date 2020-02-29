package Estrutura_De_Dados;

/**
 *
 * @author John Keven
 */
public interface ILista <T>{
    public void addNoInicio(T dado); 
    public void addNoFim(T dado); 
    public void addNaPosicao(int posicao, T dado); 
    public void addOrdenado(Comparable dado); 
    public Object removerNoInicio(); 
    public void removerNoFim(); 
    public void removerNaPosicao(int posicao); 
    public void removerObjeto(T dado); 
    public void listar(); 
    public void listardofim();
    public boolean contem(T objeto); 
    public Object pegar(int posicao); 
    public int tamanho(); 
}
