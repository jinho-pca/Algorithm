package Algorithm.SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 입력을 받고 배열에 저장
 * 하나씩 탐색?..
 * 방문 배열을 하나 만든다. (visited)
 * 메모이제이션 : 결과를 저장해서 재사용하자
 * 
 * DFS(너비), BFS(깊이) : 비선형(1 : N)자료구조의 코드 블럭의 영역이 아니다.
 * 모든 정점에서 출발해서 다 탐색해 봐야함
 * 최대값 구하기(동일한 최댓값인 경우, 숫자가 작은 경우를 택한다.)
 * 메모이제이션, 반복문
 * @author jinho_pca
 *
 */
public class Solution_SWEA_1861_정사각형방_D4_이진호_2 {
	private static int N;
	private static int[][] A;
	private static int[][] memo;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine()); // 테스트케이스 입력
		
		for(int testCase = 1; testCase <= TC; testCase++) {
			N = Integer.parseInt(br.readLine()); // N 값 입력(1 <= N <= 10^3)
			A = new int[N][N];
			memo = new int[N][N]; // 탐색한 결과값을 저장할 배열
			
			for(int i = 0; i < N; i++) { // 행
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				for(int j = 0; j < N; j++) { // 열
					 A[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int max = 0; // 최대 이동할 수 있는 방의 개수
			int num = -1; // 최대 이동을 위해 출발할 방의 위치(숫자)
			for(int r = 0; r < N; r++) { // 모든 방에서 출발해서 탐색해보자 
				for(int c = 0; c < N; c++) {
					int val = go(r, c); // r,c 위치에서 출발해서 탐색하고 이동할 수 있는 최대 방의 개수를 리턴
					if(max < val || max == val && num > A[r][c]) {
						max = val; // 칸 저장
						num = A[r][c]; // 숫자 저장
					}
				}
			}
			sb.append("#").append(testCase).append(" ").append(num).append(" ").append(max).append("\n");
		} // end of testCase
		System.out.print(sb);
	} // end of main
	private static int[] dr = {-1, -1, 0, 0}; // 상, 하, 좌, 우
	private static int[] dc = {0, 0, -1, -1}; // 상, 하, 좌, 우
	/** A[r][c] 방에서 출발해서 최대 이동할 수 있는 방의 개수를 리턴하는 메서드 */
	public static int go(int r, int c) {
		if(memo[r][c] != 0) { // 탐색한 기록이 있는가?
			return memo[r][c]; // 중복 호출 제거
		}
		
		memo[r][c] = 1; // 몇칸 갈 수 있는지 저장할 변수
		int num = A[r][c];
		for(int i = 0; i < dr.length; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(0 <= nr && nr < N && 0 <= nc && nc < N && A[nr][nc] == num + 1) { // 배열범위 안쪽인지, 이동할 수 있는지 확인
				memo[r][c] += go(nr, nc);
				break; // 외길이니까
			}
		}
//		A[nr][nc]
//		A[r+dr[0]][c+dc[0]]
//		A[r+dr[1]][c+dc[1]]
//		A[r+dr[2]][c+dc[2]]
//		A[r+dr[3]][c+dc[3]]
				
		return memo[r][c];
		
	}
} // end of class