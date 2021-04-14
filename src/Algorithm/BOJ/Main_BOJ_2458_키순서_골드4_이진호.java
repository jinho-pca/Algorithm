package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
540ms
플루이드 워샬 -> 완탐하면서 한 정점을 기준으로 그 정점으로 올 수 있는 경우 + 그 정점에서 갈 수 있는 경우 = N-1개 라면 모든 정점과 이어져있다.
 */
public class Main_BOJ_2458_키순서_골드4_이진호 {
        static int N, M, result;
        static final int INF = 501;
        static int[] count;
        static int[][] dist;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        count = new int[N+1];
        dist = new int[N + 1][N + 1];
        for(int i = 1; i<= N; i++){
            Arrays.fill(dist[i], INF);
        }
        for(int i = 1; i<= N; i++){
            dist[i][i] = 0;
        }

        for(int i = 0; i< M; i++) {
            st = new StringTokenizer(br.readLine());
            dist[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
        }

        for(int k = 1; k<= N; k++) { // k : 거쳐가는 노드
            for(int i = 1; i<= N; i++) { // i : 출발 노드
                for(int j = 1; j<= N; j++) { // j : 도착노드
                    if(dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        for(int i = 1; i<= N; i++) {
            for(int j = 1; j<= N; j++) {
                if(i == j) continue;
                // dist[i][j] 가 존재한다는 INF가 아니라는 것은 i -> j 의 경로가 가능하다는 말이고 i입장에서는 더 큰놈으로, j입장에서는 작은놈으로부터 가능하다는 의미
                if(dist[i][j] < INF) {
                    count[i]++;
                    count[j]++;
                }
            }
        }
        for (int i = 1; i <= N; i++) {
            if(count[i] == N-1){
                result++;
            }
        }
        System.out.println(result);
    } // end of main
} // end of class
