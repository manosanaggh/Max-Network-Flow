class Edge{
	private int destinationVertexName;
	private int capacity;

	Edge(final int name, final int capacity){
		destinationVertexName = name;
		this.capacity = capacity;
	}

        final int getName(){
                return destinationVertexName;
        }

        final int getCapacity(){
                return capacity;
        }

        @Override public String toString(){
                return "("+destinationVertexName+","+capacity+")";
        }
}
