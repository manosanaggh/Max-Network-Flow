import java.util.ArrayList;

class Vertex{
	private int id;
	private ArrayList<Edge> edges = null;

	Vertex(final int id){
		this.id = id;
		edges = new ArrayList<>();
	}

	final int getId(){
		return id;
	}

	final ArrayList<Edge> getEdges(){
		return edges;
	}

        private final boolean contains (final Edge e){
                for (final Edge a: edges){
                        if (e.getId() == a.getId()){
                                return true;
                        }
                }

                return false;
        }

	final void insertEdge (Edge e){
		if (!contains (e))
			edges.add(e);
	}

	@Override public String toString(){
		return "Vertex id: "+id+"\n"+"Edges: "+edges;
	}
}
