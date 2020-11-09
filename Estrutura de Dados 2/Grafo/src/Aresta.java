public class Aresta<T extends Comparable> {
    private int custo;
    private int risco;
    private int lentidao;

    private No<T> origem;
    private No<T> destino;

    private boolean visitado = false;

    public Aresta(No<T> origem, No<T> destino, int custo, int risco, int lentidao){
        this.custo = custo;
        this.risco = risco;
        this.lentidao = lentidao;
        this.origem = origem;
        this.destino = destino;
    }

    public int getCusto() {
        return custo;
    }

    public void setCusto(int custo) {
        this.custo = custo;
    }

    public int getRisco() {
        return risco;
    }

    public void setRisco(int risco) {
        this.risco = risco;
    }

    public int getLentidao() {
        return lentidao;
    }

    public void setLentidao(int lentidao) {
        this.lentidao = lentidao;
    }

    public No<T> getOrigem() {
        return origem;
    }

    public void setOrigem(No<T> origem) {
        this.origem = origem;
    }

    public No<T> getDestino() {
        return destino;
    }

    public void setDestino(No<T> destino) {
        this.destino = destino;
    }

    public boolean isVisitado() {
        return visitado;
    }

    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }

    public float mediaPeso(){
        return ((this.getCusto() + this.getLentidao() + this.getRisco()) / 3);
    }
}

