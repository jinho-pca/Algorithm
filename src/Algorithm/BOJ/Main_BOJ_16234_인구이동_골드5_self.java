package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_BOJ_16234_인구이동_골드5_self {
    static int N, L, R, result;
    static boolean isOpen;
    static int[][] map;
    static boolean[][] visited;
    static ArrayList<int[]> unionList;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        move();
        System.out.print(result);
    } // end of main
    private static void move() {
        while(true) {
            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(!visited[i][j]) {
                        unionList = new ArrayList<>();
                        int sum = bfs(i, j);
                        if(unionList.size() > 1) {
                            isOpen = true;
                            fill(sum);
                        }
                    }
                }
            }
            if(!isOpen) return;
            result++;
            isOpen = false;
        }
    } // end of move
    private static int bfs(int r, int c) {
        int res = map[r][c];
        Queue<int[]> q = new LinkedList<>();
        visited[r][c] = true;
        unionList.add(new int[] {r, c});
        q.offer(new int[] {r, c});
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];
                if(nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc]) {
                    if(L <= Math.abs(map[nr][nc] - map[cur[0]][cur[1]]) && Math.abs(map[nr][nc] - map[cur[0]][cur[1]]) <= R) {
                        visited[nr][nc] = true;
                        q.offer(new int[] {nr, nc});
                        unionList.add(new int[] {nr, nc});
                        res += map[nr][nc];
                    }
                }
            }
        }
        return res;
    }
    private static void fill(int sum) {
        int target = sum / unionList.size();
        for (int i = 0; i < unionList.size(); i++) {
            map[unionList.get(i)[0]][unionList.get(i)[1]] = target;
        }
        return;
    } // end of fill
} // end of class