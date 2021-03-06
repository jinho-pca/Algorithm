package Algorithm.BOJ;

import java.util.Stack;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BOJ_2493_탑_골드5_이진호 {
	public static void main(String[] args) throws Exception {
		Stack<int[]> stack = new Stack<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= N; i++) {
			int v = Integer.parseInt(st.nextToken());
			while (!stack.isEmpty()) {
				if (stack.peek()[1] >= v) {
//					System.out.print(stack.peek()[0] + " ");
					sb.append(stack.peek()[0]).append(" ");
					break;
				}
				stack.pop();
			}
			if (stack.isEmpty()) {
//				System.out.print("0 ");
				sb.append("0 ");
			}
			stack.push(new int[] { i, v });
		}
		System.out.println(sb);
	}
}
