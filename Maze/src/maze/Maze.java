package maze;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedList;

public class Maze {

	private boolean[][] mazeArray;

	public enum Direction{
		up, down, left, right
	}
	
	public Vertex goal;
	public Vertex start;
	public LinkedList<Vertex> cheese;

	public int mazeWidth;
	public int mazeHeight;
	
	public Maze(String fileLoc){
		ArrayList<String> stringList = generateStringList(fileLoc);
		if(!stringList.isEmpty())
			generateMazeArray(stringList);
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
	
	public boolean isGoalVertex(Vertex v){
		return v.equals(goal);
	}
	
	public boolean isCheese(Vertex v){
		return cheese.contains(v);
	}
	
	private ArrayList<String> generateStringList(String fileLoc){
		BufferedReader br;
		ArrayList<String> stringList = new ArrayList<String>(); 
		try {
			br = new BufferedReader (new FileReader(fileLoc) );
			//Read in text file line by line
			for(String input = br.readLine(); input != null; input = br.readLine()){
				stringList.add(input);
			}
			br.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return stringList;
	}

	private void generateMazeArray(ArrayList<String> stringList){
		//Identify width of maze based on length of first line
		mazeWidth = stringList.get(0).length();
		//Identify height of maze based on length of arrayList
		mazeHeight = stringList.size();
		//Initialize maze array to proper dimensions
		mazeArray = new boolean[mazeWidth][mazeHeight];
		
		//Fill in array line by line
		for(int y = 0; y < mazeHeight; y++){
			String currentLine = stringList.get(y);
			for(int x = 0; x < mazeWidth; x++){
				//If current space is '%', mark as not traversable
				if(currentLine.charAt(x) == '%'){
					mazeArray[x][y] = false;
				}
				else{
					//If current space is 'S', record start space
					if(currentLine.charAt(x) == 'S')
						start = new Vertex(x, y);
					//If current space is 'G', record goal space
					if(currentLine.charAt(x) == 'G')
						goal = new Vertex(x, y);
					//If current space is '.', record cheese space
					if(currentLine.charAt(x) == '.')
						cheese.add(new Vertex(x, y));
					//Mark space as traversable
					mazeArray[x][y] = true;
				}
			}
		}
	}
}
