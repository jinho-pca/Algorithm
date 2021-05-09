package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_11497_통나무건너뛰기_실버1_이진호 {
    static int N, max;
    static int[] numbers, tmp;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= TC; tc++) {
            max = 0;
            N = Integer.parseInt(br.readLine());
            numbers = new int[N+1];
            tmp = new int[N];
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < N; i++) {
                tmp[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(tmp);
            int idx = 0;
            if(N %2 == 0){ // N : 짝수
                for (int i = 0; i < N; i += 2) {
                    numbers[idx++] = tmp[i];
                }
                for (int i = N-1; i > 0; i -= 2) {
                    numbers[idx++] = tmp[i];
                }
                numbers[N] = tmp[0];
            }else{ // N : 홀수
                for (int i = 0; i < N; i+=2) {
                    numbers[idx++] = tmp[i];
                }
                for (int i = N-2; i > 0; i -= 2) {
                    numbers[idx++] = tmp[i];
                }
                numbers[N] = tmp[0];
            }

            for (int i = 1; i < N + 1; i++) {
                max = Math.max(max, Math.abs(numbers[i] - numbers[i-1]));
            }
            sb.append(max).append("\n");
        } // end of tc
        System.out.print(sb);
    } // end of main
} // end of class