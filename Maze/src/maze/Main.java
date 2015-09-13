package maze;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	/**
	 * 
	 * @param args Enter name of maze file in command line arguments
	 */
	public static void main(String[] args) {
		Maze m = new Maze("mediumcheese.txt");
		System.out.println("Start x = " + m.start.x);
		System.out.println("Start y = " + m.start.y);
//		System.out.println("Goal x = " + m.goal.x);
//		System.out.println("Goal y = " + m.goal.y);
//		BreadthFirstSearch bfs = new BreadthFirstSearch(m,m.start,m.goal);
//		System.out.println("Starting dfs");
//		DepthFirstSearch dfs = new DepthFirstSearch(m,m.start,m.goal);
//		System.out.println("Starting Greedy");
//		GreedyBestFirstSearch gfs = new GreedyBestFirstSearch(m,m.start,m.goal);
//		System.out.println("Starting A*");
//		AStarSearch aStar = new AStarSearch(m,m.start,m.goal);
		System.out.println("Starting A* cheese");
		AStarSearchForCheese aStar = new AStarSearchForCheese(m,m.start,m.cheese);
	}
	
//	private void BreadthFirstSearch(Maze m){
//		ArrayList<Vertex> exploredSet = new ArrayList<Vertex>();
//		Queue<Vertex> frontier = new LinkedList<Vertex>();
//		boolean goalFound = false;
//		frontier.add(m.start);
//		Vertex temp;
//		while(!(frontier.isEmpty()||goalFound)){
//			Vertex v = frontier.poll();
//			if(m.isGoalVertex(v)){
//				goalFound = true;
//			}
//			else{
//				if(m.canMoveLeft(v)){
//					temp = new Vertex(v.x-1,v.y);
//					if(!exploredSet.contains(temp)){
//						frontier.add(temp);
//					}
//				}
//				if(m.canMoveDown(v)){
//					temp = new Vertex(v.x,v.y-1);
//					if(!exploredSet.contains(temp)){
//						frontier.add(temp);
//					}
//				}
//				if(m.canMoveRight(v)){
//					temp = new Vertex(v.x+1,v.y);
//					if(!exploredSet.contains(temp)){
//						frontier.add(temp);
//					}
//				}
//				if(m.canMoveUp(v)){
//					temp = new Vertex(v.x,v.y+1);
//					if(!exploredSet.contains(temp)){
//						frontier.add(temp);
//					}
//				}
//				
//			}
//		}
//	}	
}
