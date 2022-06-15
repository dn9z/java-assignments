
public class Edge {

	private Vertex src; // start
	private Vertex dest; //ziel
	private int weight; // weight
	
	public Edge(Vertex src, Vertex dest, int weight) {
		this.src = src;
		this.dest = dest;
		this.weight = weight;
	}
	
	public String toString(){
		return "src[" + src.toString() + "],dest[" + dest.toString() +"],weight(" + weight + ")\n";
		
	}

	public Vertex getSource() {
		return src;
	}

	public Vertex getDest() {
		return dest;
	}
	
	public int getWeight() {
		return this.weight;
	}

}
