package maze;

import java.util.Iterator;
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
				exploredSet.add(v);
				if(m.canMoveLeft(n.nodeVertex)){
					temp = new Vertex(v.x-1,v.y);
					if(!checkIfInExploredSet(temp)){
						System.out.printf("Adding Vertex (%d,%d)\n",temp.x,temp.y);
						frontier.add(new Node(temp,n,Maze.Direction.left,n.pathCost+1));
					}
				}
				if(m.canMoveDown(v)){
					temp = new Vertex(v.x,v.y-1);
					if(!checkIfInExploredSet(temp)){
						System.out.printf("Adding Vertex (%d,%d)\n",temp.x,temp.y);
						frontier.add(new Node(temp,n,Maze.Direction.down,n.pathCost+1));
					}
				}
				if(m.canMoveRight(v)){
					temp = new Vertex(v.x+1,v.y);
					if(!checkIfInExploredSet(temp)){
						System.out.printf("Adding Vertex (%d,%d)\n",temp.x,temp.y);
						frontier.add(new Node(temp,n,Maze.Direction.right,n.pathCost+1));
					}
				}
				if(m.canMoveUp(v)){
					temp = new Vertex(v.x,v.y+1);
					if(!checkIfInExploredSet(temp)){
						System.out.printf("Adding Vertex (%d,%d)\n",temp.x,temp.y);
						frontier.add(new Node(temp,n,Maze.Direction.up,n.pathCost+1));
					}
				}
			}

		}
		int counter = 0;
		while(goalNode!=null){
			System.out.printf("x:%d y:%d\n", goalNode.nodeVertex.x,goalNode.nodeVertex.y);
			goalNode = goalNode.parent;
			counter++;
		}
		System.out.printf("Number of steps %d\n", counter);
	}
	
	private boolean checkIfInExploredSet(Vertex v){
		Iterator<Vertex> iter = exploredSet.iterator();
		while(iter.hasNext()){
			if(iter.next().equals(v)){
				return true;
			}
		}
		return false;
	}
	
}