package maze;


import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String fileName = s.nextLine();
		Maze m = new Maze(fileName);
		
	}
	
	private void BreadthFirstSearch(Maze m){
		ArrayList<Vertex> exploredSet = new ArrayList<Vertex>();
		//Queue<Vertex> frontier = new Queue<Vertex>();
	}
	
}
