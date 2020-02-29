package Estrutura_De_Dados;
import java.util.Arrays;

/**
 *
 * @author John Keven
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] vetor = {4, 6, 7, 3, 5, 1, 2, 8};
        int[] w = new int[vetor.length];
        MergeSort(vetor, w, 0, vetor.length - 1);
        System.out.println(Arrays.toString(vetor));
    }

    public static void MergeSort(int[] vetor, int[] w, int inicio, int fim) {
        if (inicio < fim) {
            int meio = (inicio + fim) / 2;
            MergeSort(vetor, w, inicio, meio);
            MergeSort(vetor, w, meio + 1, fim);
            Merge(vetor, w, inicio, meio, fim);
        }
    }

    public static void Merge(int[] vetor, int[] w, int inicio, int meio, int fim) {
        for (int k = inicio; k <= fim; k++) {
            w[k] = vetor[k];
        }

        int i = inicio;
        int j = meio + 1;
        for (int k = inicio; k <= fim; k++) {
            if (i > meio) {
                vetor[k] = w[j++];
            } else if (j > fim) {
                vetor[k] = w[i++];
            } else if (w[i] < w[j]) {
                vetor[k] = w[i++]; // essa linha define crescente ou decrescente
            } else {
                vetor[k] = w[j++];
            }
        }
    }
}
