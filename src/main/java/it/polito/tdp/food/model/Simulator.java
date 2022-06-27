package it.polito.tdp.food.model;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultWeightedEdge;

public class Simulator {
	// dati in ingresso
	private Graph<Food, DefaultWeightedEdge> grafo;
	private int K;
	private Food partenza;
	
	// dati in uscita
	private double tSimulazione;
	private int biciPreparati;
	
	// modello del mondo
	private List<List<Food>> cibiStazioni;
	
	// coda degli eventi
	Queue<Event> queue;
	
	public Simulator(Graph<Food, DefaultWeightedEdge> grafo) {
		// inizializzo il grafo
		this.grafo = grafo;
	}
	
	public void init(int K, Food partenza) {
		// inizializzo i dati in ingresso
		this.K = K;
		
		// inizializzo i dati in uscita
		this.tSimulazione = 0;
		this.biciPreparati = 0;
		
		// inizializzo il modello del mondo
		this.cibiStazioni = new ArrayList<>();
		List<Food> disponibili = this.trovaDisponibili(partenza);
		for(int i=0; i<K; i++) {
			if(disponibili.size() != 0) {
				for(Food f : disponibili) {
					this.cibiStazioni.get(i).add(f);
					disponibili.remove(f);
					break;
				}
			}
		}
		
		// inizializzo la coda e la carico con i primi eventi
		this.queue = new PriorityQueue<>();
		for(int i=0; i<K; i++) {
			
		}
	}
	
	public void run() {
		
	}
	
	private void processEvent(Event e) {
		
	}
	
	private List<Food> trovaDisponibili(Food corrente) {
		
	}
	
}
