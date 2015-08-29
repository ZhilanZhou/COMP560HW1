package maze;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Maze {

	private boolean[][] mazeArray;
	public int goalX;
	public int goalY;
	public int startX;
	public int startY;
	
	public Maze(String fileLoc){
//		Scanner s = new Scanner(System.in);
//		while
		BufferedReader br = null;
		try {
			br = new  BufferedReader (new FileReader(fileLoc) );
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			while(br.readLine()!=null){
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public boolean canMoveLeft(int x, int y){
		return mazeArray[x-1][y];
	}
	
	public boolean canMoveRight(int x, int y){
		return mazeArray[x+1][y];
	}
	
	public boolean canMoveDown(int x, int y){
		return mazeArray[x][y-1];
	}
	
	public boolean canMoveUp(int x, int y){
		return mazeArray[x][y+1];
	}
	
}
