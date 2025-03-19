/* Class that describes a Vertex object. */

import java.util.ArrayList;

class Vertex{
	private int id; // Unique id for each vertex.
	private ArrayList<Edge> edges = null; // Outgoing edges.

	/* Vertex contructor. Used to initialize the fields of the object.*/
	Vertex(final int id){
		this.id = id;
		edges = new ArrayList<>();
	}

	/* Id getter. */
	final int getId(){
		return id;
	}

	/* Edges getter. */
	final ArrayList<Edge> getEdges(){
		return edges;
	}

	/* Inner helping method to check if an edge is already contained in the list of edges. */
        private final boolean contains (final Edge e){
                for (final Edge a: edges){
                        if (e.getId() == a.getId()){
                                return true;
                        }
                }

                return false;
        }

	/* Method used to insert an edge. */
	final void insertEdge (final Edge e){
		if (!contains (e))
			edges.add(e);
	}

	/* toString method used to print the object. */
	@Override public String toString(){
		return "Vertex id: "+id+"\n"+"Edges: "+edges;
	}
}
