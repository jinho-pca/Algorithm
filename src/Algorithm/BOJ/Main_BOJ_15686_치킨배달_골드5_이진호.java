package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_BOJ_15686_치킨배달_골드5_이진호 {
    static int N, M, result = Integer.MAX_VALUE;
    static int[] numbers;
    static ArrayList<int[]> house = new ArrayList<>();
    static ArrayList<int[]> chicken = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        numbers = new int[M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                int pick = Integer.parseInt(st.nextToken());
                if(pick == 2) chicken.add(new int[] {i, j});
                if(pick == 1) house.add(new int[] {i, j});
            }
        }
        comb(0, 0);
        System.out.println(result);
    } // end of main
    private static void comb(int cnt, int start) {
        if(cnt == M) {
            int sum = 0;
            for (int i = 0; i < house.size(); i++) {
                int[] pickHouse = house.get(i);
                int dist = Integer.MAX_VALUE;
                for (int j = 0; j < M; j++) {
                    int[] pickChicken = chicken.get(numbers[j]);
                    int tmpDist = Math.abs(pickChicken[0] - pickHouse[0]) + Math.abs(pickChicken[1] - pickHouse[1]);
                    dist = Math.min(dist, tmpDist);
                }
                sum += dist;
            }
            result = Math.min(result, sum);
            return;
        }
        for (int i = start; i < chicken.size(); i++) {
            numbers[cnt] = i;
            comb(cnt+1, i+1);
        }
    } // end of comb
} // end of class
