package maze;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Maze {

	private boolean[][] mazeArray;
	public Vertex goal;
	public Vertex start;
	
	public Maze(String fileLoc){
		BufferedReader br = null;
		try {
			br = new  BufferedReader (new FileReader(fileLoc) );
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			
			while(br.readLine()!=null){
				System.out.println();
			}
		} catch (IOException e) {}
		
	}
	
	public boolean canMoveLeft(Vertex v){
		return mazeArray[v.x-1][v.y];
	}
	
	public boolean canMoveRight(Vertex v){
		return mazeArray[v.x+1][v.y];
	}
	
	public boolean canMoveDown(Vertex v){
		return mazeArray[v.x][v.y-1];
	}
	
	public boolean canMoveUp(Vertex v){
		return mazeArray[v.x][v.y+1];
	}
	
	
}
