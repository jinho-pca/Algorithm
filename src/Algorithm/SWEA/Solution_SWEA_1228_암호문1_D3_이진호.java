package Algorithm.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_SWEA_1228_암호문1_D3_이진호 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int testCase = 1; testCase <= 10; testCase++) {
			int N = Integer.parseInt(br.readLine()); // 원본 암호문의 길이 N, 10 <= N <= 20
			List<Integer> list = new LinkedList<Integer>();
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < N; i++) {
				list.add(Integer.parseInt(st.nextToken())); // 원본 암호문 추가
			}
			int com = Integer.parseInt(br.readLine()); // 명령어의 개수 com, 5 <= com <= 10
			int x, y, s;
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < com; i++) {
				switch(st.nextToken().charAt(0)) {
				case 'I' : // 삽입
					x = Integer.parseInt(st.nextToken()); // index
					y = Integer.parseInt(st.nextToken()); // 삽입 개수
					for (int j = 0; j < y; j++) {
						list.add(x + j, Integer.parseInt(st.nextToken()));
					}
					break;
				} // end of switch
			} // end of for
			sb.append("#").append(testCase);
//			for(int i = 0; i < 10; i++) { // 앞에서부터 10개 항만 출력
//				sb.append(" ").append(list.get(i));
//			}
			Iterator<Integer> iter = list.iterator(); // 자료구조의 데이터를 하나하나 던져준다.
			int it = 0;
			while(it < 10) {
				sb.append(" ").append(iter.next());
				it++;
			}
			sb.append("\n");
		} // end of for testCase
		System.out.print(sb);
	} // end of main
} // end of class
