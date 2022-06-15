
public class Vertex {

	private int distance; // for dijkstra
	private Vertex pi;
	private String name;
	private String stationId;

	public Vertex(String id, String name) {
		this.stationId = id;
		this.name = name;
		this.distance = 0;
		this.pi = null;
	}

	@Override
	public String toString() {
//		return "id: [" + stationId + "] name: [" + name + "]" + "\n";
		return "[" + name + "]" + "\n";

	}

	public String getStationId() {
		return stationId;
	}

	public void setDistance(int newDistance) {
		this.distance = newDistance;
	}

	public int getDistance() {
		return this.distance;
	}

	public void setPi(Vertex pi) {
		this.pi = pi;
	}

	public String getName() {
		return this.name;
	}

	public Vertex getPi() {
		return this.pi;
	}
}
