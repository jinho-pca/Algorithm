package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main_BOJ_1744_수묶기_골드4_이진호 {
    static int N, result;
    static ArrayList<Integer> minus, plus;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        plus = new ArrayList<>();
        minus = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(br.readLine());
            if(tmp <= 0) minus.add(tmp);
            else plus.add(tmp);
        }
        Collections.sort(plus);
        Collections.sort(minus);

        for (int i = plus.size()-1; i > 0; i-=2) {
            int first = plus.get(i);
            int second = plus.get(i-1);
            if(first == 1 || second == 1){
                result += first + second;
            }else result += plus.get(i) * plus.get(i-1);
        }
        if(plus.size() % 2 != 0) result += plus.get(0);

        for (int i = 0; i < minus.size()-1; i+=2) {
            result += minus.get(i) * minus.get(i+1);
        }
        if(minus.size() % 2 != 0) result += minus.get(minus.size()-1);

        System.out.print(result);
    } // end of main
} // end of class