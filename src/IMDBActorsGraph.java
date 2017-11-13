import java.util.ArrayList;
import java.util.Collection;
import java.io.*;
import java.util.Scanner;

public class IMDBActorsGraph implements Graph {
	
	final ArrayList<ActorNode> actors;
	final ArrayList<MovieNode> movies;
	
	IMDBActorsGraph(String actorFile, String actressFile) throws IOException {
		final File fileActor = new File(actorFile);
		final File fileActress = new File(actressFile);
		actors = new ArrayList<ActorNode>();
		movies = new ArrayList<MovieNode>();
		Scanner scanner = new Scanner(fileActor, "ISO-8859-1");

		String line;
		do {
			line = scanner.nextLine();
		} while (!(line.contains("Name            Titles")));
		
		//line is currently "Name			Titles" 
		line = scanner.nextLine();
		line = scanner.nextLine();
		//line is currently the first actor
		
		if (!(line.startsWith("            "))) {
			final String name;
			if (line.contains(",")) {
				final String lastName = line.substring(0,line.indexOf(","));
				
				line=line.substring(line.indexOf(",")+2); //skips ", "
				final String firstName = line.substring(0,line.indexOf(" "));
				name = firstName + " " + lastName;
			}
			else {
				name = line.substring(0,line.indexOf(" "));
			}
			actors.add(new ActorNode(name));
			
			
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