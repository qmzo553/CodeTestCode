package RealizeQ;

import java.util.*;
import java.io.*;

class Node {
	
	private int time;
	private char direction;
	
	public Node(int time, char dierection) {
		
		this.time = time;
		this.direction = direction;
	}
	
	public int getTime() {
		
		return this.time;
	}
	
	public char getDirection() {
		
		return this.direction;
	}
}

class Position {
	
	private int x;
	private int y;
	
	public Position(int x, int y) {
		
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

public class RealizeQSnake {
	
	private static int N, K, L;
	private static int[] dx = {0, 1, 0, -1};
	private static int[] dy = {1, 0, -1, 0};
	private static int[][] map = new int[101][101];
	private static ArrayList<Node> info = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < K; i++) {
			
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			map[a][b] = 1;
		}
		
		L = Integer.parseInt(br.readLine());
		for(int i = 0; i < L; i++) {
			
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			char c = st.nextToken().charAt(0);
			info.add(new Node(x, c));
		}
		
		System.out.println(simulate());
	}
	
	public static int simulate() {
		
		int x = 1, y = 1;
		map[x][y] = 2;
		int direction = 0;
		int time = 0;
		int index = 0;
		
		Queue<Position> q = new LinkedList<>();
		q.offer(new Position(x, y));
		
		while(true) {
			
			int nx = x + dx[direction];
			int ny = y + dy[direction];
			
			if(nx >= 1 && ny >= 1 && nx <= N && ny <= N && map[nx][ny] != 2) {
				
				if(map[nx][ny] == 0) {
					
					map[nx][ny] = 2;
					q.offer(new Position(nx, ny));
					Position prev = q.poll();
					map[prev.getX()][prev.getY()] = 0;
				}
				
				if(map[nx][ny] == 1) {
					
					map[nx][ny] = 2;
					q.offer(new Position(nx, ny));
				}
			} else {
				
				time += 1;
				break;
			}
			
			x = nx;
			y = ny;
			time += 1;
			
			if(index < 1 && time == info.get(index).getTime()) {
				
				direction = turn(direction, info.get(index).getDirection());
				index += 1;
			}
		}
		
		return time;
	}
	
	public static int turn(int direction, char c) {
		
		if(c == 'L') direction = (direction == 0) ? 3 : direction - 1;
		else direction  = (direction + 1) % 4;
		return direction;
	}
}
