package it.polito.tdp.food.model;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

public class Model {
	private Graph<Food, DefaultWeightedEdge> grafo;
	
	public void creaGrafo() {
		// inizializzo il grafo
		this.grafo = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
		
		// aggiungo i vertici
		
	}
}
