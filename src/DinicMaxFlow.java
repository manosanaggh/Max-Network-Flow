import java.util.*;

class DinicMaxFlow{
	private ArrayList<Integer> level;
	int numVertices;

	DinicMaxFlow(int n){
		numVertices = n;
	}

	private boolean bfs(int source, int sink, ArrayList<Vertex> vertices){
		level = new ArrayList<>(Collections.nCopies(numVertices, -1));
		level.set(source, 0);
		final Queue<Integer> queue = new LinkedList<>();
		queue.add(source);
		
		while(!queue.isEmpty()){
			final int node = queue.poll();
			for (Edge edge : vertices.get(node).getEdges()){
				if (level.get(edge.getName()) == -1
				    && edge.getFlow() < edge.getCapacity()){
					level.set(edge.getName(), level.get(node)+1);
					queue.add(edge.getName());
				}
			}
		}

                System.out.println ("Level Graph: ");
                for (int i = 0; i < level.size(); i++)
                	System.out.println ("Node " +i+"-> Level: "+level.get(i));

		return level.get(sink) != -1;
	}

	private int dfs(int node, int sink, int flow, ArrayList<Vertex> vertices){
		if (node == sink) return flow;
		for (Edge edge : vertices.get(node).getEdges()){
			if (level.get(edge.getName()) == level.get(node) + 1
			    && edge.getFlow() < edge.getCapacity()){
				int minFlow = Math.min(flow, edge.getCapacity() - edge.getFlow());
				int pushedFlow = dfs(edge.getName(), sink, minFlow, vertices);
				Edge reverse = edge.getReverse();

				if (pushedFlow > 0){
					edge.setFlow (edge.getFlow() + pushedFlow);
					reverse.setFlow (reverse.getFlow() - pushedFlow);
					System.out.println ("Flow pushed: " + pushedFlow + " through " + node
							     + " -> " + edge.getName());
					System.out.println ("Updated capacity: " + (edge.getCapacity() - edge.getFlow()));
					return pushedFlow;
				}
			}

		}
		return 0;
	}

	int maxFlow(int source, int sink, DirectedGraph dg){
		int maxFlow = 0;
		ArrayList<Vertex> vertices = dg.getVertices();
		while (bfs(source, sink, vertices)){
			int flow;
			while((flow = dfs(source, sink, Integer.MAX_VALUE, vertices)) > 0)
				maxFlow += flow;

			System.out.println ("\nResidual Graph after flow augmentation:");
			for (int i = 0; i < vertices.size(); i++){
				for (Edge edge : vertices.get(i).getEdges()){
					int capacity = edge.getCapacity();
					if (capacity > 0)
						System.out.println(i + " -> " + edge.getName() + " | Flow: "
								   + edge.getFlow() + " / " + capacity);
				}
			}
			System.out.println("=================================\n");
		}
		return maxFlow;
	}
}
