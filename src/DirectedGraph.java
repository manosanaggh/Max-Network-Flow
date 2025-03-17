import java.util.ArrayList;

class DirectedGraph{
	private ArrayList<Vertex> vertices = null;

	DirectedGraph(){
		vertices = new ArrayList<>();
	}

        private boolean contains (final int name){
                for (final Vertex a: vertices)
                        if (name == a.getName())
                                return true;

                return false;
        }

	void insertVertex(final int from, final int to, final int capacity){
		if (!contains (from)){
			Vertex v = new Vertex (from);
			vertices.add (v);
			v.insertEdge (new Edge (to, capacity));
		}
		else
			for (final Vertex v: vertices)
				if (v.getName() == from)
					v.insertEdge (new Edge (to, capacity));
	}

	ArrayList<Vertex> getVertices(){
		return vertices;
	}

	void printVertices(){
		for (final Vertex v: vertices){
			System.out.println (v);
		}
	}
}
