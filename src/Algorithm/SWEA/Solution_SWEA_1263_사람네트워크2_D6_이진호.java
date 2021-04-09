package Algorithm.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_SWEA_1263_사람네트워크2_D6_이진호 {
    static final int INF = 9999999;
    static int N,distance[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= TC; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());

            distance = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    distance[i][j] = Integer.parseInt(st.nextToken());
                    if(i != j && distance[i][j] == 0){
                        distance[i][j] = INF;
                    }
                }
            }

            for(int k=0; k<N; k++) {
                for(int i=0; i<N; i++) {
                    if(i==k) continue; // 출발지와 경유지가 같다면 다음 출발지
                    for(int j=0; j<N; ++j) {
                        if(i==j || k==j) continue; // 경유지와 목적지가 같거나 출발지가 곧 목적지라면 패스
                        if(distance[i][k]!= INF && distance[k][j] != INF && distance[i][j] > distance[i][k]+distance[k][j]) {
                            distance[i][j] = distance[i][k]+distance[k][j];
                        }
                    }
                }
            }

            int min = Integer.MAX_VALUE;
            for (int i = 0; i < N; i++) {
                int tmp = 0;
                for (int j = 0; j < N; j++) {
                    tmp += distance[i][j];
                }
                min = Math.min(min, tmp);
            }
            sb.append("#").append(testCase).append(" ").append(min).append("\n");


        } // end of for testCase
        System.out.println(sb);
    } // end of main
} // end of class
