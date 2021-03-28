package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_BOJ_18258_큐2_실버4_이진호 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Deque<Integer> deque = new LinkedList<Integer>();
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			switch(st.nextToken()) {
			case "push" :
				deque.offer(Integer.parseInt(st.nextToken()));
				break;
			case "pop" :
				if(deque.isEmpty()) {
					sb.append(-1).append("\n");
					break;
				}else {
					sb.append(deque.poll()).append("\n");
					break;
				}
			case "size" :
				sb.append(deque.size()).append("\n");
				break;
			case "empty" :
				if(deque.isEmpty()) {
					sb.append(1).append("\n");
					break;
				}else {
					sb.append(0).append("\n");
					break;
				}
			case "front" :
				if(deque.isEmpty()) {
					sb.append(-1).append("\n");
					break;
				}else {
					sb.append(deque.peek()).append("\n");
					break;
				}
			case "back" :
				if(deque.isEmpty()) {
					sb.append(-1).append("\n");
					break;
				}else {
//					시간초과 코드
//					for(int j = 1; j < queue.size()-1; j++) {
//						queue.offer(queue.poll());
//					}
//					System.out.println(queue.peek());
					sb.append(deque.getLast()).append("\n");
					break;
				}
			}
		}
		System.out.println(sb);
	}
}
