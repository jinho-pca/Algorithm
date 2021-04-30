package Algorithm.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_5604_Professional구간합_D4_이진호 {
    static long start, end, result;
    static long[] sum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= TC; tc++) {
            sum = new long[10];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            start = Long.parseLong(st.nextToken());
            end = Long.parseLong(st.nextToken());
            while(start % 10 > 0){

            }

        } // end of for tc
    } // end of main
    private static void calc(int x){
        while(x > 0){
            sum[x % 10] ++;
            x /= 10;
        }
    } // end of calc
} // end of class
