package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_2846_오르막길_브론즈2_이진호 {
    static int N, start, max;
    static int[] numbers;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        numbers = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        start = numbers[0] = Integer.parseInt(st.nextToken());
        for (int i = 1; i < N; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            numbers[i] = tmp;
            if(numbers[i-1] < tmp){
                max = Math.max(max, tmp - start);
            }else{
                start = tmp;
            }
        }
        System.out.println(max);
    } // end of main
} // end of class