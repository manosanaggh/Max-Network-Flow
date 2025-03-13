class Edge{
	private int destinationVertexName;
	private int capacity;

	public Edge(int name, int capacity){
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
