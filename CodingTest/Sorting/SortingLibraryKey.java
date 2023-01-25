package Sorting;

import java.util.*;

class Fruit implements Comparable<Fruit> {
	
	private String name;
	private int score;
	
	public Fruit(String name, int score) {
		this.name = name;
		this.score = score;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getScore() {
		return this.score;
	}
	
	@Override
	public int compareTo(Fruit other) {
		if(this.score < other.score) {
			return -1;
		}
		return 1;
	}
}

public class SortingLibraryKey {

	public static void main(String[] args) {
		
		List<Fruit> fruits = new ArrayList<>();
		
		fruits.add(new Fruit("바나나", 2));
        fruits.add(new Fruit("사과", 5));
        fruits.add(new Fruit("당근", 3));
        
        Collections.sort(fruits);

        for (int i = 0; i < fruits.size(); i++) {
            System.out.print("(" + fruits.get(i).getName() + "," + fruits.get(i).getScore() + ") ");
        }
	}

}
