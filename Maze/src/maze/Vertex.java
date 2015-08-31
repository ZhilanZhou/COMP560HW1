package maze;

public class Vertex {
	int x;
	int y;
	Maze maze;
	
	public Vertex(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public boolean equals(Vertex V){
		return this.x == V.x && this.y == V.y; 
	}
	
}
