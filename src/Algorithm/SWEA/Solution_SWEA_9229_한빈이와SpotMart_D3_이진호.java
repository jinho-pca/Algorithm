package Algorithm.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_9229_한빈이와SpotMart_D3_이진호 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= TC; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			int[] weight = new int[N];
			for (int i = 0; i < N; i++) {
				weight[i] = Integer.parseInt(st.nextToken());
			}
			int result = -1;
			for (int i = 0; i < N; i++) {
				for (int j = i + 1; j < N; j++) {
					int sum = weight[i] + weight[j];
					if (sum == M) {
						result = M;
						break;
					} else if (sum < M) {
						result = result > sum ? result : sum;
					}
				}
			}
			sb.append("#").append(testCase).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}
}
