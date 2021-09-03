package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_1365_꼬인전깃줄_골드2_이진호 {
    static int N, result, cnt = 1;
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

        dp[0] = list[0];

        for (int i = 1; i < N; i++) {
            if(dp[cnt - 1] < list[i]){
                dp[cnt++] = list[i];
            }else if(dp[0] > list[i]){
                dp[0] = list[i];
            }else{
                int tmp = Arrays.binarySearch(dp, 0, cnt, list[i]);
                dp[tmp < 0 ? -tmp - 1 : tmp] = list[i];
            }
        }
        System.out.print(N - cnt);
    } // end of main
} // end of class
