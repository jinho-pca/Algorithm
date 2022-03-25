package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BOJ_3687_성냥개비_골드2_이진호 {
    static int TC, N;
    static StringBuilder sb = new StringBuilder();
    static String[] table = {"0", "0", "1", "7", "4", "2", "6", "8", "10", "18", "22", "20", "28", "68", "88", "108", "188", "200"
    ,"208", "288", "688", "888"}; // 0 ~ 21
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TC = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < TC; tc++) {
            N = Integer.parseInt(br.readLine());
            if(N < 22) sb.append(table[N]).append(" ");
            else calc(N);
            if(N % 2 != 0) sb.append("7");
            else sb.append("1");
            for (int i = 1; i < N/2; i++) sb.append("1");
            sb.append("\n");
        } // end of for tc
        System.out.print(sb.toString());
    } // end of main
    private static void calc(int x) {
        int cnt = (x-1)/7 - 2;
        int target = (x+6)%7 + 15;
        sb.append(table[target]);
        for (int i = 0; i < cnt; i++) sb.append("8");
        sb.append(" ");
        return;
    } // end of calc
} // end of class
