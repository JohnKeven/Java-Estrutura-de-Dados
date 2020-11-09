import java.util.*;

public class Grafo<T extends Comparable> {
    private ArrayList<Aresta<T>> arestas = new ArrayList<Aresta<T>>();
    private ArrayList<No<T>> nos = new ArrayList<No<T>>();
    private ArrayList<No<T>> melhorCaminho = new ArrayList<>();

    public int addNo(T nome) {
        int i = this.posicaoNo(nome);

        if (i == this.nos.size()) {
            this.nos.add(new No<T>(nome));
            return (this.nos.size() - 1);
        }
        return i;
    }

    public void addAresta(T origem, T destino, int custo, int lentidao, int risco) {
        int ori, dest, tamanho;

        ori = this.addNo(origem);
        dest = this.addNo(destino);

        Aresta a = new Aresta(this.nos.get(ori), this.nos.get(dest), custo, lentidao, risco);

        this.arestas.add(a);
        tamanho = this.arestas.size();

        this.nos.get(ori).setCaminhos(this.arestas.get(tamanho - 1));
        this.nos.get(dest).setCaminhos(this.arestas.get(tamanho - 1));

    }

    public int posicaoNo(T nome) {

        int i;

        for (i = 0; i < this.nos.size(); i++) {
            if (this.nos.get(i).getInfo().equals(nome)) {
                return i;
            }
        }
        return this.nos.size();
    }

    public No<T> acharNo(T info) {
        return this.nos.get(this.posicaoNo(info));
    }

    public Aresta<T> acharAresta(No<T> atual, No<T> vizinho) {
        for (int i = 0; i < this.arestas.size(); i++) {
            if (((this.arestas.get(i).getOrigem().getInfo().equals(atual.getInfo()))
                    && (this.arestas.get(i).getDestino().getInfo().equals(vizinho.getInfo())))) {
                return this.arestas.get(i);
            }
        }
        return null;
    }

    public void melhorCaminho(No<T> origem, No<T> destino) {

        ArrayList<No<T>> naoVisitados = new ArrayList<No<T>>();
        No<T> atual = null;
        No<T> vizinho;
        No<T> caminho;
        Aresta<T> ligacao = null;

        for (int i = 0; i < this.nos.size(); i++) {
            if (this.nos.get(i).equals(origem)) {
                this.nos.get(i).setDistancia(0);
            } else {
                this.nos.get(i).setDistancia(9999);
            }

            naoVisitados.add(this.nos.get(i));
        }

        Collections.<No<T>>sort(naoVisitados);

        while (!naoVisitados.isEmpty()){

            atual = naoVisitados.get(0);

            for (int i = 0; i < atual.getVizinhos().size(); i++) {

                vizinho = atual.getVizinhos().get(i);

                if(!vizinho.isVisitado()){

                    ligacao = acharAresta(atual, vizinho);

                    if((ligacao.mediaPeso() + atual.getDistancia()) < vizinho.getDistancia()){
                        vizinho.setDistancia(atual.getDistancia() + ligacao.mediaPeso());
                        vizinho.setPai(atual);

                        if(vizinho.equals(destino)){
                            melhorCaminho.clear();
                            caminho = vizinho;
                            melhorCaminho.add(vizinho);
                            while (caminho.getPai() != null){
                                melhorCaminho.add(caminho.getPai());
                                caminho = caminho.getPai();
                            }
                            Collections.<No<T>>sort(melhorCaminho);
                        }
                    }
                }
            }
            atual.setVisitado(true);
            naoVisitados.remove(atual);

            Collections.<No<T>>sort(naoVisitados);
        }

        System.out.println(" ### MELHOR CAMINHO SAINDO DE " + origem.getInfo() + " PARA " + destino.getInfo() + " ###");
        for (int i = 0; i < melhorCaminho.size(); i++) {
            System.out.print(melhorCaminho.get(i).getInfo() + "  ");
        }
    }

    public float mediaCaminho(){
        float somaCusto = 0;
        float somaLentidao = 0;
        float somaRisco = 0;

        Aresta<T> aresta;

        for (int i = 0; i < melhorCaminho.size() - 1; i++) {
            aresta = acharAresta(melhorCaminho.get(i), melhorCaminho.get(i+1));

            somaCusto += aresta.getCusto();
            somaLentidao += aresta.getLentidao();
            somaRisco += aresta.getRisco();
        }

        float mediaCusto = somaCusto / 3;
        float mediaLentidao = somaLentidao / 3;
        float mediaRisco = somaRisco / 3;

        return mediaCusto + mediaLentidao + mediaRisco;
    }
}

