package JavaPractice;

import java.util.Comparator;

public class Player implements Comparable<Player> {
	String country;
	String name;
	int score;
	public Player(String country, String name, int score)
	{
		this.country = country;
		this.name = name;
		this.score = score;
		
	}
	@Override
	public String toString() {
		return "Player [country=" + country + ", name=" + name + ", score=" + score + "] \n";
	}
	@Override
	public int compareTo(Player P) {
		return (P.score - this.score);
		//return (this.name.compareTo(P.name));
	}

}

class scoreComparatorDesc implements Comparator<Player> {

	@Override
	public int compare(Player p1, Player p2) {
		return (p2.score - p1.score);
	}
	
	
}