package estrutura_de_dados.excercicios;
import Estrutura_De_Dados.Pilha;
import java.util.Scanner;

/**
 *
 * @author John Keven
 */
public class Exercicios {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Pilha<Integer> pilha = new Pilha<Integer>(10);
        Pilha<Integer> pilhaPar = new Pilha<Integer>(10);
        Pilha<Integer> pilhaImpar = new Pilha<Integer>(10);
        //Empilha e Desempilha
        for (int i = 1; i < 10; i++) {
            System.out.println("Informe um numero:");
            int num = input.nextInt();
            if (num % 2 == 0) {
                System.out.println("Empilhando o numero " + num);
                pilha.Empilhar(num);
            } else {
                Integer desempilhado = pilha.Desempilhar();
                if (desempilhado == null) {
                    System.out.println("Pilha vazia!");
                } else {
                    System.out.println("Elemento desempilhado " + desempilhado);
                }
            }
        }
        System.out.println("Todos os valores lidos, desempilhando pilha inteira:");
        while (!pilha.estaVazia()) {
            Integer desempilhado = pilha.Desempilhar();
            System.out.println(desempilhado);
        }
        System.out.println("Todos valores desempilhados");
        //Pilha par ou ímpar
        for (int i = 0; i < 9; i++) {
            System.out.println("Informe um valor: ");
            int num = input.nextInt();
            if (num == 0) {
                Integer desempilhado = pilhaPar.Desempilhar();
                if (desempilhado == null) {
                    System.out.println("Pilha vazia");
                } else {
                    System.out.println("Desempilhando da pilha par: " + desempilhado);
                }
                desempilhado = pilhaImpar.Desempilhar();
                if (desempilhado == null) {
                    System.out.println("Pilha vazia");
                } else {
                    System.out.println("Desempilhando da pilha impar: " + desempilhado);
                }
            } else if (num % 2 == 0) {
                System.out.println("Empilhando na pilha par");
                pilhaPar.Empilhar(num);
            } else {
                System.out.println("Empilhando na pilha impar");
                pilhaImpar.Empilhar(num);
            }
        }
        System.out.println("---- Desempilhando pilha par ----");
        while (!pilhaPar.estaVazia()) {
            System.out.println("Desempilhando da pilha par: " + pilhaPar.Desempilhar());
        }

        System.out.println("---- Desempilhando pilha impar ----");
        while (!pilhaImpar.estaVazia()) {
            System.out.println("Desempilhando da pilha impar: " + pilhaImpar.Desempilhar());
        }
        //Pilha de Livros
        Pilha<Livro> pilhaLivro = new Pilha<Livro>(20);
        Livro livro1 = new Livro();
        Livro livro2 = new Livro();
        Livro livro3 = new Livro();
        livro1.setAutor("Stephen King");
        livro1.setNome("Livro 1");
        livro1.setAno(2000);
        livro1.setIsbn("Primeiro");

        livro2.setAutor("Edgar");
        livro2.setNome("Livro 2");
        livro2.setAno(1992);
        livro2.setIsbn("Segundo");

        livro3.setAutor("George Martin");
        livro3.setNome("Livro 3");
        livro3.setAno(2004);
        livro3.setIsbn("Terceiro");

        System.out.println("Pilha vazia?" + pilhaLivro.estaVazia());
        System.out.println("Empilhando: ");
        pilhaLivro.Empilhar(livro1);
        pilhaLivro.Empilhar(livro2);
        pilhaLivro.Empilhar(livro3);
        System.out.println(pilhaLivro.tamanho() + " livros foram empilhados");
        System.out.println(pilhaLivro);
        System.out.println("Espiando topo: " + pilhaLivro.topo());
        System.out.println("Desempilhando pilha:");
        while (!pilhaLivro.estaVazia()) {
            System.out.println("Desempilhando livro " + pilhaLivro.Desempilhar());
        }
        System.out.println("Todos os livros foram desempilhados " + pilhaLivro.estaVazia());
        
        //Palindromo
        imprimeResultado("ADA");
        imprimeResultado("ADCCAALA");
        imprimeResultado("ADDA");
        
        //Simbolos Balanceados 
        imprimeResultadoSimbolos("A+B");
        imprimeResultadoSimbolos("A+B}");
        imprimeResultadoSimbolos("[(A + B)]");
        imprimeResultadoSimbolos("[A+B]");
        imprimeResultadoSimbolos("<HTML>");
        
        //Decimal para binario
        imprimeResultadoDecimalBinario(10);
        imprimeResultadoDecimalBinario(2);
        
        //Torre de Hanoi
        Pilha<Integer> original = new Pilha<Integer>(10);;
        Pilha<Integer> destino = new Pilha<Integer>(10);
        Pilha<Integer> auxiliar = new Pilha<Integer>(10);

        original.Empilhar(3);
        original.Empilhar(2);
        original.Empilhar(1);
        torreDeHanoi(original.tamanho(), original, destino, auxiliar);
    }

    public static boolean testaPalindromo(String palavra) {
        Pilha<Character> pilha = new Pilha<Character>(10);
        for (int i = 0; i < palavra.length(); i++) {
            pilha.Empilhar(palavra.charAt(i));
        }
        String palavraInversa = "";
        while (!pilha.estaVazia()) {
            palavraInversa += pilha.Desempilhar();
        }
        if (palavraInversa.equalsIgnoreCase(palavra)) {
            return true;
        }
        return false;
    }

    public static void imprimeResultado(String palavra) {
        System.out.println(palavra + " é palindromo? " + testaPalindromo(palavra));
    }

    public static boolean verificaSimbolosBalanceados(String expressao) {
        boolean balanceado = true;
        Pilha<Character> pilha = new Pilha<Character>(10);
        int index = 0;
        char simbolo, topo;
        while (index < expressao.length()) {
            simbolo = expressao.charAt(index);
            if (ABRE.indexOf(simbolo) > -1) {
                pilha.Empilhar(simbolo);
            } else if (FECHA.indexOf(simbolo) > -1) {
                if (pilha.estaVazia()) {
                    return false;
                } else {
                    topo = pilha.Desempilhar();
                    if (ABRE.indexOf(topo) != FECHA.indexOf(simbolo)) {
                        return false;
                    }
                }
            }
            index++;
        }
        return true;
    }
    final static String ABRE = "([{<";
    final static String FECHA = ")]}>";

    public static void imprimeResultadoSimbolos(String expressao) {
        System.out.println(expressao + " esta balanceado? " + verificaSimbolosBalanceados(expressao));
    }

    public static String decimalBinario(int numero) {
        Pilha<Integer> pilha = new Pilha<Integer>(10);
        String numeroBinario = "";
        int resto;
        while (numero > 0) {
            resto = numero % 2;
            pilha.Empilhar(resto);
            numero /= 2; //numero = numero/2
        }
        while (!pilha.estaVazia()) {
            numeroBinario += pilha.Desempilhar();
        }

        return numeroBinario;
    }

    public static void imprimeResultadoDecimalBinario(int numero) {
        System.out.println(numero + " em binario e " + decimalBinario(numero));
    }

    public static void torreDeHanoi(int n, Pilha<Integer> original, Pilha<Integer> destino, Pilha<Integer> auxiliar) {
        if (n > 0) {
            torreDeHanoi(n - 1, original, auxiliar, destino);
            destino.Empilhar(original.Desempilhar());
            System.out.println("------------");
            System.out.println("Original: " + original);
            System.out.println("Original: " + destino);
            System.out.println("Original: " + auxiliar);
            torreDeHanoi(n - 1, auxiliar, destino, original);
        }
    }
}
