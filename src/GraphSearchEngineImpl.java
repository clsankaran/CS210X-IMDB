import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.ArrayList;

public class GraphSearchEngineImpl implements GraphSearchEngine{
/*

List bfs (Node s) {
List visitedNodes;
Queue nodesToVisit;

nodesToVisit.enqueue(s);
while (nodesToVisit.size() > 0) {
n = nodesToVisit.dequeue();
visitedNodes.add(n);
for each neighbor n' of n:
if (nodesToVisit doesn’t already contain n'
&& we have not yet visited n'):
nodesToVisit.enqueue(n');
}
return visitedNodes;}

 */


    public List<Node> findShortestPath (Node s, Node t){
        /*List<Node> visitedNodes = new LinkedList<Node>();
        Queue<Node> nodesToVisit = new LinkedList<Node>();

        nodesToVisit.add(s);

        while(nodesToVisit.size() > 0) {
            Node n = nodesToVisit.poll();
            visitedNodes.add(n);

            for(Node neigh : n.getNeighbors()){
                if((!n.getNeighbors().contains(neigh)) || !visitedNodes.contains(neigh)){
                    nodesToVisit.add(neigh);

                }
            }
        }
        return visitedNodes;*/

        ArrayList<Node> shortestPathList = new ArrayList<Node>();
        ArrayList<Node> visited = new ArrayList<Node>();

        if (s.equals(t))
            return null;

        Queue<Node> toVisit = new LinkedList<Node>();
        Stack<Node> pathStack = new Stack<Node>();

        toVisit.add(s);
        pathStack.add(s);
        visited.add(s);

        while(!toVisit.isEmpty())
        {
            Node u = toVisit.poll();

            for(Node neighbor : u.getNeighbors())
            {
                if(!visited.contains(neighbor))
                {
                    toVisit.add(neighbor);
                    visited.add(neighbor);
                    pathStack.add(neighbor);
                    if(u == t)
                        break;
                }
            }
        }


        //To find the path
        Node node;
        Node currentSrc = t;
        shortestPathList.add(t);
        while(!pathStack.isEmpty())
        {
            node = pathStack.pop();
            if(currentSrc.getNeighbors().contains(node))
            {
                shortestPathList.add(node);
                currentSrc = node;
                if(node == s)
                    break;
            }
        }

        return shortestPathList;
     }

}
