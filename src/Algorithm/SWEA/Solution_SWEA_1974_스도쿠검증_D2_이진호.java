package Algorithm.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_SWEA_1974_스도쿠검증_D2_이진호 {
	private static int[][] m;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		m = new int[9][9];
		for (int testCase = 1; testCase <= TC; testCase++) {
			for (int i = 0; i < 9; i++) {
				String s = br.readLine();
				for (int j = 0, index = 0; j < 9; j++, index += 2) {
					m[i][j] = s.charAt(index) - '0';
				}
			}
			sb.append("#").append(testCase).append(" ").append(check()).append("\n");
		} // end of for testCase
		System.out.print(sb);
	} // end of main

	/**
	 * 스도쿠가 정상인지, 오류인지 체크
	 * 
	 * @return 정상:1, 오류:0
	 */
	public static int check() {
		for (int i = 0; i < 9; i++) { // 행검사
			if (!checkRow(i) || !checkCol(i)) {
				return 0; // 오류
			}
		}
		for (int i = 0; i < 9; i+=3) { // 블럭검사
			for(int j = 0; j < 9; j +=3) {
				if(!checkBlock(i, j)) {
					return 0;
				}
			}
		}
		return 1;
	}
	/**
	 * r 번째 행이 정상인지 체크
	 * 
	 * @return 정상 : true, 오류 : false
	 */
	static boolean[] flag = new boolean[10]; // 0번방은 안씀
	public static boolean checkBlock(int r, int c) {
		Arrays.fill(flag, false);
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if(flag[m[r+i][c+j]]) {
					return false;
				}else {
					flag[m[r+i][c+j]] = true;
				}
			}
		}
		return true; // 정상
	}
	
	/**
	 * r 번째 행이 정상인지 체크
	 * 
	 * @return 정상 : true, 오류 : false
	 */
	public static boolean checkRow(int r) {
		Arrays.fill(flag, false);
		for (int i = 0; i < 9; i++) {
			if (flag[m[r][i]]) {
				return false; // 오류
			} else {
				flag[m[r][i]] = true;
			}
		}
		return true; // 정상
	}

	/**
	 * c 번째 열이 정상인지 체크
	 * 
	 * @return 정상 : true, 오류 : false
	 */
	public static boolean checkCol(int c) {
		Arrays.fill(flag, false);
		for (int i = 0; i < 9; i++) {
			if (flag[m[i][c]]) {
				return false; // 오류
			} else {
				flag[m[i][c]] = true;
			}
		}
		return true; // 정상
	}
} // end of class
