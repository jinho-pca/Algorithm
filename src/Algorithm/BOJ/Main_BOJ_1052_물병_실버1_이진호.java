package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_1052_물병_실버1_이진호 {
    static int N, K, result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        while(Integer.bitCount(N) > K){ // Integer.bitCount(N); // N을 이진수로 나타냈을 때 1의 개수
            result++; // 상점에서 새로 산 물병 개수
            N++; // 물병을 사면 N값 증가
        }

        System.out.println(result);
    } // end of main
} // end of class
