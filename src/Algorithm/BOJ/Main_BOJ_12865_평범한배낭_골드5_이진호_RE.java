package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_12865_평범한배낭_골드5_이진호_RE {
    static int N, K;
    static int[][] dp;
    static int[] w;
    static int[] v;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        w = new int[N+1];
        v = new int[N+1];
        dp = new int[N+1][K+1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            w[i] = Integer.parseInt(st.nextToken());
            v[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                dp[i][j] = dp[i-1][j];
                if(j >= w[i]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-w[i]] + v[i]);
                }
            }
        }
        System.out.println(dp[N][K]);
        for(int[] x : dp) System.out.println(Arrays.toString(x));
    }
}
/*
dp[i-1][j-w[i]]에다 v[i]를 더해야 하는 이유
이미 j=3일때 3짜리 써서 무개 갱신됬는데 6에서 또 3을 쓰기때문에
4 7
5 1
4 2
3 3
2 4
 */