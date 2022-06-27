package it.polito.tdp.food.model;

public class FoodAdiacente implements Comparable<FoodAdiacente>{
	private Food food;
	private Double calorie;
	public FoodAdiacente(Food food, double calorie) {
		super();
		this.food = food;
		this.calorie = calorie;
	}
	@Override
	public String toString() {
		return food.getDisplay_name() + ", " + calorie;
	}
	@Override
	public int compareTo(FoodAdiacente o) {
		// TODO Auto-generated method stub
		return o.calorie.compareTo(this.calorie);
	}
	
}
