package Graph;

import java.util.*;
import java.io.*;

public class GraphCurriculum {
	
	public static int v;
	public static int[] indegree = new int[501];
	public static int[] times = new int[501];
	public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		v = Integer.parseInt(br.readLine());
		
		for(int i = 0; i <= v; i++) {
			
			graph.add(new ArrayList<Integer>());
		}
		
		for(int i = 1; i <= v; i++) {
			
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			times[i] = x;
			
			while(true) {
				
				x = Integer.parseInt(st.nextToken());
				if(x == -1) break;
				indegree[i] += 1;
				graph.get(x).add(i);
			}
		}
		
		topologySort();
	}
	
	public static void topologySort() {
		
		int[] result = new int[501];
		for(int i = 1; i <= v; i++) {
			
			result[i] = times[i];
		}
		
		Queue<Integer> q = new LinkedList<>();
		
		for(int i = 1; i <= v; i++) {
			
			if(indegree[i] == 0) {
				
				q.offer(i);
			}
		}
		
		while(!q.isEmpty()) {
			
			int now = q.poll();
			
			for(int i = 0; i < graph.get(now).size(); i++) {
				
				result[graph.get(now).get(i)] = Math.max(result[graph.get(now).get(i)],
						result[now] + times[graph.get(now).get(i)]);
				indegree[graph.get(now).get(i)] -= 1;
				if(indegree[graph.get(now).get(i)] == 0) {
					
					q.offer(graph.get(now).get(i));
				}
			}
		}
		
		for(int i = 1; i <= v; i++) {
			
			System.out.println(result[i]);
		}
	}

}
