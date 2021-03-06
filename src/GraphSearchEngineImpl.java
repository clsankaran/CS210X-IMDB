import java.util.*;

public class GraphSearchEngineImpl implements GraphSearchEngine {
	public List<Node> findShortestPath(Node s, Node t) {

		final ArrayList<Node> shortestPath = new ArrayList<Node>();
		final Queue<Node> toVisit = new LinkedList<Node>();
		final Stack<Node> visited = new Stack<Node>();
		final HashMap<Node, Integer> distance = new HashMap<Node, Integer>();
		Boolean found = false;

		toVisit.add(s);
		distance.put(s, 0);
		Node u;

		while (!(toVisit.isEmpty())) {
			u = toVisit.poll();
			visited.add(u);
			if (u.equals(t)) {
				found = true;
				break;
			}
			for (Node neighbor : u.getNeighbors()) {
				if (!(toVisit.contains(neighbor)) && !(visited.contains(neighbor))) {
					toVisit.add(neighbor);
					distance.put(neighbor, distance.get(u) + 1);
				}
			}
		}

		if (!found) {
			return null;
		} else {
			Node n;
			Node current = t;
			shortestPath.add(t);
			while (!visited.isEmpty()) {
				n = visited.pop();
				if (current.getNeighbors().contains(n) && distance.get(n) + 1 == distance.get(current)) {
					shortestPath.add(n);
					current = n;
					if (n.equals(s))
						break;
				}
			}
			Collections.reverse(shortestPath);
			return shortestPath;
		}

	}

}
