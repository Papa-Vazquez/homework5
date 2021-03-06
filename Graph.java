package GraphPackage;
import java.util.HashMap;
import java.util.LinkedList;

public class Graph<T> implements GraphInterface {

    private HashMap<Node, LinkedList<Node>> adjacencyMap;
    private boolean directed;

    public Graph(boolean directed) {
        this.directed = directed;
        adjacencyMap = new HashMap<>();
    }

    public void addEdgeHelper(Node a, Node b) {
        LinkedList<Node> tmp = adjacencyMap.get(a);
    
        if (tmp != null) {
            tmp.remove(b);
        }
        else tmp = new LinkedList<>();
        tmp.add(b);
        adjacencyMap.put(a, tmp);
    }
    
    public void addEdge(Node source, Node destination) {
    
        // We make sure that every used node shows up in our .keySet()
        if (!adjacencyMap.keySet().contains(source))
            adjacencyMap.put(source, null);
    
        if (!adjacencyMap.keySet().contains(destination))
            adjacencyMap.put(destination, null);
    
        addEdgeHelper(source, destination);
    
        // If a graph is undirected, we want to add an edge from destination to source as well
        if (!directed) {
            addEdgeHelper(destination, source);
        }
    }

    public void arrayList() {
        System.out.println("Array");
        for (Node node : adjacencyMap.keySet()) {
            System.out.print(node.name + " neighbors are ");
            for (Node neighbor : adjacencyMap.get(node)) {
                System.out.print(neighbor.name + " ");
            }
            System.out.println();
        }
    }
    
    public boolean hasEdge(Node source, Node destination) {
        return adjacencyMap.containsKey(source) && adjacencyMap.get(source).contains(destination);
    }
    
    public void resetNodesVisited(){
        for(Node node : adjacencyMap.keySet()){
            node.unvisit();
        }
    }

    public void depthFirstSearchHelper(Node node) {
        node.visit();
        System.out.print(node.name + " ");
    
        LinkedList<Node> allNeighbors = adjacencyMap.get(node);
            if (allNeighbors == null)
                return;

        for (Node neighbor : allNeighbors) {
            if (!neighbor.isVisited())
                depthFirstSearch(neighbor);
        }
    }
    // Depth Search cannot be recursive! We need to use a stack (iterative)
    public void depthFirstSearch(Node node) {
        depthFirstSearchHelper(node);

        for (Node n : adjacencyMap.keySet()) {
            if (!n.isVisited()) {
                depthFirstSearch(n);
            }
        }
    }
    
    public void breadthFirstSearchHelper(Node node) {
        // Just so we handle receiving an uninitialized Node, otherwise an
        // exception will be thrown when we try to add it to queue
        if (node == null)
            return;

        // Creating the queue, and adding the first node (step 1)
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(node);
    
        while (!queue.isEmpty()) {
            Node currentFirst = queue.removeFirst();

            // In some cases we might have added a particular node more than once before
            // actually visiting that node, so we make sure to check and skip that node if we have
            // encountered it before
            if (currentFirst.isVisited())
                continue;
    
            // Mark the node as visited
            currentFirst.visit();
            System.out.print(currentFirst.name + " ");
    
            LinkedList<Node> allNeighbors = adjacencyMap.get(currentFirst);
    
            // We have to check whether the list of neighbors is null before proceeding, otherwise
            // the for-each loop will throw an exception
            if (allNeighbors == null)
                continue;
    
            for (Node neighbor : allNeighbors) {
                // We only add unvisited neighbors
                if (!neighbor.isVisited()) {
                    queue.add(neighbor);
                }
            }
        }

    }

    public void breadthFirstSearch(Node node) {
        breadthFirstSearchHelper(node);
        for (Node n : adjacencyMap.keySet()) {
            if (!n.isVisited()) {
                breadthFirstSearch(n);
            }
        }
    }
    
}
