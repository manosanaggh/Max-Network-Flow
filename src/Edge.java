/* Class that describes an Edge object. */

class Edge{
	private int destinationVertexId; // Destination vertex id.
	private int capacity; // Capacity of the edge.
	private int flow; // Flow of the edge.
	private Edge reverse; // The reverse edge needed for correct implementation of Dinic's algorithm.

	/* Edge contructor. Used to initialize the fields of the object. */
	Edge(final int id, final int capacity){
		destinationVertexId = id;
		this.capacity = capacity;
		flow = 0;
		this.reverse = null;
	}

	/* Id getter. */
        final int getId(){
                return destinationVertexId;
        }

	/* Capacity getter. */
        final int getCapacity(){
                return capacity;
        }

	/* Reverse edge setter. */
	final void setReverse(final Edge reverse){
		this.reverse = reverse;
	}

	/* Reverse edge getter. */
	final Edge getReverse(){
		return reverse;
	}

	/* Flow setter. */
	final void setFlow(final int flow){
		this.flow = flow;
	}

	/* Flow getter. */
	final int getFlow(){
		return flow;
	}

	/* toString method used to print the object. */
        @Override public String toString(){
                return "("+destinationVertexId+","+capacity+")";
        }
}
