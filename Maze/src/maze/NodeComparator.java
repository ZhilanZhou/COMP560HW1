package maze;

import java.util.Comparator;

public class NodeComparator implements Comparator<Node> {

	public int compare(Node a, Node b) {
		if(a.pathCost < b.pathCost){
			return -1;
		}
		else if(a.pathCost == b.pathCost){
			return 0;
		}
		return 1;
	}

}
