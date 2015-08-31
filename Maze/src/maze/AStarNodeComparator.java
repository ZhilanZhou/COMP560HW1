package maze;

import java.util.Comparator;

public class AStarNodeComparator implements Comparator<Node> {

	public int compare(Node a, Node b) {
		if(a.manhattanDistance + a.pathCost < b.manhattanDistance + b.pathCost){
			return -1;
		}
		else if(a.manhattanDistance + a.pathCost == b.manhattanDistance + b.pathCost){
			return 0;
		}
		return 1;
	}

}
