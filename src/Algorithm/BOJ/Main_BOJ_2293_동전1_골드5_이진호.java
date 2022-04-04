package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_2293_동전1_골드5_이진호 {
    static int N, K;
    static int[] dp;
    static int[] coins;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        coins = new int[N+1];
        dp = new int[K+1];
        dp[0] = 1;
        for (int i = 1; i <= N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
            for (int k = coins[i]; k <= K; k++) {
                dp[k] += dp[k-coins[i]];
            }
        }
        System.out.print(dp[K]);
        System.out.println(Arrays.toString(dp));
    } // end of main
} // end of class
