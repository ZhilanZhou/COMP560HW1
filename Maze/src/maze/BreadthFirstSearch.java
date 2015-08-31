package maze;

import java.util.LinkedList;

public class BreadthFirstSearch {
	Vertex startSpace;
	Vertex goalSpace;
	LinkedList<Node> frontier;
	LinkedList<Vertex> explored;
	Maze m;
	
	public BreadthFirstSearch(Maze m, Vertex start, Vertex goal){
		startSpace = start;
		goalSpace = goal;
		frontier.add(new Node(start, null, null, 0));
	}

}
