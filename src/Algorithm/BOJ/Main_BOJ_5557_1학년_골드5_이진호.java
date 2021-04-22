package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
80ms
 */
public class Main_BOJ_5557_1학년_골드5_이진호 {
    static int N;
    static int[] numbers;
    static long[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new long[N][21];
        numbers = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        dp[1][numbers[0]] = 1;
        for (int i = 2; i < N; i++) {
            for (int j = 0; j < 21; j++) {
                if(dp[i-1][j] == 0) continue;

                if(j - numbers[i-1] >= 0) dp[i][j - numbers[i-1]] += dp[i-1][j];
                if(j + numbers[i-1] <= 20) dp[i][j + numbers[i-1]] += dp[i-1][j];
            }
        }
        System.out.println(dp[N-1][numbers[N-1]]);
    } // end of main
} // end of class
