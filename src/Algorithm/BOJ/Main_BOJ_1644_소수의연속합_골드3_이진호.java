package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_BOJ_1644_소수의연속합_골드3_이진호 {
    static int N, start, end, sum, cnt;
    static boolean[] composition;
    static ArrayList<Integer> prime = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        composition = new boolean[N+1];
        composition[0] = composition[1] = true; // 합성수는 true

        for (int i = 2; i*i <= N; i++) {
            if(!composition[i]){ // 소수인 경우
                for (int j = i * i; j <= N; j += i) composition[j] = true; // 배수 제거
            }
        }
        for (int i = 2; i <=N; i++) if(!composition[i]) prime.add(i);

        while(true){
            if(sum >= N) sum -= prime.get(start++);
            else if(end == prime.size()) break;
            else sum += prime.get(end++);
            if(sum == N) cnt++;
        }
        System.out.print(cnt);
    } // end of main
} // end of class
