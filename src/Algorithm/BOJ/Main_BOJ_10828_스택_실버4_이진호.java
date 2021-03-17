package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_BOJ_10828_스택_실버4_이진호 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack = new Stack<Integer>();
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			String cmd = br.readLine();
			String[] cmdArray = cmd.split(" ");
			
			switch(cmdArray[0]) {
			case "push" :
				stack.push(Integer.parseInt(cmdArray[1]));
				break;
			case "pop" :
				if(stack.isEmpty()) {
					System.out.println(-1);
					break;
				}else {
					System.out.println(stack.pop());
					break;
				}
			case "size" :
				System.out.println(stack.size());
				break;
			case "empty" :
				if(stack.isEmpty()) {
					System.out.println(1);
					break;
				}else {
					System.out.println(0);
					break;
				}
			case "top" :
				if(stack.isEmpty()) {
					System.out.println(-1);
					break;
				}else {
					System.out.println(stack.peek());
					break;
				}
			}
		}
	} // end of main
} // end of class
