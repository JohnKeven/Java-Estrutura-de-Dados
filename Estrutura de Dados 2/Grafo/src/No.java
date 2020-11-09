import java.util.ArrayList;

public class No<T extends Comparable> implements Comparable<No<T>> {
    private T info;
    private float distancia = 0;
    private No<T> pai;

    private ArrayList<Aresta<T>> caminhos = new ArrayList<>();
    private ArrayList<No<T>> vizinhos = new ArrayList<>();

    private boolean visitado = false;

    public No(T info){
        this.info = info;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public float getDistancia() {
        return distancia;
    }

    public void setDistancia(float distancia) {
        this.distancia = distancia;
    }

    public No<T> getPai() {
        return pai;
    }

    public void setPai(No<T> pai) {
        this.pai = pai;
    }

    public ArrayList<Aresta<T>> getCaminhos() {
        return caminhos;
    }

    public void setCaminhos(Aresta<T> caminho){
        this.caminhos.add(caminho);

        if ((caminho.getOrigem().getInfo().equals(this.getInfo())) && (!this.isVizinho(caminho.getDestino()))){
            this.setVizinhos(caminho.getDestino());
        }
    }

    public void setVizinhos(No<T> vizinhos){
        this.vizinhos.add(vizinhos);
    }

    public ArrayList<No<T>> getVizinhos() {
        return vizinhos;
    }

    public boolean isVizinho(No<T> vizinho){
        int i;

        for(i = 0; i < this.vizinhos.size(); i++){
            if(this.vizinhos.get(i).getInfo().equals(vizinho.getInfo())){
                return true;
            }
        }
        return false;
    }

    public boolean isVisitado() {
        return visitado;
    }

    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }

    @Override
    public int compareTo(No<T> o) {
        if(this.getDistancia() < o.getDistancia()){
            return -1;
        } else if(this.getDistancia() == o.getDistancia()){
            return 0;
        }
        return 1;
    }
}
