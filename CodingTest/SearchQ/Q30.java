package SearchQ;

import java.util.*;
import java.io.*;

public class Q30 {
	
	public static int N, M;
	public static String[] words, queries;
	public static ArrayList<ArrayList<String>> arr = new ArrayList<ArrayList<String>>();
	public static ArrayList<ArrayList<String>> reverseArr = new ArrayList<ArrayList<String>>();
	public static ArrayList<Integer> ans = new ArrayList<Integer>();

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		words = new String[N];
		queries = new String[M];
		
		for(int i = 0; i < 10001; i++) {
			
			arr.add(new ArrayList<String>());
			reverseArr.add(new ArrayList<String>());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			
			words[i] = st.nextToken();
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			
			queries[i] = st.nextToken();
		}
		
		for(int i = 0; i < N; i++) {
			
			String word = words[i];
			arr.get(word.length()).add(word);
			word = (new StringBuffer(word)).reverse().toString();
			reverseArr.get(word.length()).add(word);
		}
		
		for(int i = 0; i < 10001; i++) {
			
			Collections.sort(arr.get(i));
			Collections.sort(reverseArr.get(i));
		}
		
		for(int i = 0; i < M; i++) {
			
			String q = queries[i];
			int res = 0;
			if(q.charAt(0) != '?') {
				
				res = countByRange(arr.get(q.length()), q.replaceAll("\\?", "a"), q.replaceAll("\\?", "z"));
			} else {
				
				q = (new StringBuffer(q)).reverse().toString();
				res = countByRange(reverseArr.get(q.length()), q.replaceAll("\\?",  "a"), q.replaceAll("\\?",  "z"));
			}
			
			ans.add(res);
		}
		
		for(int i = 0; i < ans.size(); i++) {
			
			sb.append(ans.get(i)).append(' ');
		}
		
		System.out.println(sb);
	}
	
	public static int lowerBound(ArrayList<String> arr, String target, int start, int end) {
		
		while(start < end) {
			
			int mid = (start + end) / 2;
			
			if(arr.get(mid).compareTo(target) >= 0) end = mid;
			else start = mid + 1;
		}
		
		return end;
	}
	
	public static int upperBound(ArrayList<String> arr, String target, int start, int end) {
		
		while(start < end) {
			
			int mid = (start + end) / 2;
			
			if(arr.get(mid).compareTo(target) > 0) end = mid;
			else start = mid + 1;
		}
		
		return end;
	}
	
	public static int countByRange(ArrayList<String> arr, String leftValue, String rightValue) {
		
		int rightIndex = upperBound(arr, rightValue, 0, arr.size());
		int leftIndex = lowerBound(arr, leftValue, 0, arr.size());
		return rightIndex - leftIndex;
	}

}
