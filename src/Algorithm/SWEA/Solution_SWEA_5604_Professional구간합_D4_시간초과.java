package Algorithm.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
시간초과
 */
public class Solution_SWEA_5604_Professional구간합_D4_시간초과 {
    static long result;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= TC; tc++) {
            result = 0;
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            long start = Long.parseLong(st.nextToken());
            long end = Long.parseLong(st.nextToken());
            for (long i = start; i <= end; i++) {
                result += calc(i);
            }
            sb.append("#").append(tc).append(" ").append(result).append("\n");
        } // end of for tc
        System.out.print(sb);
    } // end of main
    private static int calc(long value){
        int tmp = 0;
        String x = String.valueOf(value);
        for (int i = 0; i < x.length(); i++) {
            tmp += (x.charAt(i) - '0');
        }
        return tmp;
    } // end of calc
} // end of class
