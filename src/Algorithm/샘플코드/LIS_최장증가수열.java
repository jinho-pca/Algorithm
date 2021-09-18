package Algorithm.샘플코드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LIS_최장증가수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++) {
            int n = Integer.parseInt(br.readLine());
            int[] a = new int[n];
            int[] dp = new int[n];
            int max = 0;
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            dp[0] = 1;

            for (int i = 1; i < n; i++) {
                dp[i] = 1;
                for (int j = 0; j < i; j++) {
                    if(a[i] >= a[j] && dp[j] + 1 > dp[i]){
                        dp[i] = dp[j] + 1;
                    }
                }
                max = Math.max(max, dp[i]);
            }
            System.out.println("#" + tc + " " + max);
        }
    } // end of main
} // end of class
