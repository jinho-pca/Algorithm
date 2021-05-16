package Algorithm.SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_SWEA_2805_농작물수확하기_D3_이진호 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int testCase = 1; testCase <= T; testCase++) {
			int N = Integer.parseInt(br.readLine());
			int[][] m = new int[N][N];
			int sum = 0;
			for(int i = 0; i < N; i++) { // 입력하기
//				StringTokenizer st = new StringTokenizer(br.readLine(),"");
				String s = br.readLine(); // "14054" char[] value = {'1', '4', '0', '5', '4'};
//				m[i] = s.toCharArray();
				for(int j = 0; j < N; j++) {
//					m[i][j] = Integer.parseInt(st.nextToken());
//					m[i][j] = Character.getNumericValue(s.charAt(j));
					m[i][j] = s.charAt(j) - '0';
//					System.out.print(m[i][j] + " ");
				}
			}
			
			for(int i = 0; i < (N / 2); i++) { // 파란색영역 합 더하기
				for(int j = (N / 2) - i; j <= (N / 2) + i; j++) {
					sum += m[i][j];
					sum += m[N-1-i][j];
//					System.out.println(sum);
				}
			}
			for(int i = 0; i < N; i++) {
				sum += m[N/2][i];
			}
			sb.append("#").append(testCase).append(" ").append(sum).append("\n");
		}
		System.out.println(sb);
	}
}
