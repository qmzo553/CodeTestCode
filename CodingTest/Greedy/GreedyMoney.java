package Greedy;

public class GreedyMoney {
	
	private static int N, count;
	private static int[] coins = {500, 100, 50, 10};
	
	public static void main(String[] args) {
		
		N = 1260;
		count = 0;
		
		for(int i = 0; i < 4; i++) {
			
			count += N / coins[i];
			N %= coins[i];
		}
		
		System.out.println(count);
		
	}

}
