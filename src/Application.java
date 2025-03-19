/* The class that serves the main/starting point for our Network Flow application. */

import java.util.ArrayList;

class Application{

	/* Main function. */
	public static void main(String[] args){
		DirectedGraph dg = new DirectedGraph(); //Create a graph instance.
		InputParser.parseInput("input/input1.txt", dg); //Enter path/to/input here.
		dg.printVertices(); //Print the input to check validity. Also check reverse edges are alright.
		DinicMaxFlow dmf = new DinicMaxFlow(dg.getVertices().size()); //Create new Dinic's algorithm instance.
		System.out.println ("Max Flow: " + dmf.maxFlow(0, 3, dg)); //Print max flow. Be careful to give source and sink 									     vertex id correctly.		
	}
}
