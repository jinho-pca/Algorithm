package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 첫번재 풀이 큐를 사용
 * @author jinho_pca
 *
 */
public class Main_BOJ_16926_배열돌리기1_실버4_이진호 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // 행 1 <= N <= 300
		int M = Integer.parseInt(st.nextToken()); // 열 1 <= M <= 300
		int R = Integer.parseInt(st.nextToken()); // 회전수 1 <= N <= 1000
		int min = Math.min(N, M);
		int[][]  arr = new int[N][M];
		
		Queue<Integer> queue = new LinkedList<Integer>();
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());	
			}
		}
		
		for(int i = 0; i < min/2; i++) {
			int cnt = R % (2*(N-2*i+M-2*i) - 4);
			// 오른쪽
			for(int start = i; start < M-i-1; start++) {
				queue.offer(arr[i][start]);
			}
			// 아래쪽
			for(int start = i; start < N-i-1; start++) {
				queue.offer(arr[start][M-i-1]);
			}
			// 왼쪽
			for(int start = M-i-1; start > i; start--) {
				queue.offer(arr[N-i-1][start]);
			}
			// 위쪽
			for(int start = N-i-1; start > i; start--) {
				queue.offer(arr[start][i]);
			}
			// 회전
			while(cnt > 0) {
				queue.offer(queue.poll());
				cnt--;
			}
			// 삽입
			// right
			for(int start = i; start < M-i-1; start++) {
				arr[i][start] = queue.poll();
			}
			// down
			for(int start = i; start < N-i-1; start++) {
				arr[start][M-i-1] = queue.poll();
			}
			// left
			for(int start = M-i-1; start > i; start--) {
				arr[N-i-1][start] = queue.poll();
			}
			// up
			for(int start = N-i-1; start > i; start--) {
				arr[start][i] = queue.poll();
			}
		} // end of for whole block
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
//				sb.append(arr[i][j]).append(" ");
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
//		System.out.println(sb.length());
//		System.out.println(sb);
	} // end of main
} // end of class
