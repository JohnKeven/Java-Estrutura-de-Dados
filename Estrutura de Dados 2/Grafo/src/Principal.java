import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Grafo<String> map = new Grafo<String>();
        Scanner input = new Scanner(System.in);

        map.addNo("A");
        map.addNo("B");
        map.addNo("C");
        map.addNo("D");
        map.addNo("E");
        map.addNo("F");
        map.addNo("G");
        map.addNo("H");
        map.addNo("I");
        map.addNo("J");
        map.addNo("K");
        map.addNo("L");
        map.addNo("M");
        map.addNo("O");
        map.addNo("P");
        map.addNo("Q");
        map.addNo("R");
        map.addNo("S");
        map.addNo("T");
        map.addNo("U");

        //A
        map.addAresta("A", "B", 1, 1, 1);
        map.addAresta("A", "F", 3, 2, 1);
        //B
        map.addAresta("B", "A", 2, 3, 5);
        map.addAresta("B", "C", 1, 2, 1);
        //C
        map.addAresta("C", "B", 3, 2, 1);
        map.addAresta("C", "D", 3, 2, 1);
        //D
        map.addAresta("D", "C", 5, 2, 1);
        map.addAresta("D", "E", 1, 1, 1);
        //E
        map.addAresta("E", "J", 1, 1, 1);
        //F
        map.addAresta("F", "G", 1, 1, 1);
        //G
        map.addAresta("G", "F", 1, 1, 1);
        map.addAresta("G", "H", 1, 1, 1);
        map.addAresta("G", "L", 1, 7, 8);
        //H
        map.addAresta("H", "G", 1, 1, 1);
        map.addAresta("H", "I", 1, 1, 1);
        //I
        map.addAresta("I", "O", 3, 2, 1);
        //J
        map.addAresta("J", "I", 10, 8, 7);
        map.addAresta("J", "P", 1, 1, 1);
        //K
        map.addAresta("K", "L", 1, 1, 1);
        map.addAresta("K", "Q", 3, 2, 1);
        //L
        map.addAresta("L", "M", 1, 1, 1);
        map.addAresta("L", "R", 1, 1, 1);
        //M
        map.addAresta("M", "L", 1, 1, 1);
        map.addAresta("M", "O", 1, 1, 1);
        map.addAresta("M", "S", 10, 7, 3);
        //O
        map.addAresta("O", "M", 1, 1, 1);
        map.addAresta("O", "P", 1, 1, 1);
        //P
        map.addAresta("P", "O", 1, 1, 1);
        map.addAresta("P", "U", 1, 6, 1);
        //Q
        map.addAresta("Q", "K", 3, 2, 1);
        map.addAresta("Q", "R", 1, 1, 1);
        //R
        map.addAresta("R", "Q", 1, 1, 1);
        map.addAresta("R", "S", 3, 2, 1);
        //S
        map.addAresta("S", "R", 1, 6, 1);
        map.addAresta("S", "T", 1, 1, 1);
        //T
        map.addAresta("T", "S", 1, 1, 1);
        map.addAresta("T", "U", 1, 1, 1);
        //U
        map.addAresta("U", "T", 1, 1, 1);

        No<String> origem,destino;
        origem = map.acharNo("A");
        destino = map.acharNo("U");
        map.melhorCaminho(origem,destino);

        System.out.println("\n" + "## Média Caminho ##");
        System.out.println(map.mediaCaminho());
    }
}

