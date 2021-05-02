package Algorithm.SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_SWEA_5643_키순서_D4_이진호 {
    static int N, M, result;
    static final int INF = 501;
    static int[] count;
    static int[][] dist;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= TC; tc++) {
            N = Integer.parseInt(br.readLine());
            M = Integer.parseInt(br.readLine());
            result = 0;
            count = new int[N + 1];
            dist = new int[N + 1][N + 1];
            for (int i = 1; i <= N; i++) {
                Arrays.fill(dist[i], INF);
            }
            for (int i = 1; i <= N; i++) {
                dist[i][i] = 0;
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                dist[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
            }

            for (int k = 1; k <= N; k++) { // k : 거쳐가는 노드
                for (int i = 1; i <= N; i++) { // i : 출발 노드
                    for (int j = 1; j <= N; j++) { // j : 도착노드
                        if (dist[i][j] > dist[i][k] + dist[k][j]) {
                            dist[i][j] = dist[i][k] + dist[k][j];
                        }
                    }
                }
            }

            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (i == j) continue;
                    // dist[i][j] 가 존재한다는 INF가 아니라는 것은 i -> j 의 경로가 가능하다는 말이고 i입장에서는 더 큰놈으로, j입장에서는 작은놈으로부터 가능하다는 의미
                    if (dist[i][j] < INF) {
                        count[i]++;
                        count[j]++;
                    }
                }
            }
            for (int i = 1; i <= N; i++) {
                if (count[i] == N - 1) {
                    result++;
                }
            }
            sb.append("#").append(tc).append(" ").append(result).append("\n");
        } // end of for tc
        System.out.print(sb);
    } // end of main
} // end of class
