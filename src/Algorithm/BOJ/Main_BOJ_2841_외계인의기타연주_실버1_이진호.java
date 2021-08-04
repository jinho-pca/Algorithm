package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_BOJ_2841_외계인의기타연주_실버1_이진호 {
    static int N, P, result;
    static Stack<Integer>[] list = new Stack[7];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= 6; i++) {
            list[i] = new Stack<>();
        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            while(!list[x].isEmpty() && list[x].peek() > y){
                list[x].pop();
                result++;
            }
            if(list[x].isEmpty() || (!list[x].isEmpty() && list[x].peek() < y)){
                list[x].push(y);
                result++;
            }
        }
        System.out.print(result);
    } // end of main
} // end of class
