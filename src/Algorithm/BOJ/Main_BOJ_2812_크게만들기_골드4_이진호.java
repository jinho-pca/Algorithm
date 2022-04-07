package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_BOJ_2812_크게만들기_골드4_이진호 {
    static int N, K, cnt;
    static Stack<Integer> stack = new Stack<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        String number = br.readLine();
        for (int i = 0; i < N; i++) {
            int tmp = number.charAt(i) - '0';
            if(!stack.empty()) {
                while(!stack.empty() && cnt < K) {
                    if(stack.peek() < tmp) {
                        stack.pop();
                        cnt++;
                    } else break;
                }
            }
            stack.push(tmp);
            if(cnt == K) {
                sb.append(number.substring(i+1));
                break;
            }
        }
        while(!stack.empty()) {
            int num = stack.pop();
            if(cnt < K) {
                cnt++;
                continue;
            }
            sb.insert(0, num);
        }
        System.out.print(sb.toString());
    } // end of main
} // end of class
