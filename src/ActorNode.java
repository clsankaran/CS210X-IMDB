import java.util.*;

public class ActorNode implements Node {

	final private String _name;
	final private ArrayList<MovieNode> _moviesActedIn;

	public ActorNode(String name) {
		_name = name;
		_moviesActedIn = new ArrayList<MovieNode>();
	}

	@Override
	public String getName() {
		return _name;
	}

	@Override
	public Collection<? extends Node> getNeighbors() {
		return _moviesActedIn;
	}
	
	public void addToNeighbors(MovieNode movie) {
		_moviesActedIn.add(movie);
	}
	
}
