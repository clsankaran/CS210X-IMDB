import java.util.*;

public class MovieNode implements Node {

	final private String _name;
	final private ArrayList<ActorNode> _actorsInMovie;

	public MovieNode(String name) {
		_name = name;
		_actorsInMovie = new ArrayList<ActorNode>();
	}

	@Override
	public String getName() {
		return _name;
	}

	@Override
	public Collection<? extends Node> getNeighbors() {
		return _actorsInMovie;
	}

	public void addNeighbor(ActorNode actor) {
		_actorsInMovie.add(actor);
	}

	public boolean equals(Object o) {
		return (((Node) o).getName().equals(_name));
	}

}
