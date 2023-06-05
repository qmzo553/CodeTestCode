package ShortedPathQ;

import java.util.*;
import java.io.*;

class Node1 implements Comparable<Node1> {
	
	private int index, distance;
	
	public Node1(int index, int distance) {
		
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
	public int compareTo(Node1 o) {
		
		if(this.distance < o.distance) return -1;
		
		return 1;
	}
}

public class Q40 {
	
	public static final int INF = (int) 1e9;
	public static int N, M;
	public static int start = 1;
	public static ArrayList<ArrayList<Node1>> graph = new ArrayList<ArrayList<Node1>>();
	public static int[] d = new int[20001];
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i <= N; i++) {
			
			graph.add(new ArrayList<Node1>());
		}
		
		for(int i = 0; i < M; i++) {
			
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph.get(a).add(new Node1(b, 1));
			graph.get(b).add(new Node1(a, 1));
		}
		
		Arrays.fill(d, INF);
		
		dijkstra(start);
		
		int maxNode = 0;
		int maxDistance = 0;
		
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		for(int i = 1; i <= N; i++) {
			
			if(maxDistance < d[i]) {
				
				maxNode = i;
				maxDistance = d[i];
				result.clear();
				result.add(maxNode);
			} else if(maxDistance == d[i]) {
				
				result.add(i);
			}
		}
		
		System.out.println(maxNode + " " + maxDistance + " " + result.size());
	}
	
	public static void dijkstra(int start) {
		
		PriorityQueue<Node1> pq = new PriorityQueue<>();
		
		pq.offer(new Node1(start, 0));
		d[start] = 0;
		
		while(!pq.isEmpty()) {
			
			Node1 node = pq.poll();
			int dist = node.getDistance();
			int now = node.getIndex();
			
			if(d[now] < dist) continue;
			
			for(int i = 0; i < graph.get(now).size(); i++) {
				
				int cost  = d[now] + graph.get(now).get(i).getDistance();
				
				if(cost < d[graph.get(now).get(i).getIndex()]) {
					
					d[graph.get(now).get(i).getIndex()] = cost;
					pq.offer(new Node1(graph.get(now).get(i).getIndex(), cost));
				}
			}
		}
	}
}
