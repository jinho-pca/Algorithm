package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_14501_퇴사_실버3_이진호 {
    static int N;
    static int[] t;
    static int[] p;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        t = new int[N+1];
        p = new int[N+1];
        dp = new int[N+2];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = N; i > 0; i--) {
            if(i + t[i] > N+1) dp[i] = dp[i+1];
            else dp[i] = Math.max(dp[i+1], p[i] + dp[i+t[i]]);
        }
        System.out.print(dp[1]);
    } // end of main
} // end of class
/*
dp[i] : i일부터 N일까지 최대수익
거꾸로 내려오면서 계산하고 1일부터 N일까지 최대수익을 반환한다.
 */