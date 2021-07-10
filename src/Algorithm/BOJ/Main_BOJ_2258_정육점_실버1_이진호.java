package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_BOJ_2258_정육점_실버1_이진호 {
    private static int N, M, price, weight, result;
    private static boolean flag;
    private static int[][] meat;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        meat = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            meat[i][0] = Integer.parseInt(st.nextToken());
            meat[i][1] = Integer.parseInt(st.nextToken());
        }
        // 가격 오름차순 정렬, 가격이 같다면 무게 내림차순
        Arrays.sort(meat, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) return o2[0] - o1[0];
                else return o1[1] - o2[1];
            }
        });
        price = -1;
        weight = 0;
        result = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            weight += meat[i][0];

            if(i > 0 && meat[i-1][1] == meat[i][1]) price += meat[i][1];
            else price = meat[i][1];
            if(weight >= M){
                flag = true;
                result = result < price ? result : price;
            }
        }
        System.out.print(flag ? result : -1);
    } // end of main
} // end of class