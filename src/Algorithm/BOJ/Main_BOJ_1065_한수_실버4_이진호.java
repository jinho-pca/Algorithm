package Algorithm.BOJ;

import java.util.Scanner;

public class Main_BOJ_1065_한수_실버4_이진호 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int count = 0;
		for(int i = 1; i <= N; i++) {
			if(1 <= i && i < 100) {
				count++;
			} else if(i == 1000) {
				break;
			}else {
				int a = i / 100;
				int b = i % 100 / 10;
				int c = i %100 % 10;
				if( a - b == b - c) {
					count++;
				}
			}
		}
		System.out.println(count);
	} // end of main
} // end of class
