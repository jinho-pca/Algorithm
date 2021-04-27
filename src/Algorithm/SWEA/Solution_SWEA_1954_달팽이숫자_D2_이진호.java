package Algorithm.SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_SWEA_1954_달팽이숫자_D2_이진호 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int testCase = 1; testCase <= T; testCase++) {
			int N = Integer.parseInt(br.readLine()); // 달팽이 크기 : N, 1 <= N <= 10
			int[][] m = new int[N][N];
			
			int r = 0; // 행
			int c = 0; // 열
			int size = N-1; // 전진할 개수
			int num = 1; // 저장할 숫자
			while(size > 0) { // 시계방향
				for(int i = 0; i< size; i++) { // 오른쪽
					m[r][c] = num++;
					c++;
				}
				for(int i = 0; i< size; i++) { // 아래쪽
					m[r][c] = num++;
					r++;
				}
				for(int i = 0; i< size; i++) { // 왼쪽
					m[r][c] = num++;
					c--;
				}
				for(int i = 0; i< size; i++) { // 위쪽
					m[r][c] = num++;
					r--;
				}
				size -= 2;
				r++; c++; // 0,0으로 돌아오니까 대각선 한칸 내린다.
				
			} // end of while
			
			if( N % 2 != 0) { // N 이 홀수라면
				m[r][c] = num; // 한 가운데 값 넣기
			}
			sb.append("#").append(testCase).append("\n");
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					sb.append(m[i][j]).append(" ");
				}
				sb.append("\n");
			}
		} // end of for testCase
		System.out.println(sb);
	} // end of main
} // end of class
