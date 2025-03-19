import java.io.*;
import java.util.*;

class InputParser{
	final static void parseInput (final String filename, final DirectedGraph dg){
		try (final BufferedReader br = new BufferedReader (new FileReader (filename))){
			String line;
			final int numVertices = Integer.parseInt (br.readLine().trim());
			for (int i = 0; i < numVertices; i++){
				dg.insertVertex (i);	
			}
			while ((line = br.readLine()) != null){
				final String[] parts = line.split ("\\s+");
				final int[] numbers = Arrays.stream(parts).mapToInt(Integer::parseInt).toArray();
				final Edge e0 = new Edge (numbers[1], numbers[2]);
				final Edge e1 = new Edge (numbers[0], 0);
				e0.setReverse(e1);
				e1.setReverse(e0);
				dg.getVertices().get(numbers[0]).insertEdge(e0);
				dg.getVertices().get(numbers[1]).insertEdge(e1);
			}
		} catch (IOException | NumberFormatException e){
			e.printStackTrace();
		}
	}
}
