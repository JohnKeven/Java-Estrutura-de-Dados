package Estrutura_De_Dados;
import java.util.Arrays;

/**
 *
 * @author John Keven
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] vetor = {1, 3, 5, 6, 3, 4, 7, 2, 13, 12};
        QuickSort(vetor, 0, vetor.length - 1);
        System.out.println(Arrays.toString(vetor));
    }

    public static void QuickSort(int[] vetor, int esquerdo, int direito) {
        if (esquerdo < direito) {
            int j = separar(vetor, esquerdo, direito);
            QuickSort(vetor, esquerdo, j - 1);
            QuickSort(vetor, j + 1, direito);
        }
    }

    public static int separar(int[] vetor, int esquerdo, int direito) {
        int i = esquerdo + 1;
        int j = direito;
        int pivo = vetor[esquerdo];
        while (i <= j) {
            if (vetor[i] <= pivo) {
                i++; //Para colocar decrescente ou crescente é essa
            } else if (vetor[j] > pivo) {
                j--; //e essa linha
            } else if (i <= j) {
                trocar(vetor, i, j);
                i++;
                j--;
            }
        }
        trocar(vetor, esquerdo, j);
        return j;
    }

    private static void trocar(int[] vetor, int i, int j) {
        int auxiliar = vetor[i];
        vetor[i] = vetor[j];
        vetor[j] = auxiliar;
    }
}
