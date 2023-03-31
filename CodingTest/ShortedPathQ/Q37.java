package ShortedPathQ;

import java.util.*;

public class Q37 {
	
	private static final int INF = (int) 1e9;
	private static int n, m, a, b, c;
	private static int[][] graph = new int[101][101];
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		// 최단 거리 테이블을 모두 무한으로 초기화
		for(int i = 0; i < 101; i++) {
			Arrays.fill(graph[i], INF);
		}
			
		// 자기 자신에서 자기 자신으로 가는 비용은 0으로 초기화
		for(int a = 0; a < 101; a++) {
			for(int b = 0; b < 101; b++) {
				
				if(a == b) {
					graph[a][b] = 0;
				}
			}
		}
		
		// 각 간선에 대한 정보를 입력 받아, 그 값으로 초기화
		for(int i = 0; i < m; i++) {
			a = sc.nextInt();
			b = sc.nextInt();
			c = sc.nextInt();
			
			if(c < graph[a][b]) graph[a][b] = c;
		}
		
		// 점화식에 따라 플로이드 워셜 알고리즘을 수행
		for (int k = 1; k <= n; k++) {
            for (int a = 1; a <= n; a++) {
                for (int b = 1; b <= n; b++) {
                    graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
                }
            }
        }
		
		// 수행된 결과를 출력
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				
				if(graph[i][j] == INF) {
					System.out.print(0 + " ");
				} else {
					System.out.print(graph[i][j] + " ");
				}
			}
			
			System.out.println();
		}
	}

}
