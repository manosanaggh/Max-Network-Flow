/* Class that describes a Dinic's Algorithm object. */

import java.util.*;

class DinicMaxFlow{
	private static ArrayList<Integer> level; // ArrayList used to store the levels for each edge.
	static int numVertices; // The number of vertices.

	/* numVertices setter. */
	static final void setNumVertices(final int n){
		numVertices = n;
	}

	/* Bfs traversal (iterative) to build the level graph. */
	private static final boolean bfs(final int source, final int sink, final ArrayList<Vertex> vertices){
		level = new ArrayList<>(Collections.nCopies(numVertices, -1)); // Initialize the level list.
		level.set(source, 0); // Set source level to 0 to initialize the first level.
		final Queue<Integer> queue = new LinkedList<>(); // Queue needed to implement bfs.
		queue.add(source); // Add source to queue to begin bfs.
		
		while(!queue.isEmpty()){
			final int node = queue.poll(); // Dequeue in FIFO order.
			/* Traverse the edges of the vertex. */
			for (Edge edge : vertices.get(node).getEdges()){
				/* If the level of destination vertex is not set and there is unused capacity, do things. */
				if (level.get(edge.getId()) == -1
				    && edge.getFlow() < edge.getCapacity()){
					level.set(edge.getId(), level.get(node)+1); // Set the level of destination vertex to be 										    // the level of the source vertex plus 1.
					queue.add(edge.getId()); // Add destination vertex to the queue to traverse it.
				}
			}
		}

		/* Print the level graph. */
                System.out.println ("Level Graph: ");
                for (int i = 0; i < level.size(); i++)
                	System.out.println ("Node " +i+"-> Level: "+level.get(i));

		return level.get(sink) != -1;
	}

	/* Dfs traversal (recursive) to find augmentation paths and push flow. */
	private static final int dfs(final int node, final int sink, final int flow, final ArrayList<Vertex> vertices){
		/* If we reach the sink, nothing can be done thus start terminating the recursion. */
		if (node == sink) return flow;

		/* Traverse the edges of the vertex. */
		for (Edge edge : vertices.get(node).getEdges()){
			/* If the level of the destination vertex equals level(source)+1 and we have available capacity,
			   do things. */
			if (level.get(edge.getId()) == level.get(node) + 1
			    && edge.getFlow() < edge.getCapacity()){
				final int minFlow = Math.min(flow, edge.getCapacity() - edge.getFlow()); // Compute minimum flow 													 // on an edge.
				final int pushedFlow = dfs(edge.getId(), sink, minFlow, vertices); // Pushed flow will be the
												   // total minimum flow of the 												   // path.
				final Edge reverse = edge.getReverse(); // Get the reverse edge.

				/* If the pushed flow is greater than the initial, do things.*/
				if (pushedFlow > 0){
					edge.setFlow (edge.getFlow() + pushedFlow); // Set the flow of the edge.
					reverse.setFlow (reverse.getFlow() - pushedFlow); // Set the flow on the reverse edge.
					/* Do necessary printing. */
					System.out.println ("Flow pushed: " + pushedFlow + " through " + node
							     + " -> " + edge.getId());
					System.out.println ("Updated capacity: " + (edge.getCapacity() - edge.getFlow()));
					return pushedFlow;
				}
			}

		}
		return 0;
	}

	/* Find the max flow on the graph. */
	static final int maxFlow(final int source, final int sink, final DirectedGraph dg){
		int maxFlow = 0; // Initialize sum.
		final ArrayList<Vertex> vertices = dg.getVertices(); // Get vertices.
		/* Do bfs until we are done. */
		while (bfs(source, sink, vertices)){
			int flow;
			/* Do dfs until returned flow is 0. */
			while((flow = dfs(source, sink, Integer.MAX_VALUE, vertices)) > 0)
				maxFlow += flow; // Accumulate maxFlow.

			/* Print the residual graph and return maxFlow. */
			System.out.println ("\nResidual Graph after flow augmentation:");
			for (int i = 0; i < vertices.size(); i++){
				for (Edge edge : vertices.get(i).getEdges()){
					final int capacity = edge.getCapacity();
					if (capacity > 0)
						System.out.println(i + " -> " + edge.getId() + " | Flow: "
								   + edge.getFlow() + " / " + capacity);
				}
			}
			System.out.println("=================================\n");
		}
		return maxFlow;
	}
}
