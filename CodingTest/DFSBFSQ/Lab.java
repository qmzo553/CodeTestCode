package DFSBFSQ;

import java.util.*;
import java.io.*;

public class Lab {
	
	public static int n, m, result;
	public static int[][] arr = new int[8][8];
	public static int[][] temp = new int[8][8];
	public static int[] dx = {-1, 0, 1, 0};
	public static int[] dy = {0, -1, 0, 1};
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		for(int i = 0; i < n; i++) {
			
			for(int j = 0; j < m; j++) {
				
				arr[i][j] = sc.nextInt();
			}
		}
		
		dfs(0);
		
		System.out.println(result);
	}
	
	public static void virus(int x, int y) {
		
		for(int i = 0; i < 4; i++) {
			
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx >= 0 && nx < n && ny >= 0 && ny < m) {
				
				if(temp[nx][ny] == 0) {
					
					temp[nx][ny] = 2;
					virus(nx, ny);
				}
			}
		}
	}
	
	public static int getScore() {
		
		int score = 0;
		for(int i = 0; i < n; i++) {
			
			for(int j = 0; j < m; j++) {
				
				if(temp[i][j] == 0) {
					
					score += 1;
				}
			}
		}
		
		return score;
	}
	
	public static void dfs(int count) {
		
		if(count == 3) {
			
			for(int i = 0; i < n; i++) {
				
				for(int j = 0; j < m; j++) {
					
					temp[i][j] = arr[i][j];
				}
			}
			
			for(int i = 0; i < n; i++) {
				
				for(int j = 0; j < m; j++) {
					
					if(temp[i][j] == 2) {
						
						virus(i, j);
					}
				}
			}
			
			result = Math.max(result, getScore());
		}
		
		for(int i = 0; i < n; i++) {
			
			for(int j = 0; j < m; j++) {
				
				if(arr[i][j] == 0) {
					
					arr[i][j] = 1;
					count += 1;
					dfs(count);
					arr[i][j] = 0;
					count -= 1;
				}
			}
		}
	}
}
