package Sorting;

import java.util.*;
import java.io.*;

class Student implements Comparable<Student> {
	
	String name;
	int score;
	
	public Student(String name, int score) {
		
		this.name = name;
		this.score = score;
	}
	
	public String getName() {
		
		return this.name;
	}
	
	public int getScore() {
		
		return this.score;
	}
	
	@Override
	public int compareTo(Student o) {
		
		if(this.score > o.score) return 1;
		else return -1;
	}
}

public class SortingStudent {
	
	public static int N, score;
	public static String str;
	public static ArrayList<Student> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		
		for(int i = 0; i < N; i++) {
			
			st = new StringTokenizer(br.readLine());
			str = st.nextToken();
			score = Integer.parseInt(st.nextToken());
			
			list.add(new Student(str, score));
		}
		
		Collections.sort(list);
		
		for(int i = 0; i < list.size(); i++) {
			
			System.out.print(list.get(i).getName() + " ");
		}
	}

}
