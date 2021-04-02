package Algorithm.SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 사다리
 * 가장 아래 행의 목표지점(2)를 찾아서 거슬러 올라간다.
 * BufferedReader
 * StringTokenizer
 * @author jinho_pca
 *
 */
public class Solution_SWEA_1210_Ladder1_D4_2_이진호 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int testCase = 1; testCase <= 10; testCase++) {
			int TC = Integer.parseInt(br.readLine()); // 테스트케이스 번호 버린다.
			int[][] m = new int[100][102]; // index가 넘어가는 것을 방지하기 위해 좌우로 1열씩 여유칸을 둔다.
			
//			BufferedReader 사용하면 쪼개는 작업이 필요함
//			String.split() : 느림 => StringTokenizer 사용
//			안쪼갤 수 있나? (폭이 일정하면 안쪼개도 됨)
//			
			
			for(int i = 0; i < 100; i++) { // 행
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				for(int j = 1; j <= 100; j++) { // 열 1~100 사용 0,101버림
					m[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int r = 99;
			int c = -1;
			for(int j = 1; j <= 100; j++) { // 마지막 행에서만 검사해서 2를 찾는다.
				if(m[99][j] == 2) {
					c = j;
				}
			}
			
			final int 상 = 1;
			final int 좌 = 2;
			final int 우 = 3;
			int dir = 상; // 최초방향은 위로 가도록
			
			while(r > 0) {
				if(dir != 우 && m[r][c-1] == 1) { // 좌
					dir = 좌; // 좌측으로 가기
					c--;
				} else if(dir != 좌 && m[r][c+1] == 1) { // 우
					dir = 우; // 우측으로 가기
					c++;
				} else { // 상
					dir = 상; // 위쪽으로 가기
					r--;
				}
			}
			System.out.println("#" + testCase + " " + (c-1));
		} // end of for testCase
	} // end of main
} // end of main
