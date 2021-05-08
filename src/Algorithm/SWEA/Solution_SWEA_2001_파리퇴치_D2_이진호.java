package Algorithm.SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_2001_파리퇴치_D2_이진호 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int testCase = 1; testCase <= T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken()); // N : 배열 크기
			int M = Integer.parseInt(st.nextToken()); // M : 파리채 크기
			int[][] f = new int[N][N];
			int max = 0;
			int sum = 0;
			int r = 0;
			int c = 0;
			for(int i = 0; i < N; i++) { // 파리수 채우기
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j < N; j++) {
					f[i][j] = Integer.parseInt(st.nextToken()); 
				}
			}
			
			for(r = 0; r <= N-M; r++) {
				for(c = 0; c <= N-M; c++) {
					// 파리채 합구하기
					for(int i=r; i < r+M; i++) {
						for(int j = c; j < c+M; j++) {
							sum += f[i][j];
							max = sum > max ? sum : max;
							
//							System.out.print(f[i][j] + " ");
						}
//						System.out.println();
						
					}
//					System.out.println("합 : " + sum);
					sum = 0;					
				}
			}
			sb.append("#").append(testCase).append(" ").append(max).append("\n");
		} // end of testCase
		System.out.println(sb);
	} // end of main
	
} // end of class
