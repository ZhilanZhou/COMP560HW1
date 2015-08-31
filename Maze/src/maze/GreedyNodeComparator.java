package maze;

import java.util.Comparator;

public class GreedyNodeComparator implements Comparator<Node> {

	public int compare(Node a, Node b) {
		if(a.manhattanDistance < b.manhattanDistance){
			return -1;
		}
		else if(a.manhattanDistance == b.manhattanDistance){
			return 0;
		}
		return 1;
	}

}
