import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.*;
import java.io.*;

/**
 * Code to test Project 3; you should definitely add more tests!
 */
public class GraphPartialTester {
	Graph actorsGraph, moviesGraph;
	GraphSearchEngine searchEngine;

	@Test(timeout = 5000)
	/**
	 * Verifies that there is no shortest path between a specific and actor and
	 * actress.
	 */
	public void findShortestPath() {
		final Node actor1 = actorsGraph.getNodeByName("Brad Pitt");
//		for (Node n : actor1.getNeighbors()) {
//			System.out.println(n.getName());
//		}
		final Node actor2 = actorsGraph.getNodeByName("Jonah Hill");
//		for (Node n : actor2.getNeighbors()) {
//			System.out.println(n.getName());
//		}
		final List<Node> shortestPath = searchEngine.findShortestPath(actor1, actor2);
		for (Node n : shortestPath) {
			System.out.println(n.getName());
		}
		assertNull(shortestPath); // there is no path between these people
		
	}

	@Before
	/**
	 * Instantiates the actors and movies graphs
	 */
	public void setUp() throws IOException {
		actorsGraph = new IMDBActorsGraph("actors_test", "actresses_test");
		moviesGraph = new IMDBMoviesGraph("actors_test", "actresses_test");
		searchEngine = new GraphSearchEngineImpl();
	}

	@Test
	/**
	 * Just verifies that the graphs could be instantiated without crashing.
	 */
	public void finishedLoading() {
		assertTrue(true);
		// Yay! We didn't crash
	}

	@Test
	/**
	 * Verifies that a specific movie has been parsed.
	 */
	public void testSpecificMovie() {
		testFindNode(moviesGraph, "Moneyball (2011)");
		testFindNode(moviesGraph, "Pancho's Pizza (2005)");
		testNotFindNode(moviesGraph, "SXSW Flashback 2010 (2010)"); // TV
		testNotFindNode(moviesGraph, "\"Entertainment Tonight\" (1981)"); // TV
	}

	@Test
	/**
	 * Verifies that a specific actor has been parsed.
	 */
	public void testSpecificActor() {
		testFindNode(actorsGraph, "Tom Brady");
		testFindNode(actorsGraph, "Peyton Manning");
		testFindNode(actorsGraph, "Brad Pitt");
		testFindNode(actorsGraph, "Jonah Hill");
	}
	
	@Test
	/**
	 * Verifies that a specific actor has been parsed.
	 */
	public void testActorGraphNotReturnMovies() {
		testNotFindNode(actorsGraph, "Moneyball (2011)");
	}
	

	@Test
	/**
	 * Verifies that a specific actress has been parsed.
	 */
	public void testSpecificActress() {
		testFindNode(actorsGraph, "Angela Aames");
	}

	/**
	 * Verifies that the specific graph contains a node with the specified name
	 * 
	 * @param graph
	 *            the Graph to search for the node
	 * @param name
	 *            the name of the Node
	 */
	private static void testFindNode(Graph graph, String name) {
		final Collection<? extends Node> nodes = graph.getNodes();
		boolean found = false;
		for (Node node : nodes) {
			if (node.getName().trim().equals(name)) {
				found = true;
			}
		}
		assertTrue(found);
	}
	
	private static void testNotFindNode(Graph graph, String name) {
		final Collection<? extends Node> nodes = graph.getNodes();
		boolean found = false;
		for (Node node : nodes) {
			if (node.getName().trim().equals(name)) {
				found = true;
			}
		}
		assertFalse(found);
	}
}
