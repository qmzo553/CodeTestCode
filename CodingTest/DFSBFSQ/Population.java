package DFSBFSQ;

import java.util.*;
import java.io.*;

class Position2 {
	
	int x, y;
	
	public Position2(int x, int y) {
		
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

public class Population {
	
	public static int N, L, R;
	public static int totalCount = 0;
	public static int[][] map = new int[50][50];
	public static int[][] unions = new int[50][50];
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < N; i++) {
			
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				
				map[i][j] = Integer.parseInt(st.nextToken()); 
			}
		}
		
		while(true) {
			
			for(int i = 0; i < N; i++) {
				
				for(int j = 0; j < N; j++) {
					
					unions[i][j] = -1;
				}
			}
			
			int index = 0;
			
			for(int i = 0; i < N; i++) {
				
				for(int j = 0; j < N; j++) {
					
					if(unions[i][j] == -1) {
						
						process(i, j, index);
						index += 1;
					}
				}
			}
			
			if(index == N * N) break;
			totalCount += 1;
		}
		
		System.out.println(totalCount);
	}
	
	public static void process(int x, int y, int index) {
		
		ArrayList<Position2> united = new ArrayList<>();
		united.add(new Position2(x, y));
		
		Queue<Position2> q = new LinkedList<>();
		q.offer(new Position2(x, y));
		unions[x][y] = index;
		
		int summary = map[x][y];
		int count = 1;
		
		while(!q.isEmpty()) {
			
			Position2 pos = q.poll();
			
			x = pos.getX();
			y = pos.getY();
			
			for(int i = 0; i < 4; i++) {
				
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx >= 0 && ny >= 0 && nx < N && ny < N && unions[nx][ny] == -1) {
					
					int gap = Math.abs(map[nx][ny] - map[x][y]);
					if(gap >= L && gap <= R) {
						
						q.offer(new Position2(nx, ny));
						
						unions[nx][ny] = index;
						summary += map[nx][ny];
						count += 1;
						united.add(new Position2(nx, ny));
					}
				}
			}
		}
		
		for(int i = 0; i < united.size(); i++) {
			
			x = united.get(i).getX();
			y = united.get(i).getY();
			map[x][y] = summary / count;
		}
	}

}
