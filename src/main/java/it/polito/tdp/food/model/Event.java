package it.polito.tdp.food.model;

public class Event implements Comparable<Event> {
	public enum EventType{
		INIZIA_PREPARAZIONE,
		FINISCE_PREPARAZIONE
	}
	
	private Double time;
	private EventType type;
	private int stazione;
	private Food cibo;
	public Event(double time, EventType type, int stazione, Food cibo) {
		super();
		this.time = time;
		this.type = type;
		this.stazione = stazione;
		this.cibo = cibo;
	}
	@Override
	public int compareTo(Event o) {
		// TODO Auto-generated method stub
		return this.time.compareTo(o.time);
	}
	
	
}
