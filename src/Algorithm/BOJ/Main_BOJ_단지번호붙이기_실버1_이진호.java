package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_BOJ_단지번호붙이기_실버1_이진호 {
    static int N, group, cnt;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static ArrayList<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j] == 1 && !visited[i][j]) bfs(i, j);
            }
        }
        sb.append(group).append("\n");
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i)).append("\n");
        }
        System.out.print(sb);
    } // end of main
    private static void bfs(int r, int c){
        cnt = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {r, c});
        visited[r][c] = true;

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            map[cur[0]][cur[1]] = cnt++;
            for (int i = 0; i < 4; i++) {
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];

                if(nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc] && map[nr][nc] == 1){
                    queue.offer(new int[] {nr, nc});
                    visited[nr][nc] = true;
                    map[nr][nc] = map[cur[0]][cur[1]] + 1;
                }else continue;
            }
        }
        list.add(cnt-1);
        group++;
        return;
    } // end of bfs
} // end of class
