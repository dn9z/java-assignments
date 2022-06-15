import java.util.ArrayList;
import java.util.Stack;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class WeightedGraph {

	private ArrayList<Vertex> vertices;
	private ArrayList<Edge> edges;

	public WeightedGraph() {
		vertices = new ArrayList<Vertex>();
		edges = new ArrayList<Edge>();
	}

	public static void main(String[] args) throws IOException {
		WeightedGraph main = new WeightedGraph();
		main.init();
		// System.out.println(main.vertices);
		// System.out.println(main.edges);
		Vertex start = main.getVertexByName("S Karlshorst Bhf (Berlin)");
		Vertex dest = main.getVertexByName("S Schöneweide Bhf (Berlin)");
		main.dijkstra(start);
		ArrayList<Vertex> reversePath = main.getPath(dest); // Route ist falsch rum
		ArrayList<Vertex> path = reversePath(reversePath); // Route wird korrigiert
		main.printDetailedPath(path);

	}

	private void printDetailedPath(ArrayList<Vertex> path) {
		Vertex start = path.get(0);
		System.out.println("You are starting here: " + start.toString());
		int timeInSum = 0;
		for (int i = 1; i < path.size(); i++) {
			Vertex next = path.get(i);
			int time = next.getDistance();
			time = time - timeInSum;
			timeInSum += time;
			System.out.println("The time to get to the next station is: " + time/60.0 + " minutes.");
			System.out.println("You are Now at: " + next.toString());
		}
		System.out.println("Your travel time took: " + timeInSum/60.0 + " minutes.");
	}

	private static ArrayList<Vertex> reversePath(ArrayList<Vertex> reversePath) {
		ArrayList<Vertex> path = new ArrayList<Vertex>();
		Stack<Vertex> st = new Stack<Vertex>();
		for (Vertex v : reversePath) {
			st.push(v);
		}
		while (!st.isEmpty()) {
			path.add(st.pop());
		}
		return path;
	}

	private ArrayList<Vertex> getPath(Vertex dest) {
		ArrayList<Vertex> path = new ArrayList<Vertex>();
		path.add(dest);
		Vertex pre = dest.getPi();
		while (pre.getDistance() != 0) {
			path.add(pre);
			pre = pre.getPi();
		}
		path.add(pre);
		return path;
	}

	private Vertex getVertexByName(String name) {
		for (Vertex v : vertices) {
			if (v.getName().equals(name))
				return v;
		}
		return null;
	}

	private void dijkstra(Vertex start) {
		for (Vertex v : vertices) {
			v.setDistance(Integer.MAX_VALUE); // = unendlich
		}
		start.setDistance(0);

		ArrayList<Vertex> S = new ArrayList<Vertex>();
		ArrayList<Vertex> Q = new ArrayList<Vertex>(vertices);

		while (Q.size() != 0) {
			Q = new ArrayList<Vertex>(Q);
			Vertex lowest = extractMin(Q);
			if (lowest != null) {
				S.add(lowest);

				ArrayList<Vertex> neighbors = getNeighbors(lowest);
				for (Vertex n : neighbors) {
					if (n.getDistance() > lowest.getDistance() + getEdge(lowest, n).getWeight()) {
						n.setDistance(lowest.getDistance() + getEdge(lowest, n).getWeight());
						n.setPi(lowest);
					}
				}
			}
		}
	}

	private Edge getEdge(Vertex source, Vertex dest) {
		for (Edge e : edges) {
			if (e.getSource() == source && e.getDest() == dest)
				return e;
		}
		return null;
	}

	private ArrayList<Vertex> getNeighbors(Vertex vertex) {
		ArrayList<Vertex> result = new ArrayList<Vertex>();
		for (Edge e : edges) {
			if (e.getSource() == vertex)
				result.add(e.getDest());
		}
		return result;
	}

	private Vertex extractMin(ArrayList<Vertex> listOfVertices) {
		int minSoFar = Integer.MAX_VALUE;
		int indexToDelete = -1;
		for (Vertex v : listOfVertices) {
			if (v.getDistance() <= minSoFar) {
				minSoFar = v.getDistance();
				indexToDelete = listOfVertices.indexOf(v);
			}
		}

		if (indexToDelete != -1) {
			Vertex found = listOfVertices.get(indexToDelete);
			listOfVertices.remove(indexToDelete);
			return found;
		} else {
			return null;
		}
	}

	private void init() throws IOException {
		BufferedReader brEdges = new BufferedReader(new FileReader("bvg.txt"));
		BufferedReader brVertices = new BufferedReader(new FileReader("stations.txt"));

		while (brVertices.ready()) {
			String line = brVertices.readLine();
			String[] lineSplit = line.split(", ");
			Vertex station = new Vertex(lineSplit[0], lineSplit[1]);
			vertices.add(station);
		}

		while (brEdges.ready()) {
			String line = brEdges.readLine();
			String[] lineSplit = line.split(" ");
			String sourceStationString = lineSplit[0];
			Vertex sourceStation = getVertex(sourceStationString);
			for (int i = 1; i < lineSplit.length; i++) {
				String pair = lineSplit[i];
				String[] pairArray = pair.split(",");

//				String[] pairArray = lineSplit[i].split(",");
				Vertex destStation = getVertex(pairArray[0]);
				int weight = Integer.parseInt(pairArray[1]);
				Edge route = new Edge(sourceStation, destStation, weight);
				edges.add(route);
			}
		}
	}

	private Vertex getVertex(String id) {
		for (Vertex v : vertices) {
			if (v.getStationId().equals(id)) {
				return v;
			}
		}
		return null;
	}

}
