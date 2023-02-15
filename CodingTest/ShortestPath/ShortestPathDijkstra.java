package ShortestPath;

import java.util.*;

class Node{
	private int index;
	private int distance;
	
	public Node(int index, int distance) {
		this.index = index;
		this.distance = distance;
	}
	
	public int getIndex() {
		return this.index;
	}
	
	public int getDistance() {
		return this.distance;
	}
}

public class ShortestPathDijkstra {
	
	public static final int INF = (int) 1e9;
	public static int n, m, start;
	public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
	public static boolean[] visited = new boolean[100001];
	public static int[] d = new int[100001];
	
	public static int getSmallestNode() {
		int min_value  = INF;
		int index = 0;
		for(int i = 1; i <= n; i++) {
			if(d[i] < min_value && !visited[i]) {
				min_value = d[i];
				index = i;
			}
		}
		
		return index;
	}
	
	public static void dijkstra(int start) {
		d[start] = 0;
		visited[start] = true;
		for(int j = 0; j < graph.get(start).size(); j++) {
			d[graph.get(start).get(j).getIndex()] = graph.get(start).get(j).getDistance();
		}
		
		for(int i = 0; i < n - 1; i ++) {
			int now = getSmallestNode();
			visited[now] = true;
			
			for(int j = 0; j < graph.get(now).size(); j++) {
				int cost = d[now] + graph.get(now).get(j).getDistance();
				if(cost < d[graph.get(now).get(j).getIndex()]) {
					d[graph.get(now).get(j).getIndex()] = cost;
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		start = sc.nextInt();
		
		for(int  i = 0; i <= n; i++) {
			graph.add(new ArrayList<Node>());
		}
		
		for(int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			graph.get(a).add(new Node(b,c));
		}
		
		Arrays.fill(d, INF);
		
		dijkstra(start);
		
		for(int i = 1; i <= n; i++) {
			if(d[i] == INF) {
				System.out.println("INFINITY");
			} else {
				System.out.println(d[i]);
			}
		}

	}

}
