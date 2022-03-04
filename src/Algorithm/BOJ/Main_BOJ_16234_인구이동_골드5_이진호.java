package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_16234_인구이동_골드5_이진호 {
    static int N, L, R;
    static int[][] map;
    static boolean[][] visited;
    static ArrayList<int[]> list; //인구 이동이 필요한 노드 리스트
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
        System.out.print(move());
    } // end of main
    private static int move() {
        int result = 0;
        while(true) {
            boolean isOpen = false;
            visited = new boolean[N][N];
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(!visited[i][j]) {
                        int sum = bfs(i, j); //bfs탐색으로 열릴 수 있는 국경선 확인 하며 인구 이동할 총 인구수 반환
                        if(list.size() > 1) {
                            fill(sum); //열린 국경선 내의 노드들 인구 변경
                            isOpen = true;
                        }
                    }
                }
            }
            if(!isOpen) return result;
            result++;
        }
    } // end of move
    private static int bfs(int r, int c) {
        int sum = map[r][c];
        Queue<int[]> q = new LinkedList<>();
        list = new ArrayList<>();
        visited[r][c] = true;
        q.offer(new int[] {r, c});
        list.add(new int[] {r, c});
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];
                if(nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc]) {
                    int diff = Math.abs(map[nr][nc] - map[cur[0]][cur[1]]);
                    if(diff >= L && diff <= R) {
                        visited[nr][nc] = true;
                        sum += map[nr][nc];
                        list.add(new int[] {nr, nc});
                        q.offer(new int[] {nr, nc});
                    }
                }
            }
        }
        return sum;
    } // end of bfs
    private static void fill(int sum) {
        int avg = sum / list.size();
        for(int[] cur : list) map[cur[0]][cur[1]] = avg;
        return;
    } // end of fill
} // end of class
