package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_9465_스티커_실버2_이진호 {
    static int T, N;
    static int[][] sticker, dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            N = Integer.parseInt(br.readLine());
            sticker = new int[2][N+1];
            dp = new int[2][N+1];
            for (int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 1; j <= N; j++) sticker[i][j] = Integer.parseInt(st.nextToken());
            }
            dp[0][1] = sticker[0][1];
            dp[1][1] = sticker[1][1];

            for (int i = 2; i <= N; i++) {
                dp[0][i] = dp[1][i-1] < dp[1][i-2] ? dp[1][i-2] + sticker[0][i]: dp[1][i-1] + sticker[0][i];
                dp[1][i] = dp[0][i-1] < dp[0][i-2] ? dp[0][i-2] + sticker[1][i] : dp[0][i-1] + sticker[1][i];
            }
            System.out.println(dp[0][N] < dp[1][N] ? dp[1][N] : dp[0][N]);
        }
    } // end of main
} // end of class
