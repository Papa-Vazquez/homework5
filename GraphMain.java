package GraphPackage;

public class GraphMain {
	   public static void main(String[] args) {

	        Graph test = new Graph(false);
	        Node a = new Node(0, "A");
	        Node b = new Node(1, "B");
	        Node c = new Node(2, "C");
	        Node d = new Node(3, "D");
	        Node e = new Node(4, "E");
	        Node f = new Node(5, "F");
	        Node g = new Node(6, "G");
	        Node h = new Node(7, "H");

	        test.addEdge(a,d);
	        test.addEdge(a,b);
	        test.addEdge(c,e);
	        test.addEdge(e,a);
	        test.addEdge(a,e);
	        test.addEdge(e,f);
	        test.addEdge(f,a);
	        test.addEdge(f,h);
	        test.addEdge(h,g);
	        test.addEdge(g,a);

	        // Breadth-first Search
	        System.out.println("TASK 1");
	        System.out.println("Breadth Search: ");
	        test.breadthFirstSearch(a);
	        test.resetNodesVisited();
	        
	        
	        System.out.println();
	        
	        
	        // Depth-First Search
	        System.out.println("TASK 2");
	        System.out.println("Depth Search:");
	        test.depthFirstSearch(a);
	        test.resetNodesVisited();

	        

	        
	        
	        
	    }
}