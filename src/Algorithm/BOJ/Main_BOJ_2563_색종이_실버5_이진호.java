package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_2563_색종이_실버5_이진호 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 색종이 수 N <= 100
		int[][] result = new int[100][100]; // 도화지 배열
//		int[] dx = new int[N];
//		int[] dy = new int[N];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int dx = Integer.parseInt(st.nextToken());
			int dy = 100 - Integer.parseInt(st.nextToken()) - 9;
			for(int j = dy; j < dy+10; j++) {
				for(int k = dx; k < dx + 10; k++) {
					result[j][k] = 1;
				}
			}
		}
		int cnt = 0;
		for(int i = 0; i < 100; i++) {
			for(int j = 0; j < 100; j++) {
				if(result[i][j] == 1)
					cnt++;
			}
		}
		System.out.println(cnt);
	}
}
