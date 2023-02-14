package Search;

import java.util.*;

public class SearchComponent {
	public static int binarySearch3(int[] arr, int target, int start, int end) {
		while(start <= end) {
			int mid = (start + end) / 2;
			if (arr[mid] == target) return mid;
			else if (arr[mid] > target) end = mid - 1;
			else start = mid + 1;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		int m = sc.nextInt();
		int[] targets = new int[m];
		for(int i = 0; i < m; i++) {
			targets[i] = sc.nextInt();
		}
		
		for(int i = 0; i < m; i++) {
			int result = binarySearch3(arr, targets[i], 0, n - 1);
			if(result != -1) {
				System.out.println("yes");
			} else {
				System.out.println("no ");
			}
		}

	}

}
