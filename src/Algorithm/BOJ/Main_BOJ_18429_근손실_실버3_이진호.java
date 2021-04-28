package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_18429_근손실_실버3_이진호 {
    static int N, K, cnt;
    static int force = 500;
    static int[] weight, numbers;
    static boolean[] isSelected;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        weight = new int[N];
        numbers = new int[N];
        isSelected = new boolean[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            weight[i] = Integer.parseInt(st.nextToken());
        }
        permutation(0);
        System.out.println(cnt);
    } // end of main
    private static void permutation(int x){
        if(x == N){
            force = 500;
            for (int i = 0; i < N; i++) {
                if(force + weight[numbers[i]] - K < 500){
                    return;
                }else force += weight[numbers[i]] -K;
            }
            cnt++;
            return;
        }
        for (int i = 0; i < N; i++) {
            if(isSelected[i]) continue;
            numbers[x] = i;
            isSelected[i] = true;
            permutation(x+1);
            isSelected[i] = false;
        }
    } // end of permutation
} // end of class