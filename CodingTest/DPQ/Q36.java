package DPQ;

import java.util.*;

public class Q36 {
	
	static String str1;
	static String str2;
	
	static int editDist(String str1, String str2) {
		int n = str1.length();
		int m = str2.length();
		
		int[][] dp = new int[n + 1][m + 1];
		
		for(int i = 1; i <= n; i++) {
			dp[i][0] = i;
		}
		
		for(int j = 1; j<= m; j++) {
			dp[0][j] = j;
		}
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= m; j++) {
				if(str1.charAt(i - 1) == str2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					dp[i][j] = 1 + Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1]));
				}
			}
		}
		
		return dp[n][m];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String str1 = sc.next();
		String str2 = sc.next();
		
		System.out.println(editDist(str1, str2));
	}

}
