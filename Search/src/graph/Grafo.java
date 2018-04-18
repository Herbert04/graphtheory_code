package graph;

import graph.interfaces.IGrafo;

import java.util.HashSet;
import java.util.Set;


public class Grafo implements IGrafo {

    private Set<Vertice> vertices = new HashSet<Vertice>();
    private Set<Aresta> arestas = new HashSet<Aresta>();
    private List<Vertice> visitados;

    public Grafo(Set<Vertice> vertices, Set<Aresta> arestas) {
        this.vertices = vertices;
        this.arestas = arestas;
    }
// Lista de vertices adjacentes
    @Override
    public Set<Vertice> getAdjacentes(Vertice v) {
        Set<Vertice> adjacentes = new HashSet<Vertice>();

        for(Aresta aresta: this.arestas) {
            if(aresta.getA() == v) {
                adjacentes.add(aresta.getB());
            }

            if(aresta.getB() == v) {
                adjacentes.add(aresta.getA());
            }
        }
        return adjacentes;

    }

    @Override
    public boolean ehConexo() {
        return false;
    }
  
    @Override
   public void buscaLargura(Vertice v) {
		Queue<Vertice> fila = new PriorityQueue<Vertice>();
		v.setVisitado(true);
		this.visitados.add(v);
		fila.add(v);
		System.out.println(visitados.toString());
		Vertice w;

		while (!fila.isEmpty()) {
			Set<Vertice> adjacentes = getAdjacentes(fila.peek());
			for (Vertice adj : adjacentes) {
				if (adj != null && adj.isVisitado() == false) {
					w = adj;

					buscaProfundidade(w);
					fila.add(w);

				}
			}
			fila.poll();
		}
	}
    
    @Override
    public void buscaProfundidade() {

    }


    @Override
    public String toString() {

        String retorno = "";

        for(Vertice v: vertices) {
            retorno += v.toString() + "[ ";

            Set<Vertice> adjacentes = this.getAdjacentes(v);

            for(Vertice adj: adjacentes) {
                retorno += adj.toString() + " ";
            }

            retorno += "]\n";


        }

        return retorno;
    }


}