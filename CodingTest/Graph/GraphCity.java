package Graph;

import java.util.*;
import java.io.*;

class Edge2 implements Comparable<Edge2> {
	
	private int distance;
	private int nodeA;
	private int nodeB;
	
	public Edge2(int distance, int nodeA, int nodeB) {
		
		this.distance = distance;
		this.nodeA = nodeA;
		this.nodeB = nodeB;
	}
	
	public int getDistance() {
		
		return this.distance;
	}
	
	public int getNodeA() {
		
		return this.nodeA;
	}
	
	public int getNodeB() {
		
		return this.nodeB;
	}
	
	@Override
	public int compareTo(Edge2 other) {
		
		if(this.distance < other.distance) {
			return -1;
		}
		return 1;
	}
}

public class GraphCity {
	
	public static int v, e;
	public static int[] parent = new int[100001];
	public static ArrayList<Edge2> edges = new ArrayList<>();
	public static int result = 0;

	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		
		for(int i = 1; i <= v; i++) {
			
			parent[i] = i;
		}
		
		for(int i = 0; i < e; i++) {
			
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			edges.add(new Edge2(cost, a, b));
		}
		
		Collections.sort(edges);
		int last = 0;
		
		for(int i = 0; i < edges.size(); i++) {
			
			int cost = edges.get(i).getDistance();
			int a = edges.get(i).getNodeA();
			int b = edges.get(i).getNodeB();
			
			if(findParent(a) != findParent(b)) {
				
				unionParent(a, b);
				result += cost;
				last = cost;
			}
		}
		
		System.out.println(result - last);

	}
	
	public static int findParent(int x) {
		
		if(x == parent[x]) return x;
		return parent[x] = findParent(parent[x]);
	}
	
	public static void unionParent(int a, int b) {
		
		a = findParent(a);
		b = findParent(b);
		if(a < b) parent[b] = a;
		else parent[a] = b;
	}

}
