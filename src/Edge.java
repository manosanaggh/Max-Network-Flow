class Edge{
	private int destinationVertexName;
	private int capacity;

	Edge(final int name, final int capacity){
		destinationVertexName = name;
		this.capacity = capacity;
	}

        int getName(){
                return destinationVertexName;
        }

        int getCapacity(){
                return capacity;
        }

        @Override public String toString(){
                return "("+destinationVertexName+","+capacity+")";
        }
}
