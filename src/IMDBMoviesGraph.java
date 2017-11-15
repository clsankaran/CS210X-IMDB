import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.io.*;
import java.util.Scanner;

/**
 * Graph that returns movies as nodes
 *
 */
public class IMDBMoviesGraph extends IMDBGraph {

	IMDBMoviesGraph(String actorFile, String actressFile) throws IOException {
		super(actorFile, actressFile);
	}

	/**
	 * Gets all the nodes in the graph.
	 * 
	 * @return a collection of all the nodes in the graph.
	 */
	public Collection<? extends Node> getNodes() {
		return _movies;
	}

	/**
	 * Returns the Node having the specified name.
	 * 
	 * @param name
	 *            the name of the requested Node
	 * @return the node associated with the specified name or null if no such node
	 *         exists.
	 */
	public Node getNodeByName(String name) {
		for (Node n : _movies) {
			if (n.equals(new ActorNode(name))) {
				return n;
			}
		}

		return null; // if it can't find anything
	}
}