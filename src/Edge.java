class Edge{
	private int destinationVertexName;
	private int capacity;

	public Edge(final int name, final int capacity){
		destinationVertexName = name;
		this.capacity = capacity;
	}

        public int getName(){
                return destinationVertexName;
        }

        public int getCapacity(){
                return capacity;
        }

        @Override public String toString(){
                return "("+destinationVertexName+","+capacity+")";
        }
}
