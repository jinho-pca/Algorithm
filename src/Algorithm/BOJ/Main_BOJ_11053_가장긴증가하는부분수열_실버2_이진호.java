package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_11053_가장긴증가하는부분수열_실버2_이진호 {
    static int N, max;
    static int[] input, dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        input = new int[N];
        dp = new int[N];
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < N; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if(input[j] < input[i] && dp[i] < dp[j] + 1) dp[i] = dp[j]+1;
            }
            if(max < dp[i]) max = dp[i];
        }
        System.out.print(max);
    }
}
