package GraphQ;

import java.util.*;
import java.io.*;

class Edge1 implements Comparable<Edge1> {
	
	private int distance;
	private int nodeA;
	private int nodeB;
	
	public Edge1(int distance, int nodeA, int nodeB) {
		
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
	public int compareTo(Edge1 o) {
		
		if(this.distance < o.distance) {
			
			return -1;
		}
		
		return 1;
	}
}

class Position implements Comparable<Position> {
	
	private int x;
	private int y;
	
	public Position(int x, int y) {
		
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		
		return this.x;
	}
	
	public int getY() {
		
		return this.y;
	}
	
	@Override
	public int compareTo(Position o) {
		
		if(this.x == o.x) {
			
			return Integer.compare(this.y , o.y);
		}
		
		return Integer.compare(this.x , o.x);
	}
}

public class Q44 {
	
	public static int n;
	public static int[] parent = new int[100001];
	public static ArrayList<Edge1> edges = new ArrayList<>();
	public static int result = 0;
	
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		for(int i = 1; i <= n; i++) {
			
			parent[i] = i;
		}
		
		ArrayList<Position> x = new ArrayList<Position>();
		ArrayList<Position> y = new ArrayList<Position>();
		ArrayList<Position> z = new ArrayList<Position>();

		for(int i = 1; i <= n; i++) {
			
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			x.add(new Position(a, i));
			y.add(new Position(b, i));
			z.add(new Position(c, i));
		}
		
		Collections.sort(x);
		Collections.sort(y);
		Collections.sort(z);
		
		for(int i = 0; i < n - 1; i++) {
			
			edges.add(new Edge1(x.get(i + 1).getX() - x.get(i).getX(), x.get(i).getY(), x.get(i + 1).getY()));
            edges.add(new Edge1(y.get(i + 1).getX() - y.get(i).getX(), y.get(i).getY(), y.get(i + 1).getY()));
            edges.add(new Edge1(z.get(i + 1).getX() - z.get(i).getX(), z.get(i).getY(), z.get(i + 1).getY()));
		}
		
		Collections.sort(edges);
		
		for(int i = 0; i < edges.size(); i++) {
			
			int cost = edges.get(i).getDistance();
			int a = edges.get(i).getNodeA();
			int b = edges.get(i).getNodeB();
			
			if(findParent(a) != findParent(b)) {
				
				unionParent(a, b);
				result += cost;
			}
		}
		
        System.out.println(result);
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
