package it.polito.tdp.food.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.food.db.FoodDao;

public class Model {
	private Graph<Food, DefaultWeightedEdge> grafo;
	private FoodDao dao;
	private Map<Integer, Food> idMap;
	
	public Model() {
		// inizializzo il dao
		this.dao = new FoodDao();
		
		// inizializzo la idMap e la riempio
		this.idMap = new HashMap<>();
		this.dao.listAllFoods(idMap);
	}
	
	public void creaGrafo(int nPorzioni) {
		// inizializzo il grafo
		this.grafo = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
		
		// aggiungo i vertici
		Graphs.addAllVertices(this.grafo, this.dao.getVertici(nPorzioni));
		
		// aggiungo gli archi
		for(Adiacenza a : this.dao.getAdiacenze(nPorzioni)) {
			Graphs.addEdge(this.grafo, this.idMap.get(a.getF1()), this.idMap.get(a.getF2()), 
					a.getPeso());
			
		}
		
		// console
		System.out.printf("# vertici: %d\n", this.grafo.vertexSet().size());
		System.out.printf("# archi: %d\n", this.grafo.edgeSet().size());
	}
	
	public List<FoodAdiacente> getAdiacenti(Food food) {
		List<FoodAdiacente> adiacenti = new ArrayList<>();
		List<FoodAdiacente> topAdiacenti = new ArrayList<>();
		System.out.println("Grado del vertice selezionato: " + this.grafo.degreeOf(food));
		for(Food f1 : Graphs.neighborListOf(this.grafo, food)) {
			adiacenti.add(new FoodAdiacente(f1, this.grafo.getEdgeWeight(this.grafo.getEdge(f1, 
					food))));
		}
		Collections.sort(adiacenti);
		
		for(FoodAdiacente f : adiacenti) {
			if(topAdiacenti.size() < 5) {
				topAdiacenti.add(f);
			}
		}
		return topAdiacenti;
	}
	
	public int nVertici() {
		return this.grafo.vertexSet().size();
	}
	
	public int nArchi() {
		return this.grafo.edgeSet().size();
	}
	
	public boolean isGrafoCreato() {
		return this.grafo!=null;
}
	public List<Food> getVertici() {
		return new ArrayList<>(this.grafo.vertexSet());
	}
}
