class Edge{
	private int destinationVertexId;
	private int capacity;
	private int flow;
	private Edge reverse;

	Edge(final int id, final int capacity){
		destinationVertexId = id;
		this.capacity = capacity;
		flow = 0;
		this.reverse = null;
	}

        final int getId(){
                return destinationVertexId;
        }

        final int getCapacity(){
                return capacity;
        }

	final void setReverse(Edge reverse){
		this.reverse = reverse;
	}

	final Edge getReverse(){
		return reverse;
	}

	final void setFlow(int flow){
		this.flow = flow;
	}

	final int getFlow(){
		return flow;
	}

        @Override public String toString(){
                return "("+destinationVertexId+","+capacity+")";
        }
}
