class Edge{
	private int destinationVertexName;
	private int capacity;
	private int flow;
	private Edge reverse;

	Edge(final int name, final int capacity){
		destinationVertexName = name;
		this.capacity = capacity;
		flow = 0;
		this.reverse = null;
	}

        final int getName(){
                return destinationVertexName;
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
                return "("+destinationVertexName+","+capacity+")";
        }
}
