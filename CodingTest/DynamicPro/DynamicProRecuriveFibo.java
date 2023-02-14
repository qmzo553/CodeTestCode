package DynamicPro;

public class DynamicProRecuriveFibo {
	
	public static long[] d = new long[100];
	
	public static long fibo2(int x) {
		if(x == 1 || x == 2) {
			return 1;
		}
		
		if(d[x] != 0) {
			return d[x];
		}
		
		d[x] = fibo2(x - 1) + fibo2(x - 2);
		return d[x];
	}
	
	public static void main(String[] args) {
		System.out.println(fibo2(50));

	}

}
