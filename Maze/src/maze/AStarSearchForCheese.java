package maze;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class AStarSearchForCheese {
	Vertex startSpace;
	Vertex goalSpace;
	Queue<Node> frontier;
	LinkedList<Vertex> exploredSet;
	LinkedList<Vertex> currentCheese;
	Maze m;
	int counter;
	
	public AStarSearchForCheese(Maze m, Vertex start, LinkedList<Vertex> cheese){
		startSpace = start;
		currentCheese = (LinkedList<Vertex>) cheese.clone();
		
		getGoal(startSpace, currentCheese);
		frontier = new PriorityQueue<Node>(10 , new AStarNodeComparator());
		frontier.add(new Node(start, null, null, 0, manhattanDistance(start)));
		exploredSet = new LinkedList<Vertex>();
		Vertex temp;
		Node goalNode = null;
		boolean goalFound = false;
		int expandedNodes = 0;
		
		while (goalSpace != null){
			while(!goalFound && !frontier.isEmpty()){
				Node n = frontier.poll();
				expandedNodes++;
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
							frontier.add(new Node(temp,n,Maze.Direction.up,n.pathCost+1,manhattanDistance(temp)));
						}
					}
					if(m.canMoveDown(v)){
						temp = new Vertex(v.x,v.y-1);
						if(!checkIfInExploredSet(temp)){
							System.out.printf("Adding Vertex (%d,%d)\n",temp.x,temp.y);
							frontier.add(new Node(temp,n,Maze.Direction.up,n.pathCost+1,manhattanDistance(temp)));
						}
					}
					if(m.canMoveRight(v)){
						temp = new Vertex(v.x+1,v.y);
						if(!checkIfInExploredSet(temp)){
							System.out.printf("Adding Vertex (%d,%d)\n",temp.x,temp.y);
							frontier.add(new Node(temp,n,Maze.Direction.up,n.pathCost+1,manhattanDistance(temp)));
						}
					}
					if(m.canMoveUp(v)){
						temp = new Vertex(v.x,v.y+1);
						if(!checkIfInExploredSet(temp)){
							System.out.printf("Adding Vertex (%d,%d)\n",temp.x,temp.y);
							frontier.add(new Node(temp,n,Maze.Direction.up,n.pathCost+1,manhattanDistance(temp)));
						}
					}
				}
			}
			while(goalNode!=null){
				System.out.printf("x:%d y:%d\n", goalNode.nodeVertex.x,goalNode.nodeVertex.y);
				goalNode = goalNode.parent;
				counter++;
			}
			System.out.printf("Number of steps %d\n", counter);
			System.out.printf("Number of nodes expanded %d\n", expandedNodes);
			
			startSpace = goalSpace;
			getGoal(startSpace, m.cheese);
		}
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
	
	private int manhattanDistance(Vertex v){
		return Math.abs(v.x-goalSpace.x)+Math.abs(v.y-goalSpace.y);
	}
	
	private int absDistance(Vertex v, Vertex w){
		return Math.abs(v.x-w.x)+Math.abs(v.y-w.y);
	}

	private void getGoal(Vertex start, LinkedList<Vertex> cheese){
		int tempDistance = -1;
		if (cheese.isEmpty()){
			goalSpace = null;
			return;
		}else{
			for (Vertex item : cheese){
				if (tempDistance == -1){
					tempDistance = absDistance(start, item);
					goalSpace = item;
				}
				if (checkIfInExploredSet(item)){
					cheese.remove(item);
					continue;
				}
				if (absDistance(start, item) < tempDistance){
					tempDistance = absDistance(start, item);
					goalSpace = item;
				}
			}
		}
		cheese.remove(goalSpace);
	}
}