package GraphPackage;
//https://stackabuse.com/graphs-in-java-representing-graphs-in-code/
public interface GraphInterface<T> {
	public void addEdgeHelper(Node a, Node b);
    public void addEdge(Node source, Node destination);
    public void arrayList();
    public boolean hasEdge(Node source, Node destination);
    public void resetNodesVisited();

    public void depthFirstSearchHelper(Node node);
    public void depthFirstSearch(Node node);
    public void breadthFirstSearchHelper(Node node);
    public void breadthFirstSearch(Node node);
}
