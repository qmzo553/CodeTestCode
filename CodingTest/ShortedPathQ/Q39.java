package ShortedPathQ;

import java.util.*;
import java.io.*;

class Node implements Comparable<Node> {
	
	private int x, y, distance;
	
	public Node(int x, int y, int distance) {
		
		this.x = x;
		this.y = y;
		this.distance = distance;
	}
	
	public int getX() {
		
		return this.x;
	}
	
	public int getY() {
		
		return this.y;
	}
	
	public int getDistance() {
		
		return this.distance;
	}
	
	@Override
	public int compareTo(Node o) {
		
		if(this.distance < o.distance) return -1;
		
		return 1;
	}
}
public class Q39 {
	
	public static int T, N;
	public static final int INF = (int) 1e9;
	public static int[][] graph = new int[125][125];
	public static int[][] d = new int[125][125];
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
		while(T-- > 0) {
			
			N = Integer.parseInt(br.readLine());
			
			for(int i = 0; i < N; i++) {
				
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					
					graph[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i = 0; i < N; i++) {
				
				Arrays.fill(d[i], INF);
			}
			
			int x = 0, y = 0;
			
			PriorityQueue<Node> pq = new PriorityQueue<>();
			pq.offer(new Node(0, 0, graph[x][y]));
			d[x][y] = graph[x][y];
			
			while(!pq.isEmpty()) {
				
				Node node = pq.poll();
				int dist = node.getDistance();
				x = node.getX();
				y = node.getY();
				
				if(d[x][y] < dist) continue;
				
				for(int i = 0; i < 4; i++) {
					
					int nx = x + dx[i];
					int ny = y + dy[i];
					
					if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
					
					int cost = dist + graph[nx][ny];
					
					if(cost < d[nx][ny]) {
						
						d[nx][ny] = cost;
						pq.offer(new Node(nx, ny, cost));
					}
				}
			}
			
			sb.append(d[N - 1][N - 1]).append('\n');
		}
		
		System.out.println(sb);
	}
}
