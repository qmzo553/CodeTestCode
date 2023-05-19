package DFSBFSQ;

import java.util.*;
import java.io.*;

class Virus implements Comparable<Virus> {
	
	int index, second, x, y;
	
	public Virus(int index, int second, int x, int y) {
		
		this.index = index;
		this.second = second;
		this.x = x;
		this.y = y;
	}
	
	public int getIndex() {
		
		return this.index;
	}
	
	public int getSecond() {
		
		return this.second;
	}
	
	public int getX() {
		
		return this.x;
	}
	
	public int getY() {
		
		return this.y;
	}
	
	@Override
	public int compareTo(Virus o) {
		
		if(this.index < o.index) return -1;
		return 1;
	}
}

public class Infection {
	
	public static int N, K, S, X, Y;
	public static int[][] map;
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	public static ArrayList<Virus> viruses = new ArrayList<Virus>();

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if(map[i][j] != 0) {
					
					viruses.add(new Virus(map[i][j], 0, i, j));
				}
			}
		}
		
		Collections.sort(viruses);
		Queue<Virus> q = new LinkedList<>();
		for(int i = 0; i < viruses.size(); i++) {
			
			q.offer(viruses.get(i));
		}
		
		st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		
		while(!q.isEmpty()) {
			
			Virus virus = q.poll();
			
			if(virus.getSecond() == S) break;
			
			for(int i = 0; i < 4; i++) {
				
				int nx = virus.getX() + dx[i];
				int ny = virus.getY() + dy[i];
				
				if(nx >= 0 && ny >= 0 && nx < N && ny < N) {
					
					if(map[nx][ny] == 0) {
						
						map[nx][ny] = virus.getIndex();
						q.offer(new Virus(virus.getIndex(), virus.getSecond() + 1, nx, ny));
					}
				}
			}
		}
		
		System.out.println(map[X - 1][Y - 1]);
		
	}

}
