package SortingQ;

import java.util.*;
import java.io.*;

class Student implements Comparable<Student> {
	
	String name;
	int k, e, m;
	
	public Student(String name, int k, int e, int m) {
		
		this.name = name;
		this.k = k;
		this.e = e;
		this.m = m;
	}
	
	@Override
	public int compareTo(Student o) {
		
		if(this.k == o.k) {
			
			if(this.e == o.e) {
				
				if(this.m == o.m) {
					
					return this.name.compareTo(o.name); 
				}
				
				return Integer.compare(o.m, this.m);
			}
			
			return Integer.compare(this.e, o.e);
		}
		
		return Integer.compare(o.k, this.k);
	}
}

public class Q23 {
	
	public static int N, k, e, m;
	public static String name;
	public static ArrayList<Student> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			
			st = new StringTokenizer(br.readLine());
			name = st.nextToken();
			k = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			list.add(new Student(name, k, e, m));
		}
		
		Collections.sort(list);
		
		for(int i = 0; i < N; i++) {
			
			sb.append(list.get(i).name).append('\n');
		}
		
		System.out.println(sb);
	}

}
