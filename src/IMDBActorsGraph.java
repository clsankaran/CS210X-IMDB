import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.io.*;
import java.util.Scanner;

// FIX ALL SPACES WITH CORRECT TABS
public class IMDBActorsGraph implements Graph {

	final List<ActorNode> _actors;
	final List<MovieNode> _movies;

	IMDBActorsGraph(String actorFile, String actressFile) throws IOException {
		final File fileActor = new File(actorFile);
		final File fileActress = new File(actressFile);
		_actors = new ArrayList<ActorNode>();
		_movies = new ArrayList<MovieNode>();
		Scanner scanner = new Scanner(fileActor, "ISO-8859-1");
		parse(scanner);
		// scanner = new Scanner(fileActress, "ISO-8859-1");
		// parse(scanner);
	}
	
	private void parse(Scanner scanner) {
		String line;
		do {
			line = scanner.nextLine();
		} while (!(line.contains("Name            Titles")));
		// line is currently "Name Titles"
		line = scanner.nextLine();
		line = scanner.nextLine();
		// line is currently the first actor
		while (!(line.startsWith("---"))) { // while it is not the end
			if (!(line.equals(""))) { // if it is not just a blank
				if (!(line.startsWith("            "))) {
					final String name;
					if (line.contains(",")) {
						final String lastName = line.substring(0, line.indexOf(","));
						line = line.substring(line.indexOf(",") + 2); // skips ", "
						final String firstName = line.substring(0, line.indexOf(" "));
						line = line.substring(line.indexOf(" "));
						name = firstName + " " + lastName;
					} else {
						name = line.substring(0, line.indexOf(" "));
					}
					_actors.add(new ActorNode(name));
				}
				if (!(line.contains("(TV)"))) {
					while (line.substring(0, 1).equals(" ")) {
						line = line.substring(1); // take off first character until you get to the title of movie
					}
					if (!(line.startsWith("\""))) {
						final String movie = line.substring(0, line.indexOf(")") + 1);
						if (!(_movies.contains(new MovieNode(movie)))) { // if it doesn't contain a movie with that
																			// name
							_movies.add(new MovieNode(movie));
							_actors.get(_actors.size() - 1).addNeighbor(new MovieNode(movie));
							// add the movie as a neighbor to actor
							_movies.get(_movies.size() - 1).addNeighnor(_actors.get(_actors.size() - 1));
							// add the actor as a neighbor to the movie
						} else {
							_movies.get(_movies.indexOf(new MovieNode(movie)))
									.addNeighnor(_actors.get(_actors.size() - 1));
							// find the movie node with that name and add the most recently added actor as a
							// neighbor
							_actors.get(_actors.size() - 1)
									.addNeighbor(_movies.get(_movies.indexOf(new MovieNode(movie))));
							// add the movie as a neighbor to the most recently added actor
						}
					}
				}
			}
			line = scanner.nextLine();
		}
	}

	/**
	 * Gets all the nodes in the graph.
	 * 
	 * @return a collection of all the nodes in the graph.
	 */
	public Collection<? extends Node> getNodes() {
		final Collection<Node> allNodes = new ArrayList<Node>();
		allNodes.addAll(_actors);
		allNodes.addAll(_movies);
		return allNodes;
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