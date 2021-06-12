package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_14719_빗물_골드5_이진호 {
    static int H, W, result;
    static int[] rain;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        rain = new int[W];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < W; i++) rain[i] = Integer.parseInt(st.nextToken());
        for (int i = 1; i < W-1; i++) {
            int left = 0;
            int right = 0;
            for (int j = 0; j < i; j++) left = left < rain[j] ? rain[j] : left;
            for (int j = i+1; j < W; j++) right = right < rain[j] ? rain[j] : right;

            if(rain[i] < left && rain[i] < right) result += (left < right ? left : right) - rain[i];
        }
        System.out.println(result);
    } // end of main
} // end of class
