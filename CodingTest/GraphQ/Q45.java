package GraphQ;

import java.util.*;
import java.io.*;

public class Q45 {
	
	public static int testCase, n, m;
	public static int[] indegree = new int[501];
	public static boolean[][] graph = new boolean[501][501];
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		testCase = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc < testCase; tc++) {
			
			Arrays.fill(indegree, 0);
			for(int i = 0; i < 501; i++) {
				
				Arrays.fill(graph[i], false);
			}
			
			n = Integer.parseInt(br.readLine());
			
			ArrayList<Integer> arrayList = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < n; i++) {
				
				int x = Integer.parseInt(st.nextToken());
				arrayList.add(x);
			}
			
			for(int i = 0; i < n; i++) {
				
				for(int j = i + 1; j < n; j++) {
					
					graph[arrayList.get(i)][arrayList.get(j)] = true;
					indegree[arrayList.get(j)] += 1;
				}
			}
			
			m = Integer.parseInt(br.readLine());
			for(int i = 0; i < m; i++) {
				
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(br.readLine());
				int b = Integer.parseInt(br.readLine());
				
				if(graph[a][b]) {
					
					graph[a][b] = false;
					graph[b][a] = true;
					indegree[a] += 1;
					indegree[b] -= 1;
				} else {
					
					graph[a][b] = true;
					graph[b][a] = false;
					indegree[a] -= 1;
					indegree[b] += 1;
				}
			}
			
			ArrayList<Integer> result = new ArrayList<>();
			Queue<Integer> q = new LinkedList<>();
			
			for(int i = 1; i <= arrayList.size(); i++) {
				
				if(indegree[i] == 0) q.offer(i);
			}
			
			boolean certain = true;
			boolean cycle = false;
			
			for(int i = 0; i < n; i++) {
				
				if(q.size() == 0) {
					
					cycle = true;
					break;
				}
				
				if(q.size() >= 2) {
					
					certain = false;
					break;
				}
				
				int now = q.poll();
				result.add(now);
				
				for(int j = 1; j <= n; j++) {
					
					if(graph[now][j]) {
						
						indegree[j] -= 1;
						
						if(indegree[j] == 0) q.offer(j);
					}
				}
			}
			
			if(cycle) System.out.println("IMPOSSIBLE");
			else if(!certain) System.out.println("?");
			else {
				
				for(int i = 0; i < result.size(); i++) {
					
					System.out.print(result.get(i) + " ");
				}
				
				System.out.println();
			}
		}
	}
}
