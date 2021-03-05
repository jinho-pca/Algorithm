package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_2491_수열_실버2_이진호 {
	static int increase; // 증가최대치
	static int decrease; // 감소최대치
	static int tempI = 1; // 임시 증가량
	static int tempD = 1; // 임시 감소량
	static int[] numbers;
	static int result = 1;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		numbers = new int[N];
		for(int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		for(int i = 0; i < N-1; i++) {
			if(numbers[i] < numbers[i+1]) { // 증가
				checkIncrease();
				continue;
			}else if(numbers[i] > numbers[i+1]) { // 감소
				checkDecrease();
				continue;
			}else { // 같음
				tempI++;
				tempD++;
				if(tempI >= increase) {
					increase = tempI;
				}
				if(tempD >= decrease) {
					decrease = tempD;
				}
				continue;
			}
		}
		result = increase >= decrease ? increase : decrease;
		if(N == 1) result = 1;
		System.out.print(result);
	} // end of main
	private static void checkIncrease() {
		tempI++;
		tempD = 1;
		if(tempI >= increase) {
			increase = tempI;
		}
	}
	private static void checkDecrease() {
		tempD++;
		tempI = 1;
		if(tempD >= decrease) {
			decrease = tempD;
		}
	}
}
