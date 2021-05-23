package Algorithm.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
최단 시간 경로 => 그래프
1개의 cell : 정점, 4방 : 인접정점과의 연결 = 간선, cell 값 : 복구시간 -> 가중치
다익스트라 or BFS
가중치 : 음수X => 다익스트라
 */
public class Solution_SWEA_1249_보급로_D4_Dijkstra {
    static int N, INF = Integer.MAX_VALUE;
    static int[][] map;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= TC; tc++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];

            for (int i = 0; i < N; i++) {
                char[] ch = br.readLine().toCharArray();
                for (int j = 0; j < N; j++) {
                    map[i][j] = ch[j] - '0';
                }
            }
            sb.append("#").append(tc).append(" ").append(dijkstra(0,0)).append("\n");
        } // end of for tc
        System.out.println(sb);
    } // end of main

    private static int dijkstra(int startR, int startC) {
        boolean[][] visited = new boolean[N][N];
        int[][] minTime = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                minTime[i][j] = INF;
            }
        }

        minTime[startR][startC] = 0;
        int r = 0, c = 0, cost = 0, nr, nc;

        while(true){
            cost = INF;
            // 방문하지 않은 정점 중 출발지에서 자신으로 오는 비용이 최소인 정점 선택
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(!visited[i][j] && cost > minTime[i][j]){
                        cost = minTime[i][j];
                        r = i;
                        c = j;
                    }
                }
            }

            visited[r][c] = true;
            if(r == N-1 && c == N-1) return cost;
            // 선택된 정점 기준으로 인접한 정점 중 방문하지 않은 나머지 정점들 자신과의 경유시의 비용과 기존 최소비용 비교하여 최소값 갱신

            // 현재 정점 위치 기준으로 4방의 인접정점을 처리
            for (int d = 0; d < 4; d++) {
                nr = r + dr[d];
                nc = c + dc[d];
                if(nr >= 0 && nc >= 0 && nr < N && nc < N && !visited[nr][nc] && minTime[nr][nc] > cost + map[nr][nc]){
                    minTime[nr][nc] = cost + map[nr][nc];
                }
            }
        }
    } // end of dijkstra
} // end of class
