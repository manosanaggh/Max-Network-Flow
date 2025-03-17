import java.util.ArrayList;

class Vertex{
	private int name;
	private ArrayList<Edge> edges = null;

	Vertex(final int name){
		this.name = name;
		edges = new ArrayList<>();
	}

	int getName(){
		return name;
	}

	ArrayList<Edge> getEdges(){
		return edges;
	}

        private boolean contains (final Edge e){
                for (final Edge a: edges){
                        if (e.getName() == a.getName()){
                                return true;
                        }
                }

                return false;
        }

	void insertEdge (final Edge e){
		if (!contains (e) && e.getName() > name)
			edges.add(e);
	}

	@Override public String toString(){
		return "Vertex name: "+name+"\n"+"Edges: "+edges;
	}
}
