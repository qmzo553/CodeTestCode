package Graph;

import java.util.*;
import java.io.*;

public class GraphTopology {
	
	public static int v, e;
	public static int[] indegree = new int[100001];
	public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i <= v; i++) {
			
			graph.add(new ArrayList<Integer>());
		}
		
		for(int i = 0; i < e; i++) {
			
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph.get(a).add(b);
			indegree[b] += 1;
		}
		
		topologySort();
	}
	
	public static void topologySort() {
		
		ArrayList<Integer> result = new ArrayList<>();
		Queue<Integer> q = new LinkedList<>();
		
		for(int i = 1; i <= v; i++) {
			
			if(indegree[i] == 0) {
				
				q.offer(i);
			}
		}
		
		while(!q.isEmpty()) {
			
			int now = q.poll();
			result.add(now);
			
			for(int i = 0; i < graph.get(now).size(); i++) {
				
				indegree[graph.get(now).get(i)] -= 1;
				
				if(indegree[graph.get(now).get(i)] == 0) {
					
					q.offer(graph.get(now).get(i));
				}
			}
		}
		
		for(int i = 0; i < result.size(); i++) {
			
			System.out.print(result.get(i) + " ");
		}
	}

}
