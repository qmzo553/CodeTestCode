package ShortestPath;

import java.util.*;
import java.io.*;

class Node {
	
	private int index, distance;
	
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

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(br.readLine());
		
		for(int i = 0; i <= n; i++) {
			
			graph.add(new ArrayList<Node>());
		}
		
		for(int i = 0; i < m; i++) {
			
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			graph.get(a).add(new Node(b, c));
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
	
	public static void dijkstra(int start) {
		
		d[start] = 0;
		visited[start] = true;
		
		for(int i = 0; i < graph.get(start).size(); i++) {
			
			d[graph.get(start).get(i).getIndex()] = graph.get(start).get(i).getDistance();
		}
		
		for(int i = 0; i < n; i++) {
			
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
	
	public static int getSmallestNode() {
		
		int min = INF;
		int index = 0;
		
		for(int i = 1; i <= n; i++) {
			
			if(d[i] < min && !visited[i]) {
				
				min = d[i];
				index = i;
			}
		}
		
		return index;
	}

}
