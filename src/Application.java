import java.util.ArrayList;

class Application{
	public static void main(String[] args){
		DirectedGraph dg = new DirectedGraph();
		InputParser parser = new InputParser();
		parser.parseInput("input/input1.txt", dg);
		dg.printVertices();		
	}
}
