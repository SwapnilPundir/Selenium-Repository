package JavaPractice;

import java.util.ArrayList;
import java.util.Collections;

public class CricketScoreSorting {

	public static void main(String[] args) {
		
		Player p1 = new Player("India", "Virat Kohli", 321);
		Player p2 = new Player("India", "Shikar Dhawan", 500);
		Player p3 = new Player("India", "Rohit Sharma", 523);
		Player p4 = new Player("India", "Vijay Shankar", 341);
		Player p5 = new Player("India", "KL Rahul", 217);
		
		ArrayList<Player> teamInd = new ArrayList<Player>();
		teamInd.add(p1);
		teamInd.add(p2);
		teamInd.add(p3);
		teamInd.add(p4);
		teamInd.add(p5);
		System.out.println("Before sorting : \n"+ teamInd);
		Collections.sort(teamInd, new scoreComparatorDesc());
		System.out.println("After sorting : \n"+ teamInd);

	}

}
