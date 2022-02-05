package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_BOJ_14502_연구소_골드5_이진호 {
    static int N, M, max;
    static int[][] map, tmpMap;
    static boolean[][] visited;
    static int[] numbers;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static ArrayList<int[]> blank = new ArrayList<>();
    static ArrayList<int[]> virus = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        numbers = new int[3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                int type = Integer.parseInt(st.nextToken());
                map[i][j] = type;
                if(type == 0) blank.add(new int[] {i, j});
                if(type == 2) virus.add(new int[] {i, j});
            }
        }
        comb(0, 0);
        System.out.print(max);
    } // end of main
    private static void bfs(int[] v) {
        visited[v[0]][v[1]] = true;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {v[0], v[1]});

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];
                if(nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc]) {
                    if(tmpMap[nr][nc] == 0 || tmpMap[nr][nc] == 2) {
                        visited[nr][nc] = true;
                        tmpMap[nr][nc] = 2;
                        q.offer(new int[] {nr, nc});
                    }
                }
            }
        }
        return;
    }
    private static void comb(int cnt, int start) {
        if(cnt == 3) {
            visited = new boolean[N][M];
            tmpMap = copyMap();
            for (int i = 0; i < 3; i++) {
                tmpMap[blank.get(numbers[i])[0]][blank.get(numbers[i])[1]] = 1;
            }
            for (int i = 0; i < virus.size(); i++) {
                int[] curVirus = virus.get(i);
                if(!visited[curVirus[0]][curVirus[1]]) bfs(curVirus);
            }
            max = Math.max(max, count(tmpMap));
            return;
        }
        for (int i = start; i < blank.size(); i++) {
            numbers[cnt] = i;
            comb(cnt+1, i+1);
        }
    }
    private static int[][] copyMap() {
        int[][] result = new int[N][M];
        for (int i = 0; i < N; i++) {
            System.arraycopy(map[i], 0, result[i], 0, map[i].length);
        }
        return result;
    }
    private static int count(int[][] tmpMap) {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(tmpMap[i][j] == 0) cnt++;
            }
        }
        return cnt;
    }
} // end of class
