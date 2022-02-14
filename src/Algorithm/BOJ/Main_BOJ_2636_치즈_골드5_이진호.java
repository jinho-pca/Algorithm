package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_BOJ_2636_치즈_골드5_이진호 {
    static class Point {
        int r;
        int c;
        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "r=" + r +
                    ", c=" + c +
                    '}';
        }

        @Override
        public boolean equals(Object obj) {
            if(obj instanceof Point) {
                Point p = (Point) obj;
                return p.r == this.r && p.c == this.c;
            }
            return false;
        }
    }
    static int N, M, cheeseCnt, time, result;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};
    static ArrayList<Point> holes = new ArrayList<>();
    static ArrayList<Point> deleteList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) cheeseCnt++;
                if(i == 0 || i == N-1 || j == 0 || j == M-1) {
                    map[i][j] = -1;
                }
            }
        }
        while(true) {
            if(cheeseCnt == 0) break;
            visited = new boolean[N][M];
            holes.clear();
            searchHoles();
            deleteList.clear();
            for (int i = 1; i < N; i++) {
                for (int j = 1; j < M; j++) {
                    if(!visited[i][j] && map[i][j] == 1) {
                        bfs(i, j);
                    }
                }
            }
            result = cheeseCnt;
            cheeseCnt -= deleteList.size();
            deleteCheese();
            time++;
        }
        sb.append(time).append("\n").append(result);
        System.out.print(sb);
    } // end of main
    private static void bfs(int r, int c) {
        Queue<Point> q = new LinkedList<>();
        Point tmpCur = new Point(r, c);
        if(isSide(r, c)) {
            deleteList.add(tmpCur);
        }
        visited[r][c] = true;
        q.offer(tmpCur);
        while(!q.isEmpty()) {
            Point cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                if(nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc] && map[nr][nc] == 1) {
                    // 범위내에서 자신과 인접한 모든칸이 치즈이지 않은 경우 -> 가장자리
                    Point next = new Point(nr, nc);
                    if(isSide(nr ,nc)) {
                        deleteList.add(next);
                    }
                    visited[nr][nc] = true;
                    q.offer(next);
                }
            }
        }
    }
    private static boolean isSide(int r, int c) {
        // 가장자리가 아닌 치즈는 4방이 다 치즈거나 구멍에 속하는 좌표와 인접해있다.
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if(nr >= 0 && nr < N && nc >= 0 && nc < M) {
                Point tmp = new Point(nr ,nc);
                if(map[nr][nc] == -1) return true;
                else if(map[nr][nc] == 0) {
                    if(holes.contains(tmp)) {
                        continue;
                    } else return true;
                }
            }
        }
        return false;
    }
    private static void searchHoles() {
        for (int i = 1; i < N; i++) {
            for (int j = 1; j < M; j++) {
                if(!visited[i][j] && map[i][j] == 0) {
                    bfs_holes(i, j);
                }
            }
        }
    } // end of searchHoles
    private static void bfs_holes(int r, int c) {
        boolean isSide = false;
        Queue<Point> q = new LinkedList<>();
        ArrayList<Point> tmp = new ArrayList<>();
        visited[r][c] = true;
        q.offer(new Point(r, c));
        while(!q.isEmpty()) {
            Point cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                Point next = new Point(nr ,nc);
                if(nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc]) {
                    if(map[nr][nc] == -1) {
                        isSide = true;
                        visited[nr][nc] = true;
                    } else if(map[nr][nc] == 0){
                        visited[nr][nc] = true;
                        q.offer(next);
                        tmp.add(next);
                    }
                }
            }
        }
        if(isSide) {
            // 0인 부분에서 bfs탐색을 마치고 발견된 영역이 가장자리인 경우 구멍에 담을 tmp를 비우고 그냥 리턴한다.
            tmp.clear();
            return;
        }
        // 발견된 영역이 구멍인 경우 tmp에 담긴 점들을 holes에 담는다.
        for (int i = 0; i < tmp.size(); i++) {
            holes.add(tmp.get(i));
        }
        // 시작 점또한 같이 넣는다.
        holes.add(new Point(r, c));
        return;
    } // end of bfs_holes
    private static void deleteCheese() {
        for(Point pick : deleteList) {
            map[pick.r][pick.c] = 0;
        }
        return;
    } // end of deleteCheese
} // end of class