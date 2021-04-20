package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
84ms
 */
public class Main_BOJ_5545_최고의피자_실버3_이진호 {
    static int N, x, y, xcal;
    static double max;
    static int[] ycal;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // N : 토핑의 종류
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        x = Integer.parseInt(st.nextToken()); // 도우가격
        y = Integer.parseInt(st.nextToken()); // 토핑가격
        xcal = Integer.parseInt(br.readLine()); // 도우열량
        ycal = new int[N]; // 토핑열량저장배열
        max = (double) xcal / x; // 열량/원
        for (int i = 0; i < N; i++) {
            ycal[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(ycal);
        for (int i = N - 1; i >= 0; i--) {
            double test = (xcal + ycal[i]) / (x + y);
            if(test < max){
                break;
            }else{
                x += y;
                xcal += ycal[i];
                max = test;
            }
        }
        System.out.print((int)max);
    } // end of main
} // end of class
