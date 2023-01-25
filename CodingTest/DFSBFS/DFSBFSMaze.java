package DFSBFS;

import java.util.*;

class Node2 {
	
	private int x;
	private int y;
	
	public Node2(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
}

public class DFSBFSMaze {
	
	public static int n,m;
	public static int[][] graph = new int[201][201];
	
	public static int dx[] = {-1, 1, 0, 0};
	public static int dy[] = {0, 0, -1, 1};
	
	public static int bfs(int x, int y) {
		Queue<Node2> q = new LinkedList<>();
		q.offer(new Node2(x, y));
		
		while(!q.isEmpty()) {
			Node2 node = q.poll();
			x = node.getX();
			y = node.getY();
			
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
				
				if(graph[nx][ny] == 0) continue;
				
				if(graph[nx][ny] == 1) {
					graph[nx][ny] = graph[x][y] + 1;
					q.offer(new Node2(nx, ny));
				}
			}
		}
		return graph[n - 1][m - 1];
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		sc.nextLine();
		
		for(int i = 0; i < n; i++) {
			String str = sc.nextLine();
			for(int j = 0; j < m; j++) {
				graph[i][j] = str.charAt(j) - '0';
			}
		}
		System.out.println(bfs(0, 0));
	}

}
