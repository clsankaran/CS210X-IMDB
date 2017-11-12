import java.util.*;
public class MovieNode implements Node {

    private String _name;
    final private ArrayList<Node> _listOfActors = new ArrayList<ActorNode>();

    public MovieNode (String name) {
        _name = name;
    }

    public String getName () {
        return _name;
    }

    public Collection<? extends Node> getNeighbors () {
        return _listOfActors;
    }

    public void addToNeighnors (ActorNode actor) {
        _listOfActors.add(actor);
    }

}
