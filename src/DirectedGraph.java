import java.util.ArrayList;

class DirectedGraph{
	private ArrayList<Vertex> vertices = null;

	public DirectedGraph(){
		vertices = new ArrayList<>();
	}

        private boolean contains (int name){
                for (Vertex a: vertices)
                        if (name == a.getName())
                                return true;

                return false;
        }

	public void insertVertex(int from, int to, int capacity){
		if (!contains (from)){
			Vertex v = new Vertex (from);
			vertices.add (v);
			v.insertEdge (new Edge (to, capacity));
		}
		else
			for (Vertex v: vertices)
				if (v.getName() == from)
					v.insertEdge (new Edge (to, capacity));
	}

	public ArrayList<Vertex> getVertices(){
		return vertices;
	}

	public void printVertices(){
		for (Vertex v: vertices){
			System.out.println (v);
		}
	}
}
