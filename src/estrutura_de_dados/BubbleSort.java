package Estrutura_De_Dados;

/**
 *
 * @author John Keven
 */
public class BubbleSort {

    public static void BubbleSort(int[] vetor) {
        for (int ultimo = vetor.length - 1; ultimo > 0; ultimo--) { //O(n*(n-1)) ou O(n^2)
            for (int i = 0; i < ultimo; i++) {
                if (vetor[i] > vetor[i + 1]) {
                    trocar(vetor, i, i + 1);
                }
            }
        }
    }

    public static void trocar(int[] vetor, int i, int j) {
        int aux = vetor[i];
        vetor[i] = vetor[j];
        vetor[i] = aux;
    }
}
