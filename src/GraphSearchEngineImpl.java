import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
        List<Node> visitedNodes = new LinkedList<Node>();
        Queue<Node> nodesToVisit = new LinkedList<Node>();

        nodesToVisit.add(s);

        while(nodesToVisit.size() > 0) {
            Node n = nodesToVisit.poll();
            visitedNodes.add(n);

            for(Node neigh: n.getNeighbors()){
                if((!n.getNeighbors().contains(neigh)) || !visitedNodes.contains(neigh)){
                    nodesToVisit.add(neigh);

                }
            }
        }
        return visitedNodes;
     }


}
