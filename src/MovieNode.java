import java.util.*;
public class MovieNode implements Node {

    final private String _name;
    final private ArrayList<ActorNode> _actorsInMovie;

    public MovieNode (String name) {
        _name = name;
        _actorsInMovie = new ArrayList<ActorNode>();
    }

    public String getName () {
        return _name;
    }

    public Collection<? extends Node> getNeighbors () {
        return _actorsInMovie;
    }

    public void addToNeighnors (ActorNode actor) {
        _actorsInMovie.add(actor);
    }

}
