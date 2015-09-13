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
	LinkedList<Vertex> visitedSet;		//a list of vertex that are visited
	LinkedList<Vertex> currentCheese;	//a list of cheese vertex
	Maze m;
	
	
	public AStarSearchForCheese(Maze m, Vertex start, LinkedList<Vertex> cheese){
		startSpace = start;
		currentCheese = (LinkedList<Vertex>) cheese.clone();
		exploredSet = new LinkedList<Vertex>();
		visitedSet = new LinkedList<Vertex>();
		getGoal(startSpace, currentCheese);
		frontier = new PriorityQueue<Node>(10 , new AStarNodeComparator());
		frontier.add(new Node(start, null, null, 0, manhattanDistance(start)));
		Vertex temp;
		Node goalNode = null;
		boolean goalFound = false;
		int expandedNodes = 1;
		int counter = 1;
		
		while (goalSpace != null){		//when the goal is set, perform a a star search
			goalFound = false;
			frontier.clear();
			frontier.add(new Node(startSpace, null, null, 0, manhattanDistance(startSpace)));
			exploredSet = new LinkedList<Vertex>();
			goalNode = null;
			
			while(!goalFound && !frontier.isEmpty()){
				Node n = frontier.poll();
				expandedNodes++;
				Vertex v = n.nodeVertex;
				if(v.equals(goalSpace)){
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
			while(goalNode!=null){		//track back the path actually visited
				System.out.printf("x:%d y:%d\n", goalNode.nodeVertex.x,goalNode.nodeVertex.y);
				visitedSet.add(goalNode.nodeVertex);
				goalNode = goalNode.parent;
				counter++;
			}
			counter--;
			expandedNodes--;
			
			System.out.printf("Number of steps %d\n", counter);
			System.out.printf("Number of nodes expanded %d\n", expandedNodes);
			
			startSpace = goalSpace;
			getGoal(startSpace, currentCheese);
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
	
	private boolean checkIfInVisitedSet(Vertex v){
		Iterator<Vertex> iter = visitedSet.iterator();
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

	/*
	 * method to do through the linked list of cheese and pick goals
	 */
	private void getGoal(Vertex start, LinkedList<Vertex> cheese){
		int tempDistance = -1;
		LinkedList<Vertex> forDel = new LinkedList<Vertex>();
		if (cheese.isEmpty()){
			goalSpace = null;
			return;
		}else{
			for (Vertex item : cheese){		//find if there's cheese left in the list that is already visited
				if (!exploredSet.isEmpty()){
					if (checkIfInVisitedSet(item)){
						forDel.add(item);
					}
				}
			}
			if (!forDel.isEmpty()){
				for (Vertex item : forDel){
					cheese.remove(item);
				}
			}
			for (Vertex item : cheese){		//get next goal
				if (tempDistance == -1){
					tempDistance = absDistance(start, item);
					goalSpace = item;
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