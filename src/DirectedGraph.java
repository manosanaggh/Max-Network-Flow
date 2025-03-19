import java.util.ArrayList;

class DirectedGraph{
	private ArrayList<Vertex> vertices = null;

	DirectedGraph(){
		vertices = new ArrayList<>();
	}

        private final boolean contains (final int id){
                for (final Vertex a: vertices)
                        if (id == a.getId())
                                return true;

                return false;
        }

	final void insertVertex(final int id){
		if (!contains (id)){
			Vertex v = new Vertex (id);
			vertices.add (v);
		}
	}

	final ArrayList<Vertex> getVertices(){
		return vertices;
	}

	final void printVertices(){
		for (final Vertex v: vertices){
			System.out.println (v);
		}
	}
}
