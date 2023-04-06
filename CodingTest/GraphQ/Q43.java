package GraphQ;

import java.util.*;

class Edge implements Comparable<Edge> {
	
	private int distance;
	private int nodeA;
	private int nodeB;
	
	public Edge(int distance, int nodeA, int nodeB) {
		
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
	public int compareTo(Edge other) {
		
		if(this.distance < other.distance) {
			
			return -1;
		}
		
		return 1;
	}
}
public class Q43 {
	
	public static int n, m;
	public static int[] parent = new int[200001];
	public static ArrayList<Edge> edges = new ArrayList<>();
	public static int result = 0;
	
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
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		for(int i = 1; i <= n; i++) {
			
			parent[i] = i;
		}
		
		for(int i = 0; i < m; i++) {
			
			int x = sc.nextInt();
			int y = sc.nextInt();
			int z = sc.nextInt();
			edges.add(new Edge(z, x, y));
		}
		
		Collections.sort(edges);
		
		int total = 0;
		
		for(int i = 0; i < edges.size(); i++) {
			
			int cost = edges.get(i).getDistance();
			int a = edges.get(i).getNodeA();
			int b = edges.get(i).getNodeB();
			total += cost;
			
			if(findParent(a) != findParent(b)) {
				
				unionParent(a, b);
				result += cost;
			}
		}
		
		System.out.println(total - result);
	}

}
