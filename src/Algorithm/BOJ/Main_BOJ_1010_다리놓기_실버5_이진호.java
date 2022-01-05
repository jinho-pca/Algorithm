package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_1010_다리놓기_실버5_이진호 {
    static int TC, N, M;
    static long result;
    static int[][] dp = new int[30][30];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        TC = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= TC; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            result = comb(M, N);
            sb.append(result).append("\n");
        }
        System.out.print(sb.toString());
    }
    private static int comb(int n, int r) {
        if(dp[n][r] > 0) return dp[n][r];
        if(n == r || r == 0) return 1;

        return dp[n][r] = comb(n-1, r) + comb(n-1, r-1);
    }
}
