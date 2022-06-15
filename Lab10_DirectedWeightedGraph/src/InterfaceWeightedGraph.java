import java.util.ArrayList;

public interface InterfaceWeightedGraph {

	public void init();
	public Edge getEdge();
	public Vertex getVertex();
	public ArrayList<Vertex> getNeighbors(Vertex v);
	
	public void dijkstra(Vertex start);
	public int getWeight(Vertex dest);
	
}
