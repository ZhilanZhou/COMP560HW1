package maze;


import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	/**
	 * 
	 * @param args Enter name of maze file in command line arguments
	 */
	public static void main(String[] args) {
		Maze m = new Maze(args[0]);
		System.out.println("Start x = " + m.start.x);
		System.out.println("Start y = " + m.start.y);
		System.out.println("Goal x = " + m.goal.x);
		System.out.println("Goal y = " + m.goal.y);
		
	}
	
	private void BreadthFirstSearch(Maze m){
		ArrayList<Vertex> exploredSet = new ArrayList<Vertex>();
		//Queue<Vertex> frontier = new Queue<Vertex>();
	}
	
}
