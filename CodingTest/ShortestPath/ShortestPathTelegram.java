package ShortestPath;

import java.util.*;
import java.io.*;

class Node3 implements Comparable<Node3> {
	
	private int index, distance;
	
	public Node3(int index, int distance) {
		
		this.index = index;
		this.distance = distance;
	}
	
	public int getIndex() {
		
		return this.index;
	}
	
	public int getDistance() {
		
		return this.distance;
	}
	
	@Override
	public int compareTo(Node3 o) {
		
		if(this.distance < o.distance) return -1;
		
		return 1;
	}
}

public class ShortestPathTelegram {
	
	public static int N, M, C;
	public static final int INF = (int) 1e9;
	public static ArrayList<ArrayList<Node3>> graph = new ArrayList<ArrayList<Node3>>();
	public static int[] d = new int[30001];
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i <= N; i++) {
			
			graph.add(new ArrayList<Node3>());
		}
		
		for(int i = 0; i < M; i++) {
			
			st = new StringTokenizer(br.readLine());
			
			int X = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());
			int Z = Integer.parseInt(st.nextToken());
			
			graph.get(X).add(new Node3(Y, Z));
		}
		
		Arrays.fill(d, INF);
		
		dijkstra(C);
		
		int count = 0;
		int max = 0;
		
		for(int i = 1; i <= N; i++) {
			
			if(d[i] != INF) {
				
				count++;
				max = Math.max(max, d[i]);
			}
		}
		
		System.out.println((count - 1) + " " + max);
		
	}
	
	public static void dijkstra(int start) {
		
		PriorityQueue<Node3> pq = new PriorityQueue<>();
		
		pq.offer(new Node3(start, 0));
		d[start] = 0;
		
		while(!pq.isEmpty()) {
			
			Node3 node = pq.poll();
			int dist = node.getDistance();
			int now = node.getIndex();
			
			if(d[now] < dist) continue;
			
			for(int i = 0; i < graph.get(now).size(); i++) {
				
				int cost = d[now] + graph.get(now).get(i).getDistance();
				
				if(cost < d[graph.get(now).get(i).getIndex()]) {
					
					d[graph.get(now).get(i).getIndex()] = cost;
					pq.offer(new Node3(graph.get(now).get(i).getIndex(), cost));
				}
			}
		}
	}

}
