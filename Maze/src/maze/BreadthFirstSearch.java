package maze;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {
	Vertex startSpace;
	Vertex goalSpace;
	Queue<Node> frontier;
	LinkedList<Vertex> exploredSet;
	Maze m;
	
	public BreadthFirstSearch(Maze m, Vertex start, Vertex goal){
		startSpace = start;
		goalSpace = goal;
		frontier = new LinkedList<Node>();
		exploredSet = new LinkedList<Vertex>();
		frontier.add(new Node(start, null, null, 0));
		Vertex temp;
		Node goalNode = null;
		boolean goalFound = false;
		
		while(!(frontier.isEmpty()||goalFound)){
			Node n = frontier.poll();
			Vertex v = n.nodeVertex;
			if(m.isGoalVertex(v)){
				goalFound = true;
				goalNode = n;
			}
			else{
				if(m.canMoveLeft(n.nodeVertex)){
					temp = new Vertex(v.x-1,v.y);
					if(!exploredSet.contains(temp)){
						frontier.add(new Node(temp,n,Maze.Direction.left,n.pathCost+1));
					}
				}
				if(m.canMoveDown(v)){
					temp = new Vertex(v.x,v.y-1);
					if(!exploredSet.contains(temp)){
						frontier.add(new Node(temp,n,Maze.Direction.down,n.pathCost+1));
					}
				}
				if(m.canMoveRight(v)){
					temp = new Vertex(v.x+1,v.y);
					if(!exploredSet.contains(temp)){
						frontier.add(new Node(temp,n,Maze.Direction.right,n.pathCost+1));
					}
				}
				if(m.canMoveUp(v)){
					temp = new Vertex(v.x,v.y+1);
					if(!exploredSet.contains(temp)){
						frontier.add(new Node(temp,n,Maze.Direction.up,n.pathCost+1));
					}
				}
			}
			
			while(goalNode!=null){
				System.out.printf("x:%i y:%i/n", goalNode.nodeVertex.x,goalNode.nodeVertex.y);
				goalNode = goalNode.parent;
			}
		}
	}
	
	
}