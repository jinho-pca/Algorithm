package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_BOJ_17298_오큰수_골드4_이진호 {
    static int N;
    static int[] numbers, result;
    static Stack<Integer> stack = new Stack<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        numbers = new int[N];
        result = new int[N];
        Arrays.fill(result, -1);
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            int cur = Integer.parseInt(st.nextToken());
            numbers[i] = cur;
            while(!stack.empty() && numbers[stack.peek()] < cur) {
                result[stack.pop()] = cur;
            }
            stack.push(i);
        }
        for(int x : result) sb.append(x).append(" ");
        System.out.print(sb);
    } // end of main
} // end of class
