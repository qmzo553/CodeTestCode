package DFSBFSQ;

import java.util.*;
import java.io.*;

public class City {
	
	public static int N, M, K, X;
	public static ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
	public static int[] d = new int[300001];
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i <= N; i++) {
			
			list.add(new ArrayList<Integer>());
			d[i] = -1;
		}
		
		for(int i = 0; i < M; i++) {
			
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list.get(a).add(b);
		}
		
		d[X] = 0;
		
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(X);
		
		while(!q.isEmpty()) {
			
			int now = q.poll();
			
			for(int i = 0; i < list.get(now).size(); i++) {
				
				int nextNode = list.get(now).get(i);
				
				if(d[nextNode] == -1) {
					
					d[nextNode] = d[now] + 1;
					q.offer(nextNode);
				}
			}
		}
		
		boolean check = false;
		for(int i = 1; i <= N; i++) {
			
			if(d[i] == K) {
				
				System.out.println(i);
				check = true;
			}
		}
		
		if(!check) System.out.println(-1);
	}

}
