import java.util.Collection;
import java.io.*;
import java.util.Scanner;

public class IMDBActorsGraph implements Graph {
	IMDBActorsGraph(String actorFile, String actressFile) throws IOException {
		File fileActor = new File(actorFile);
		File fileActress = new File(actressFile);
		Scanner scanner = new Scanner(fileActor);
		while(scanner.hasNextLine()){
			String line = scanner.nextLine();
		}
	}

	/**
	 * Gets all the nodes in the graph.
	 * 
	 * @return a collection of all the nodes in the graph.
	 */
	public Collection<? extends Node> getNodes() {
		return null;
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
		return null;
	}
}