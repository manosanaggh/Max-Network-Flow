import java.util.ArrayList;

class Vertex{
	private int name;
	private ArrayList<Edge> edges = null;

	public Vertex(int name){
		this.name = name;
		edges = new ArrayList<>();
	}

	public int getName(){
		return name;
	}

	public ArrayList<Edge> getEdges(){
		return edges;
	}

        private boolean contains (Edge e){
                for (Edge a: edges){
                        if (e.getName() == a.getName()){
                                return true;
                        }
                }

                return false;
        }

	public void insertEdge (Edge e){
		if (!contains (e) && e.getName() > name)
			edges.add(e);
	}

	@Override public String toString(){
		return "Vertex name: "+name+"\n"+"Edges: "+edges;
	}
}
