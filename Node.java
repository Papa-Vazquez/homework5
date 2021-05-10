package GraphPackage;
///https://stackabuse.com/graphs-in-java-representing-graphs-in-code/
public class Node {
	int n;
    String name;
    boolean visited; // New attribute
   
    Node(int n, String name) {
        this.n = n;
        this.name = name;
        visited = false;
    }

    //boolean method to check that a Node has in fact been visited already in the traversal
    void visit() {
        visited = true;
    }
    //boolean method to uncheck if a Node has been visited in order to do another traversal
    void unvisit() {
        visited = false;
    }
    // Method used to see if the Node has been "visited" yet
	public boolean isVisited() {
		if (visited == false) 
            return false;
        else   
            return true;
	}
}
