package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
80ms
11484KB
 */
public class Main_BOJ_9461_파도반수열_실버3_이진호 {
    static int N;
    static long[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        dp = new long[100];
        dp[0] = dp[1] = dp[2] = 1;
        dp[3] = dp[4] = 2;
        for (int i = 5; i < 100; i++) {
            dp[i] = dp[i-1] + dp[i-5];
        }
        for (int tc = 0; tc < TC; tc++) {
            N = Integer.parseInt(br.readLine());
            sb.append(dp[N-1]).append("\n");
        } // end of tc
        System.out.print(sb);
    } // end of main
} // end of class
