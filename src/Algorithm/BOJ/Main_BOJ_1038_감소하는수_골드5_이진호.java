package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_BOJ_1038_감소하는수_골드5_이진호 {
    static StringBuilder sb = new StringBuilder();
    static int[] comb = {0, 9, 54, 174, 384, 636, 846, 966, 1011, 1021, 1022};
    static int N, n, r, cnt;
    static String result;
    static int[] tmp;
    static boolean[] isSelected;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        if(N > 1022) System.out.println(-1);
        if(N == 1022) System.out.println("9876543210");
        if(N >= 0 && N <= 9) System.out.println(N);
        else{
            for (int i = 1; i < 11; i++) {
                if(N < comb[i]) {
                    n = i;
                    r = N - comb[i-1];
                    break;
                }
            }
            tmp = new int[n];
            isSelected = new boolean[10];
            calc(0);
            System.out.println(sb);
        }
        //i자리수 중 r번째
    } // end of main
    private static void calc(int x){
        if(x == n) {
            for (int i = 1; i < n; i++) {
                if(tmp[i] >= tmp[i-1])
                    return;
            }
            cnt++;
            if(cnt == r){
                for (int i = 0; i < tmp.length; i++) {
                    sb.append(tmp[i]);
                }
                return;
            }else return;
        }
        for (int i = 0; i < 10; i++) {
            tmp[x] = i;
            for (int j = 1; j < x; j++) {
                if(tmp[j-1] <= tmp[j] && tmp[j] != 0) return;
            }
            isSelected[i] = true;
            calc(x+1);
            isSelected[i] = false;
        }

    }
} // end of class
