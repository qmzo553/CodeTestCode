package Greedy;

public class GreedyMoney {

	public static void main(String[] args) {
		
		int n = 1200;
		int cnt = 0;
		int[] coin = {500, 100, 50, 10};
		
		for(int i = 0; i < 4; i++) {
			
			int ans = coin[i];
			cnt += n / ans;
			n %= ans;
		}
		
		System.out.println(cnt);
	}

}
