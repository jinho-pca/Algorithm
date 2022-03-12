package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_BOJ_12865_평범한배낭_골드5_이진호 {
    static int N, K, result;
    static int[] W, V;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        W = new int[N+1];
        V = new int[N+1];
        dp = new int[N+1][K+1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            W[i] = Integer.parseInt(st.nextToken());
            V[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) { // 아이템을 고른다.
            for (int j = 1; j <= K; j++) { // 무게 별로 체크한다.
                dp[i][j] = dp[i-1][j];
                if(j >= W[i]) {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-W[i]] + V[i]);
                }
            }
        }
        for(int[] x : dp) System.out.println(Arrays.toString(x));
        System.out.print(dp[N][K]);
    } // end of main
} // end of class
