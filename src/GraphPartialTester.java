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
		Node actor1 = actorsGraph.getNodeByName("Aaberg, Justin");
		for(Node n : actor1.getNeighbors()){
			System.out.println(n.getName());
			for(Node x : n.getNeighbors()){
				System.out.println(x.getName());
			}
		}
		Node actor2 = actorsGraph.getNodeByName("Aaberg, Anthony");
		for(Node n : actor2.getNeighbors()){
			System.out.println(n.getName());
			for(Node x : n.getNeighbors()){
				System.out.println(x.getName());
			}
		}

		List<Node> shortestPath = searchEngine.findShortestPath(actor1, actor2);

		System.out.println(shortestPath);
		assertNotNull(shortestPath); // there is a path between these people
		assertEquals(shortestPath.get(0), actor1);
		assertEquals(shortestPath.get(shortestPath.size() - 1), actor2);
		assertEquals(shortestPath.size(), 3);

		actor2 = actorsGraph.getNodeByName("Aaberg, Justin");
		shortestPath = searchEngine.findShortestPath(actor1, actor2);
		assertNotNull(shortestPath); // there is a path to the same person
		assertEquals(shortestPath.get(0), actor1);
		assertEquals(shortestPath.get(shortestPath.size() - 1), actor2);
		assertEquals(shortestPath.size(), 1);
		
		actor1 = actorsGraph.getNodeByName("Aaiyappa, Shubra");
		shortestPath = searchEngine.findShortestPath(actor1, actor2);
		assertNull(shortestPath);

	}

	@Before
	/**
	 * Instantiates the actors and movies graphs
	 */
	public void setUp() throws IOException {
		actorsGraph = new IMDBActorsGraph("actors_first_10000_lines.list", "actresses_first_10000_lines.list");
		moviesGraph = new IMDBMoviesGraph("actors_first_10000_lines.list", "actresses_first_10000_lines.list");
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
		testFindNode(moviesGraph, "Spangas in Actie (2015)");
		testFindNode(moviesGraph, "Yohan - Barnevandrer (2010)");
		testNotFindNode(moviesGraph, "Two of Us (2000)"); // TV
		testNotFindNode(moviesGraph, "\"The Company\" (2007)"); // TV
	}

	@Test
	/**
	 * Verifies that specific actors and actresses have been parsed.
	 */
	public void testSpecificActorsAndActresses() {
		testFindNode(actorsGraph, "$, Homo"); // first actor
		testFindNode(actorsGraph, "Abacan, Jose Mari");
		testFindNode(actorsGraph, "Aavik, Evald");
		testFindNode(actorsGraph, "Abad, Mauricio"); // last actor
		testNotFindNode(actorsGraph, "& Ralph, Christian"); // only TV
		testFindNode(actorsGraph, "\"Steff\", Stefanie Oxmann Mcgaha"); // first actress
		testFindNode(actorsGraph, "Abd Elhadi, Maisa");
		testFindNode(actorsGraph, "Abdalla, Catarina");
		testFindNode(actorsGraph, "Abd Elaziz, Donia");
		testFindNode(actorsGraph, "Abdalla, Djamila"); // last actress
		testNotFindNode(actorsGraph, "$haniqua"); // only TV

	}

	@Test
	/**
	 * Verifies that movies have links to the correct actors/actresses
	 */
	public void testMovieNeighbors() {
		assertTrue(moviesGraph.getNodeByName("Same Difference (2015)").getNeighbors()
				.contains(new ActorNode("Aaberg, Andrew"))); // actor
		assertTrue(moviesGraph.getNodeByName("Same Difference (2015)").getNeighbors()
				.contains(new ActorNode("Aaberg, Anthony"))); // actor
		assertTrue(moviesGraph.getNodeByName("Same Difference (2015)").getNeighbors()
				.contains(new ActorNode("Aaberg, Justin"))); // actor
		assertTrue(moviesGraph.getNodeByName("Same Difference (2015)").getNeighbors()
				.contains(new ActorNode("Aaberg, Shawn"))); // actor
		assertTrue(moviesGraph.getNodeByName("Same Difference (2015)").getNeighbors()
				.contains(new ActorNode("Aaberg, Tammy"))); // actress
		assertEquals(moviesGraph.getNodeByName("Same Difference (2015)").getNeighbors().size(), 5);
	}

	@Test
	/**
	 * Verifies that actors and actresses have links to the correct movies
	 */
	public void testActorNeighbors() {
		assertTrue(actorsGraph.getNodeByName("Aadhi (I)") // actor
				.getNeighbors().contains(new MovieNode("Aadu Puli (2011)")));
		assertTrue(actorsGraph.getNodeByName("Aadhi (I)") // actor
				.getNeighbors().contains(new MovieNode("Aravaan (2012)")));
		assertTrue(actorsGraph.getNodeByName("Aadhi (I)") // actor
				.getNeighbors().contains(new MovieNode("Ayyanar (2010)")));
		assertTrue(actorsGraph.getNodeByName("Aadhi (I)") // actor
				.getNeighbors().contains(new MovieNode("Eeram (2009)")));
		assertTrue(actorsGraph.getNodeByName("Aadhi (I)") // actor
				.getNeighbors().contains(new MovieNode("Gundello Godari (2013)")));
		assertTrue(actorsGraph.getNodeByName("Aadhi (I)") // actor
				.getNeighbors().contains(new MovieNode("Kochadaiiyaan (2014)")));
		assertTrue(actorsGraph.getNodeByName("Aadhi (I)") // actor
				.getNeighbors().contains(new MovieNode("Mirugam (2007)")));
		assertTrue(actorsGraph.getNodeByName("Aadhi (I)") // actor
				.getNeighbors().contains(new MovieNode("Sarrainodu (2016)")));
		assertTrue(actorsGraph.getNodeByName("Aadhi (I)") // actor
				.getNeighbors().contains(new MovieNode("Vallinam (2014)")));
		assertTrue(actorsGraph.getNodeByName("Aadhi (I)") // actor
				.getNeighbors().contains(new MovieNode("Yagavarayinum Naa Kakka (2015)")));
		assertEquals(actorsGraph.getNodeByName("Aadhi (I)") // actor
				.getNeighbors().size(), 10);
		assertTrue(actorsGraph.getNodeByName("Aagaard, Patti") // actress
				.getNeighbors().contains(new MovieNode("Golden Boy (2016/I)")));
		assertTrue(actorsGraph.getNodeByName("Aagaard, Patti") // actress
				.getNeighbors().contains(new MovieNode("Nuts! (2016/II)")));
		assertEquals(actorsGraph.getNodeByName("Aagaard, Patti") // actress
				.getNeighbors().size(), 2);

	}

	@Test
	/**
	 * Verifies that actorGraph doesn't return movies.
	 */
	public void testActorGraphNotReturnMovies() {
		testNotFindNode(actorsGraph, "Same Difference (2015)");
	}

	@Test
	/**
	 * Verifies that movieGraph doesn't return actors.
	 */
	public void testMovieGraphNotReturnActors() {
		testNotFindNode(moviesGraph, "Aadhi (I)"); // actor
		testNotFindNode(moviesGraph, "$haniqua"); // actresses
	}

	/**
	 * Verifies that the specific graph contains a node with the specified name.
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
