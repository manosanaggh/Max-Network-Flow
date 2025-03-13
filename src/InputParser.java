import java.io.*;
import java.util.*;

class InputParser{
	public static void parseInput (String filename, DirectedGraph dg){
		try (BufferedReader br = new BufferedReader (new FileReader (filename))){
			String line;
			int lineCount = 0;
			int numVertices = Integer.parseInt (br.readLine().trim());
			//System.out.println (numVertices);
			while ((line = br.readLine()) != null){
				String[] parts = line.split ("\\s+");
				int[] numbers = Arrays.stream(parts).mapToInt(Integer::parseInt).toArray();
				//System.out.println (numbers[0]+" "+numbers[1]+" "+numbers[2]);
				dg.insertVertex (numbers[0], numbers[1], numbers[2]);
			}
		} catch (IOException | NumberFormatException e){
			e.printStackTrace();
		}
	}
}
