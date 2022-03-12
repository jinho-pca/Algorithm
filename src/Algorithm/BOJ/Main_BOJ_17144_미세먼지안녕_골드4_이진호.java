package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_BOJ_17144_미세먼지안녕_골드4_이진호 {
    static int R, C, T, result = 2;
    static int[][] originMap;
    static int[][] map;
    static Queue<Point> dust = new LinkedList<>();
    static ArrayList<Integer> cleaner = new ArrayList<>();
    static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};
    static class Point {
        int r;
        int c;
        int value;

        public Point(int r, int c, int value) {
            this.r = r;
            this.c = c;
            this.value = value;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        originMap = new int[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < C; j++) {
                originMap[i][j] = Integer.parseInt(st.nextToken());
                if(originMap[i][j] == -1) cleaner.add(i);
            }
        }
        while(T-- > 0) {
            // 미세먼지 큐에 추가
            addDust();
            // 미세먼지 확산
            spread();
            // 상단부 반시계 회전
            topRotate();
            // 하단부 시계 회전
            bottomRotate();
        } // end of while
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                result += originMap[i][j];
            }
        }
        System.out.print(result);
    } // end of main
    private static void addDust() {
        dust.clear();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(originMap[i][j] > 0) dust.offer(new Point(i, j, originMap[i][j]));
            }
        }
        return;
    } // end of addDust
    private static void bottomRotate() {
        // 왼쪽줄
        for (int i = cleaner.get(1)+1; i < R-1; i++) {
            originMap[i][0] = originMap[i+1][0];
        }
        // 아랫줄
        for (int i = 0; i < C-1; i++) {
            originMap[R-1][i] = originMap[R-1][i+1];
        }
        // 오른쪽줄
        for (int i = R-1; i > cleaner.get(1); i--) {
            originMap[i][C-1] = originMap[i-1][C-1];
        }
        // 윗줄
        for (int i = C-1; i > 1; i--) {
            originMap[cleaner.get(1)][i] = originMap[cleaner.get(1)][i-1];
        }
        originMap[cleaner.get(1)][1] = 0;


        return;
    } // end of bottomRotate
    private static void topRotate() {
        // 왼쪽줄
        for (int i = cleaner.get(0)-1; i > 0; i--) {
            originMap[i][0] = originMap[i-1][0];
        }
        // 윗줄
        for (int i = 0; i < C-1; i++) {
            originMap[0][i] = originMap[0][i+1];
        }
        // 오른쪽줄
        for (int i = 0; i < cleaner.get(0); i++) {
            originMap[i][C-1] = originMap[i+1][C-1];
        }
        // 아랫줄
        for (int i = C-1; i > 1; i--) {
            originMap[cleaner.get(0)][i] = originMap[cleaner.get(0)][i-1];
        }
        originMap[cleaner.get(0)][1] = 0;
        return;
    } // end of topRotate
    private static void spread() {
        // map 복사
        map = new int[R][C];
        map = originMap.clone();
        // 먼저마다 새로운 map에 확산할 수치 갱신
        while(!dust.isEmpty()) {
            Point cur = dust.poll();
            ArrayList<Integer> dir = new ArrayList<>();
            for (int j = 0; j < 4; j++) {
                int nr = cur.r + dr[j];
                int nc = cur.c + dc[j];
                if(nr < 0 || nr >= R || nc < 0 || nc >= C || (nr == cleaner.get(0) && nc == 0) || (nr == cleaner.get(1) && nc == 0)) continue;
                else dir.add(j);
            }
            int v = cur.value / 5;
            for (int j = 0; j < dir.size(); j++) {
                map[cur.r + dr[dir.get(j)]][cur.c + dc[dir.get(j)]] += v;
            }
            map[cur.r][cur.c] = originMap[cur.r][cur.c] - v * dir.size();
            if(map[cur.r][cur.c] < 0) map[cur.r][cur.c] = 0;
            cur.value = map[cur.r][cur.c];
        }
        // 갱신된 map을 originMap에 덮어쓰기
        originMap = map.clone();
        return;
    } // end of spread
} // end of class
