package Realize;

import java.util.*;
import java.io.*;

class Person {
	
	int x, y, direction;
	
	Person(int x, int y, int direction) {
		
		this.x = x;
		this.y = y;
		this.direction = direction;
	}
}

public class RealizeGame {
	
	private static int N, M, count, turn;
	private static int x, y, direction;
	private static int[] dx = {-1, 0, 1, 0};
	private static int[] dy = {0, 1, 0, -1};
	private static int[][] map;
	private static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		
		st = new StringTokenizer(br.readLine());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		direction = Integer.parseInt(st.nextToken());
		Person p = new Person(x, y, direction);
		
		for(int i = 0; i < N; i++) {
			
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		count = 1;
		turn = 0;
		visited[x][y] = true;
		while(true) {
			
			p.direction--;
			
			if(p.direction == -1) p.direction = 3;
			
			int nx = p.x + dx[p.direction];
			int ny = p.y + dy[p.direction];
			
			if(!visited[nx][ny] && map[nx][ny] == 0) {
				
				visited[nx][ny] = true;
				p.x = nx;
				p.y = ny;
				count++;
				turn = 0;
				continue;
			}
			
			else turn++;
			
			if(turn == 4) {
				
				nx = p.x - dx[p.direction];
				ny = p.y - dy[p.direction];
				
				if(map[nx][ny] == 0) {
					
					p.x = nx;
					p.y = ny;
				}
				
				else break;
				
				turn = 0;
			}
		}
		
		
		System.out.println(count);
	}

}
