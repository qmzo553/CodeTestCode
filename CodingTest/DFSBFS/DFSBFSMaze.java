package DFSBFS;

import java.util.*;
import java.io.*;

class Node2 {
	
	int x, y;
	
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
	
	public static int N, M;
	public static int[][] map;
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = { 0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			
			String str = br.readLine();
			for(int j = 0; j < M; j++) {
				
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		System.out.println(bfs(0, 0));
	}
	
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
				
				if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
				
				if(map[nx][ny] == 0) continue;
				
				if(map[nx][ny] == 1) {
					
					map[nx][ny] = map[x][y] + 1;
					q.offer(new Node2(nx, ny));
				}
			}
		}
		
		return map[N - 1][M - 1];
	}

}
