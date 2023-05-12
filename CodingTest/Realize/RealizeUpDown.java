package Realize;

import java.util.*;

public class RealizeUpDown {
	
	private static int N;
	private static String[] moves;
	private static char[] moveType = {'U', 'D', 'L', 'R'};
	private static int[] dx = {-1, 1, 0, 0};
	private static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		sc.nextLine();
		moves = sc.nextLine().split(" ");
		
		int x = 1;
		int y = 1;
		int nx = 0;
		int ny = 0;
		
		for(int i = 0; i < moves.length; i++) {
			
			char move  = moves[i].charAt(0);
			
			for(int j = 0; j < 4; j++) {
				
				if(move == moveType[j]) {
					
					nx = x + dx[j];
					ny = y + dy[j];
				}
			}
			
			if(nx < 1 || ny < 1 || nx > N || ny > N) continue;
			
			x = nx;
			y = ny;
		}
		
		System.out.println(nx + " " + ny);
	}

}
