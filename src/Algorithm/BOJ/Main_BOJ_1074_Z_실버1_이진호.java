package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_1074_Z_실버1_이진호 {
	private static int r;
	private static int c;
	private static int cnt = 0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		go(N, 0,0);
	} // end of main

	/** 사각영역의 가로세로 크기 = 2^n, 사각영역의 시작위치 = (sr, sc) */
	private static void go(int n, int sr, int sc) {
		if(n == 0) { // 한칸짜리일때 종료조건
			if(sr == r && sc == c) {
				System.out.println(cnt);
				System.exit(0); // 프로그램 종료
			}
			cnt++;
			return;
		}
		int x = (int)Math.pow(2, n-1);
		go(n-1, sr, sc); // 좌상
		go(n-1, sr, sc + x); // 우상
		go(n-1, sr + x, sc); // 좌하
		go(n-1, sr + x, sc + x); // 우하
	}
} // end of class