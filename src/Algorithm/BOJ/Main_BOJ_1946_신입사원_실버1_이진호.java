package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_BOJ_1946_신입사원_실버1_이진호 {
    static int TC, N, result;
    static int[] score;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        TC = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= TC; tc++) {
            result = 1;
            N = Integer.parseInt(br.readLine());
            score = new int[N+1];
            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int first = Integer.parseInt(st.nextToken());
                int second = Integer.parseInt(st.nextToken());
                score[first] = second;
            }
            int pivot = score[1];
            for (int i = 2; i <= N; i++) {
                if(pivot > score[i]) {
                    result++;
                    pivot = score[i];
                }
            }
            sb.append(result).append("\n");
        } // end of for tc
        System.out.print(sb);
    } // end of main
} // end of class
