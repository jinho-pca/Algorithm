package Algorithm.BOJ;
/**
 * 부분집합
 * 객체지향적으로는 클래스의 멤버로 신맛과 쓴맛을 나누는 것이 좋지만
 * 알고리즘의 성능적으로는 이차원배열보단, 일차원배열 두개를 만드는 것이 좋다.
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_2961_도영이가만든맛있는음식_실버1_이진호 {
	private static int N;
	private static int[] S;
	private static int[] B;
	private static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine()); // 재료의 개수 1~10
		S = new int[N];
		B = new int[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			S[i] = Integer.parseInt(st.nextToken());
			B[i] = Integer.parseInt(st.nextToken());
		}
		powerSet(0,1,0);
		System.out.println(min);
	} // end of main
	/** index : 차수, sVal : 지금까지 사용한 재료들의 곱, bVal : 지금까지 사용한 재료들의 합
	 *  index 번째 재료를 사용할지, 사용하지 않을지 결정 */
	public static void powerSet(int index, int sVal, int bVal) {
		if(index == N) { // 종료파트
			if(bVal == 0) { // 재료를 사용하지 않으면 리턴
				return;
			}
			// 신맛, 쓴맛의 차이의 최소값을 업데이트
			int result = Math.abs(sVal - bVal);
			if(min > result) min = result;
			return;
		}
		// index 번째 재료 사용
		powerSet(index+1, sVal*S[index], bVal+B[index]);
		// index 번째 재료 사용 안함
		powerSet(index+1, sVal, bVal);
	}
} // end of class