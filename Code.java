package misc;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;



public class main_misc2 {
	
	
		
		
	
	
	public static void main(String[] args) {
	//(a+b)%k = ((a % k)+(b % k)) % k    || ||
	
		towers_of_hanoi(7);
		
	}	
	
	private static void print_stacks(LinkedList<Integer> s1,LinkedList<Integer> s2,LinkedList<Integer> s3) {
		System.out.println("s1: "+s1);
		System.out.println("s2: " +s2);
		System.out.println("s3: "+s3);
	}
	
	private static void towers_of_hanoi(int n){
		
		LinkedList<Integer> s1 = new LinkedList<>();
		LinkedList<Integer> s2 = new LinkedList<>();
		LinkedList<Integer> s3 = new LinkedList<>();
		
		for(int i = 1;i <= n;i++) {
			s1.add(i);
		}
		System.out.println("s1: "+s1);
		System.out.println();
		f(n,1,3,s1,s2,s3);
		print_stacks(s1,s2,s3);
		
	}
	
	
	
	private static void f(int n,int a,int b,LinkedList<Integer> s1,LinkedList<Integer> s2,LinkedList<Integer> s3){
		
		//from stack a to stack b
		
		if(n == 0) {
			return;
		}
		if(n == 1) {
			if(a == 1 && !s1.isEmpty()) {
				if(b == 2) {
					s2.addFirst(s1.remove());
				}
				if(b == 3){
					s3.addFirst(s1.remove());
				}
			}
			if(a == 2 && !s2.isEmpty()) {
				if(b == 1) {
					s1.addFirst(s2.remove());
				}
				if(b == 3){
					s3.addFirst(s2.remove());
				}
			}
			if(a == 3 && !s3.isEmpty()) {
				if(b == 1) {
					s1.addFirst(s3.remove());
				}
				if(b == 2){
					s2.addFirst(s3.remove());
				}
			}
			return;
		}
		
		if(a == 1){
			if(b == 2) {
				f(n-1,1,3,s1,s2,s3);//move 1,2,..,n-1 from s1 to s3
				
				if(!s1.isEmpty()) {
					s2.addFirst(s1.remove());//move n from s1 to s2
				}
				
				f(n-1,3,2,s1,s2,s3);//move 1,2,...,n-1 from s3 to s2
				
			}
			if(b == 3) {
				f(n-1,1,2,s1,s2,s3);//move 1,2,..,n-1 from s1 to s2
				
				if(!s1.isEmpty()) {
					s3.addFirst(s1.remove());//move n from s1 to s3
				}
				
				
				f(n-1,2,3,s1,s2,s3);//move 1,2,...,n-1 from s2 to s3
				
			}
		}
		if(a == 2){
			if(b == 1) {
				f(n-1,2,3,s1,s2,s3);//move 1,2,..,n-1 from s2 to s3
				
				if(!s2.isEmpty()) {
					s1.addFirst(s2.remove());//move n from s2 to s1
				}
				
				
				f(n-1,3,1,s1,s2,s3);//move 1,2,...,n-1 from s3 to s2
				
			}
			if(b == 3) {
				f(n-1,2,1,s1,s2,s3);//move 1,2,..,n-1 from s2 to s1
				
				if(!s2.isEmpty()) {
					s3.addFirst(s2.remove());//move n from s2 to s3
				}
				
				
				f(n-1,1,3,s1,s2,s3);//move 1,2,...,n-1 from s1 to s3
				
			}
		}
		if(a == 3){
			if(b == 1) {
				f(n-1,3,2,s1,s2,s3);//move 1,2,..,n-1 from s3 to s2
				
				if(!s3.isEmpty()) {
					s1.addFirst(s3.remove());//move n from s3 to s1
				}
				
				
				f(n-1,2,1,s1,s2,s3);//move 1,2,...,n-1 from s2 to s1
				
			}
			if(b == 2) {
				f(n-1,3,1,s1,s2,s3);//move 1,2,..,n-1 from s3 to s1
				
				if(!s3.isEmpty()) {
					s2.addFirst(s3.remove());//move n from s3 to s2
				}

				
				f(n-1,1,2,s1,s2,s3);//move 1,2,...,n-1 from s1 to s2
				
			}
		}
		
		
		
	}
	
	} 
	
