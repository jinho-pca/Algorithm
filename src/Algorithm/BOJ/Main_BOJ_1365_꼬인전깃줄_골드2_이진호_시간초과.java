package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_1365_꼬인전깃줄_골드2_이진호_시간초과 {
    static int N, max;
    static int[] list, dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new int[N];
        dp = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = 1;

        for (int i = 1; i < N; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if(list[j] <= list[i] && dp[j] + 1 > dp[i]) dp[i] = dp[j] + 1;
            }
            max = Math.max(max, dp[i]);
        }

        System.out.print(N - max);
    } // end of main
} // end of class

/*
완전탐색으로 LIS를 진행하면 시간초과
 */