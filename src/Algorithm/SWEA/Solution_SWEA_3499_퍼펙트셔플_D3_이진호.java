package Algorithm.SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_3499_퍼펙트셔플_D3_이진호 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine()); // 테스트케이스 입력

		for (int testCase = 1; testCase <= TC; testCase++) {
			int N = Integer.parseInt(br.readLine());
			String[] arr = new String[N];
			int cnt = 1;
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x = ((N+1)/2 + (N-1)/2);
			for(int i = 0; i < N; i++) {
//				int x = N%2 == 0 ? N-1 : N;
				if(cnt <= (N+1)/2) {
					arr[2*i] = st.nextToken();
					cnt++;
				}else {
//					arr[2*i - x] = st.nextToken();
					arr[2*i - x] = st.nextToken();
					cnt++;
				}
			}		
			sb.append("#").append(testCase);
			for(int i = 0; i < N; i++) {
				sb.append(" ").append(arr[i]);
			}
			sb.append("\n");
		} // end of for teseCase
		System.out.print(sb);
	} // end of main
} // end of class
