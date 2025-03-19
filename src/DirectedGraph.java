/* Class that describes a DirectedGraph object. */

import java.util.ArrayList;

class DirectedGraph{
	private ArrayList<Vertex> vertices;

	/* DirectedGraph constructor. Used to initialize the fields of the object. */
	DirectedGraph(){
		vertices = new ArrayList<>();
	}

	/* Inner helping method to check if a vertex is already contained in the list of vertices. */
        private final boolean contains (final int id){
                for (final Vertex a: vertices)
                        if (id == a.getId())
                                return true;

                return false;
        }

	/* Method used to insert a vertex. */
	final void insertVertex(final int id){
		if (!contains (id)){
			Vertex v = new Vertex (id);
			vertices.add (v);
		}
	}

	/* Vertices getter. */
	final ArrayList<Vertex> getVertices(){
		return vertices;
	}

	/* Method to print vertices in desired way. */
	final void printVertices(){
		for (final Vertex v: vertices){
			System.out.println (v);
		}
	}
}
