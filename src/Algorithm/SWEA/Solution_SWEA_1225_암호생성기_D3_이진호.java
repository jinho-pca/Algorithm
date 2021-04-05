package Algorithm.SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * 테스트케이스번호 입력받기
 * 8개의 숫자 입력받기 
 * 공백기준으로 큐에 하나씩 삽입
 * while 맨뒤숫자가 0이 되면 중지
 * for문으로 5번씩 반복해서 숫자 뺀다
 * @author jinho_pca
 *
 */
public class Solution_SWEA_1225_암호생성기_D3_이진호 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int testCase = 1; testCase <= 10; testCase++) {
			Queue<Integer> queue = new LinkedList<Integer> ();
			int N = Integer.parseInt(br.readLine()); // 테스트케이스번호 입력받기
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int[] result = new int[8];
			
			for(int i = 0; i < 8; i++) { // 데이터 입력받기
				queue.offer(Integer.parseInt(st.nextToken()));	
			}
						
start:			while(true) {
				for(int i = 1; i <= 5; i++) {
					int temp = queue.poll();
					temp -= i;
					if(temp < 0) {
						temp = 0;
					}
					queue.offer(temp);
					if(temp == 0) {
						break start;
					}
				}
			}
			sb.append("#").append(testCase).append(" ");
            while(!queue.isEmpty()) {
                sb.append(queue.poll()).append(" ");
            }
            sb.append("\n");
		} // end of for testCase
		System.out.println(sb);
	} // end of main
} // end of class
