package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_2234_성곽_골드4_이진호 {
    static int N, M, roomCnt, maxSize;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {0, -1, 0, 1};
    static int[] dc = {-1, 0, 1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        visited = new boolean[M][N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if(!visited[i][j]){
                    bfs(i, j);
                    roomCnt++;
                }
            }
        }

        sb.append(roomCnt).append("\n").append(maxSize).append("\n");

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                breakWall(i, j);
            }
        }
        sb.append(maxSize);
        System.out.print(sb);
    } // end of main
    private static void bfs(int r, int c){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {r, c});
        visited[r][c] = true;
        int roomSize = 0;

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int curR = cur[0];
            int curC = cur[1];
            int wall = map[curR][curC];
            roomSize++;

            for (int i = 0; i < 4; i++) {
                if((wall & (1 << i)) > 0) continue; // 벽이 존재할 경우 pass
                
                int nr = curR + dr[i];
                int nc = curC + dc[i];
                
                if(nr >= 0 && nr < M && nc >= 0 && nc < N && !visited[nr][nc]){
                    visited[nr][nc] = true;
                    queue.offer(new int[] {nr, nc});
                }
            }
        }
        maxSize = maxSize > roomSize ? maxSize : roomSize;
    } // end of bfs
    private static void breakWall(int r, int c){
        for (int i = 0; i < 4; i++) {
            if((map[r][c] & (1 << i)) != 0){
                for (int j = 0; j < M; j++) {
                    Arrays.fill(visited[j], false);
                }
                map[r][c] -= (1 << i);
                bfs(r, c);
                map[r][c] += (1 << i);
            }
        }
    } // end of breakWall
} // end of class
