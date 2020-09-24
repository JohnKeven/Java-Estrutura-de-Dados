package Arvore_AVL;

/**
 *
 * @author John Keven
 */
import java.util.Arrays;
import java.util.Scanner;

public class Principal 
{
    public static void main(String[] args)
    {
        Scanner entrada = new Scanner(System.in);
        Arvore<Integer> avl = new Arvore<>();
        
        System.out.println("Testando a árvore, digite qualquer valor positivo," +
                "caso este já esteja na lista, ele será removido.");
        System.out.println("Para encerrar a execução, digite qualquer valor negativo");
        System.out.println("");
        
        while(true)
        {
            System.out.print("Digite um valor: ");
            int valor = entrada.nextInt();
            
            if(valor < 0)
            {
                System.out.println("Encerrando...");
                return;
            }
            
            try
            {
                avl.Inserir(valor);
            }
            catch(IllegalArgumentException ex)
            {
                avl.Remover(valor);
            }
            catch(Exception ex)
            {
                System.out.println(ex);
            }
            
            if(avl.numElementos != 0)
            {
                System.out.println(Arrays.toString(avl.ParaVetor()));
            }
            else
            {
                System.out.println("Árvore Vazia");
            }
            
            System.out.println("");
        }
    }
}

