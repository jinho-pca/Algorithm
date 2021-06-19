package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_BOJ_1918_후위표기식_골드4_이진호 {
    static String str, result;
    static Stack<Character> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') { // 문자인 경우
                sb.append(str.charAt(i));
            } else {
                if (str.charAt(i) == '(') { // 괄호가 나온 경우
                    stack.push(str.charAt(i));
                } else if (str.charAt(i) == ')') {
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        sb.append(stack.pop());
                    }
                    if(!stack.isEmpty()) stack.pop();
                } else {
                    while (!stack.isEmpty() && priority(stack.peek()) <= priority(str.charAt(i))) {
                        sb.append(stack.pop());
                    }
                    stack.push(str.charAt(i));
                }
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.print(sb);
    } // end of main
    private static int priority(char ch) {
        if (ch == '*' || ch == '/') return 1;
        else if (ch == '+' || ch == '-') return 2;
        else return 3;
    }
} // end of class
