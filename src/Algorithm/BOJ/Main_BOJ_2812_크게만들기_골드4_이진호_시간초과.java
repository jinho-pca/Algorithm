package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_2812_크게만들기_골드4_이진호_시간초과 {
    static int N, K, idx, max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        String number = br.readLine();
        for (int i = 0; i < N-K; i++) {
            max = '0';
            for (int j = idx; j <= K+i; j++) {
                if(max < number.charAt(j)) {
                    max = number.charAt(j);
                    idx = j+1;
                }
            }
            sb.append(max);
        }
        System.out.print(sb.toString());
    } // end of main
} // end of class
