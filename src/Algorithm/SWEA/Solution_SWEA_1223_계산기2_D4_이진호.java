package Algorithm.SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution_SWEA_1223_계산기2_D4_이진호 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int testCase = 1; testCase <= 10; testCase++) {
			int N = Integer.parseInt(br.readLine());
			Stack<Character> op = new Stack<Character>();
			String s = br.readLine();
			String result = "";

			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) != '+' && s.charAt(i) != '*') {
					result += s.charAt(i);
				} else {
					if (s.charAt(i) == '*') {
						op.push(s.charAt(i));
					} else {
						do {
							if (op.isEmpty()) {
								break;
							}
							result += op.pop();
						} while (!op.isEmpty() && op.peek() != '+');
						op.push(s.charAt(i));
					}
				}
			}
			while (!op.isEmpty()) {
				result += op.pop();
			}

			Stack<Integer> c = new Stack<Integer>();
			for (int i = 0; i < result.length(); i++) {
				if (result.charAt(i) != '+' && result.charAt(i) != '*') {
					c.push(result.charAt(i) - '0');
				} else {
					int op1 = c.pop();
					int op2 = c.pop();
					char operator = result.charAt(i);
					switch (operator) {
					case '*':
						int times = op1 * op2;
						c.push(times);
						break;
					case '+':
						int plus = op1 + op2;
						c.push(plus);
						break;
					}
				}
			}

			System.out.println("#" + testCase + " " + c.peek());
		}
	}
}