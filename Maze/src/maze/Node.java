package maze;

import maze.Maze.Direction;

public class Node {
	
	static Maze maze;
	int pathCost;
	Vertex nodeVertex; //Vertex which is represented by this node
	Node parent; //Pointer to parent node
	Direction parentDirection;
	
	public Node(Vertex v, Node p, Direction parentD, int c){
		nodeVertex = v;
		parent = p;
		parentDirection = parentD;
		pathCost = c;
	}
	
	public Vertex expandUp(Vertex v){
		if(maze.canMoveUp(v)){
			return new Vertex(this.nodeVertex.x, this.nodeVertex.y - 1);
		}
		else
			return null;
	}
	
	public Vertex expandDown(Vertex v){
		if(maze.canMoveDown(v)){
			return new Vertex(this.nodeVertex.x, this.nodeVertex.y + 1);
		}
		else
			return null;
	}
	
	public Vertex expandLeft(Vertex v){
		if(maze.canMoveLeft(v)){
			return new Vertex(this.nodeVertex.x - 1, this.nodeVertex.y);
		}
		else
			return null;
	}
	
	public Vertex expandRight(Vertex v){
		if(maze.canMoveRight(v)){
			return new Vertex(this.nodeVertex.x + 1, this.nodeVertex.y);
		}
		else
			return null;
	}
}
