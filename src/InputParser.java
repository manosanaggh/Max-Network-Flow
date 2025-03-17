import java.io.*;
import java.util.*;

class InputParser{
	public static void parseInput (final String filename, final DirectedGraph dg){
		try (final BufferedReader br = new BufferedReader (new FileReader (filename))){
			String line;
			final int numVertices = Integer.parseInt (br.readLine().trim());
			while ((line = br.readLine()) != null){
				final String[] parts = line.split ("\\s+");
				final int[] numbers = Arrays.stream(parts).mapToInt(Integer::parseInt).toArray();
				dg.insertVertex (numbers[0], numbers[1], numbers[2]);
			}
		} catch (IOException | NumberFormatException e){
			e.printStackTrace();
		}
	}
}
