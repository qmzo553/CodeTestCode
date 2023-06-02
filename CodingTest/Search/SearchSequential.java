package Search;

import java.util.*;
import java.io.*;

public class SearchSequential {

	public static int sequantialSearch(int n, String target, String[] arr) {
		
		for(int i = 0; i < n; i++) {
			
			System.out.println(arr[i]);
			
			if(arr[i].equals(target)) {
				
				return i + 1;
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("생성할 원소 개수를 입력한 다음 한 칸 띄고 찾을 문자열을 입력하세요.");
		
		int n = Integer.parseInt(br.readLine());
		String target = br.readLine();
		
		System.out.println("앞서 적은 원소 개수만큼 문자열을 입력하세요. 구분은 띄어쓰기 한 칸으로 합니다.");
		String[] arr = new String[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			
			arr[i] = st.nextToken();
		}
		
		System.out.println(sequantialSearch(n, target, arr));

	}

}
