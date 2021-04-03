package Algorithm.SWEA;
import java.util.Scanner;
/**
 * Stack : LIFO(Last In First Out)
 * 수업코드
 */
import java.util.Stack;

public class Solution_SWEA_1218_괄호짝짓기_D4_이진호 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[][] c = { // 열린괄호는 0번째 열, 닫힌괄호는 1번째 열
				{'(', ')'},
				{'[', ']'},
				{'{', '}'},
				{'<', '>'}};
		for(int testCase = 1; testCase <= 10; testCase++) {
			int N = sc.nextInt(); // N : 글자의 길이
			String s = sc.next(); // 괄호 문자열
			Stack<Character> stack = new Stack<Character>(); // Stack 객체 생성
			int result = 1; // 유효성 여부 저장
ex:			for(int i = 0; i < s.length(); i++) {
				for(int j = 0; j < 4; j++) {	
					if(s.charAt(i) == c[j][0]) { // 열린 괄호 : 스택에 넣기
						stack.push(s.charAt(i));
						break;
					} else if(s.charAt(i) == c[j][1]) { // 닫힌 괄호 : 스택에서 열린괄호 꺼내서 짝이 맞는지 체크
						char x = stack.pop();
						if(x != c[j][0]) { // 짝이 맞지 않는 경우
							result = 0;
							break ex;
						}
					}
				}
			}
			if(!stack.isEmpty()) { // Stack 비어있는지 체크
				result = 0;
			}
			
			System.out.println("#" + testCase + " " + result);
		} // end of for testCase
	} // end of main
} // end of class
