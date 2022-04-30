package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_BOJ_23289_온풍기안녕_플래티넘5_이진호 {
    static int R, C, K, W, cnt;
    static int[][] map;
    static boolean[][] visited;
    static boolean[][][][] wall;
    static ArrayList<Point> checkList = new ArrayList<>();
    static ArrayList<Heater> heaterList = new ArrayList<>();
    static int[] dr = {0, 0, -1, 1}, dc = {1, -1, 0, 0}; // 우좌상하
    static int[][] sr = {{0, 1, -1}, {0, -1, 1}, {-1, -1, -1}, {1, 1, 1}}, sc = {{1, 1, 1}, {-1, -1, -1}, {0, 1, -1}, {0, -1, 1}}; // 우좌상하입장에서 앞우좌
    static int[][] cr = {{0, 1, -1}, {0, -1, 1}, {0, 0, 0}, {0, 0, 0}}, cc = {{0, 0, 0}, {0, 0, 0}, {0, 1, -1}, {0, -1, 1}}; // 행 : nd, 열 : 0우좌
    static class Point {
        int r;
        int c;
        int cost;
        public Point(int r, int c, int cost) {
            this.r = r;
            this.c = c;
            this.cost = cost;
        }
    }
    static class Heater {
        int r;
        int c;
        int dir;
        public Heater(int r, int c, int dir) {
            this.r = r;
            this.c = c;
            this.dir = dir;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        wall = new boolean[R][C][R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < C; j++) {
                int cur = Integer.parseInt(st.nextToken());
                if(cur != 0) {
                    if(cur == 5) {
                        Point point = new Point(i, j, -1);
                        checkList.add(point);
                    }else {
                        Heater heater = new Heater(i, j, cur-1);
                        heaterList.add(heater);
                    }
                }
            }
        }
        W = Integer.parseInt(br.readLine());
        for (int i = 0; i < W; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken())-1;
            int t = Integer.parseInt(st.nextToken());
            if(t == 1) {
                // 입력된 칸과 우측칸사이에 벽 존재
                wall[r][c][r][c+1] = true;
                wall[r][c+1][r][c] = true;
            } else {
                // 입력된 칸과 위쪽칸사이에 벽 존재
                wall[r][c][r-1][c] = true;
                wall[r-1][c][r][c] = true;
            }
        }
        while(cnt++ < 100) {
            // 온풍기에서 바람뿌리기
            heaterOn();
            // 온도 조절
            updateTemperature();
            // 온도가 1 이상인 가장 바깥쪽 칸의 온도 1감소
            decreaseSide();
            // 조사
            if(isEnd()) break;
        }
        System.out.print(cnt > 100 ? 101 : cnt);
    } // end of main
    private static void heaterOn() {
        Queue<Point> q = new LinkedList<>();
        for(Heater heater : heaterList) {
            q.clear();
            visited = new boolean[R][C];
            int nd = heater.dir;
            int nr = heater.r + dr[nd];
            int nc = heater.c + dc[nd];
            visited[nr][nc] = true;
            map[nr][nc] += 5;
            q.offer(new Point(nr, nc, 4));
            while(!q.isEmpty()) {
                Point cur = q.poll();
                if(cur.cost == 0) continue;
                for (int i = 0; i < 3; i++) {
                    nr = cur.r + sr[nd][i];
                    nc = cur.c + sc[nd][i];
                    if(!isRange(nr, nc)) continue;
                    if(visited[nr][nc]) continue;
                    if(!isPossible(cur.r, cur.c, nr, nc, nd, i)) continue;

                    visited[nr][nc] = true;
                    map[nr][nc] = map[nr][nc] + cur.cost;
                    q.offer(new Point(nr, nc, cur.cost-1));
                }
            }
        }
        return;
    } // end of heaterOn
    private static boolean isPossible(int r, int c, int nr, int nc, int nd, int d) {
        if(d == 0) {
            // 직선 방향의 경우 두 점 사이의 벽만 확인
            if(!wall[r][c][nr][nc] && !wall[nr][nc][r][c]) return true;
            else return false;
        } else {
            // 대각선 방향의 경우 맞는 방향의 벽2개 다 확인
            if(!wall[r][c][r+cr[nd][d]][c+cc[nd][d]] && !wall[r+cr[nd][d]][c+cc[nd][d]][r][c] && !wall[nr][nc][r+cr[nd][d]][c+cc[nd][d]] && !wall[r+cr[nd][d]][c+cc[nd][d]][nr][nc]) return true;
            else return false;
        }
    } // end of isPossible
    private static void updateTemperature() {
        int[][] updateMap = new int[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                int cur = map[i][j];
                for (int k = 0; k < 4; k++) {
                    int nr = i + dr[k];
                    int nc = j + dc[k];
                    if(!isRange(nr, nc)) continue;
                    if(!isPossible(i, j, nr, nc, 0, 0)) continue;
                    int next = map[nr][nc];
                    if(cur > next) {
                        int diff = (cur - next) / 4;
                        updateMap[nr][nc] += diff;
                        updateMap[i][j] -= diff;
                    }
                }
            }
        }
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                map[i][j] += updateMap[i][j];
            }
        }
        return;
    } // end of updateTemperature
    private static void decreaseSide() {
        for (int i = 0; i < R; i++) {
            if(map[i][0] > 0)map[i][0]--;
            if(map[i][C-1] > 0) map[i][C-1]--;
        }
        for (int i = 1; i < C-1; i++) {
            if(map[0][i] > 0) map[0][i]--;
            if(map[R-1][i] > 0) map[R-1][i]--;
        }
        return;
    } // end of decreaseSide
    private static boolean isEnd() {
        for(Point point : checkList) {
            if(map[point.r][point.c] < K) return false;
        }
        return true;
    } // end of isEnd
    private static boolean isRange(int nr, int nc) {
        return nr >= 0 && nr < R && nc >= 0 && nc < C;
    } // end of isRange
} // end of class