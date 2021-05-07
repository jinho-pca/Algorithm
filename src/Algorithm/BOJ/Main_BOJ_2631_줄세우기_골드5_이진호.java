package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_BOJ_2631_줄세우기_골드5_이진호 {
    static int N;
    static int[] numbers, dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        numbers = new int[N+1];
        dp = new int[N+1];
        for (int i = 1; i <= N; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 1; i <= N; i++) {
            dp[i] = 1;
            for (int j = 1; j < i; j++) {
                if(numbers[i] > numbers[j] && dp[i] <= dp[j]) dp[i] = dp[j] + 1;
            }
        }
        Arrays.sort(dp);
        System.out.print(N - dp[N]);
    } // end of main
} // end of class
