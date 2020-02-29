package Estrutura_De_Dados;

/**
 *
 * @author John Keven
 */
public class SelectionSort {

    public void SelectionSort(int[] vetor) { //Total: O(n^2)
        for (int i = 0; i < vetor.length; i++) { //O(n)
            int menor = i;
            for (int j = i + 1; j < vetor.length; j++) { //O(n-1)
                if (vetor[j] < vetor[menor]) {
                    menor = j;
                }
            }
            trocar(vetor, i, menor);
        }
    }

    private void trocar(int[] vetor, int i, int menor) {
        int aux = vetor[i];
        vetor[i] = vetor[menor];
        vetor[menor] = aux;
    }
}
