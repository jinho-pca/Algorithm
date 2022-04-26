package Algorithm.BOJ;

import java.util.*;
import java.io.*;
public class Main_BOJ_19238_스타트택시_골드3_이진호 {
    static int N, M, fuel;
    static Point taxi;
    static People pick;
    static int[][] map;
    static boolean[][] visited;
    static ArrayList<People> list = new ArrayList<>();
    static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};
    static class People {
        int sr;
        int sc;
        int er;
        int ec;
        public People(int sr, int sc, int er, int ec) {
            this.sr = sr;
            this.sc = sc;
            this.er = er;
            this.ec = ec;
        }
    }
    static class Point {
        int r;
        int c;
        int dist;
        public Point(int r, int c, int dist) {
            this.r = r;
            this.c = c;
            this.dist = dist;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        fuel = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine(), " ");
        taxi = new Point(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1, 0);
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            People people = new People(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1);
            list.add(people);
        }
        while(true) {
            int pickAndGo = pick();
            if(pickAndGo == -1) {
                System.out.println(-1);
                return;
            }
            fuel -= pickAndGo;
            if(fuel <= 0) {
                System.out.print(-1);
                return;
            }
            int plus = bfs(pick);
            if(plus == 0 || fuel < 0) {
                System.out.print(-1);
                return;
            }
            fuel += plus;
            if(list.size() == 0 && fuel >= 0) break;
        }
        System.out.print(fuel);
    } // end of main
    private static int bfs(People pick) {
        Queue<Point> q = new LinkedList<>();
        visited = new boolean[N][N];
        visited[pick.sr][pick.sc] = true;
        q.offer(new Point(pick.sr, pick.sc, 0));
        while(!q.isEmpty()) {
            Point cur = q.poll();
            if(cur.r == pick.er && cur.c == pick.ec) {
                taxi.r = cur.r;
                taxi.c = cur.c;
                fuel -= cur.dist;
                return cur.dist*2;
            }
            for (int i = 0; i < 4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                if(!isRange(nr, nc)) continue;
                if(visited[nr][nc] || map[nr][nc] != 0) continue;
                visited[nr][nc] = true;
                q.offer(new Point(nr, nc, cur.dist+1));
            }
        }
        return 0;
    }
    private static int pick() {
        // 가장 가까운 사람 고르기
        int minIdx = -1;
        int minDist = Integer.MAX_VALUE;
        start:
        for(int turn = 0; turn < list.size(); turn++) {
            People people = list.get(turn);
            Queue<Point> q = new LinkedList<>();
            visited = new boolean[N][N];
            visited[people.sr][people.sc] = true;
            q.offer(new Point(people.sr, people.sc, 0));
            while(!q.isEmpty()) {
                Point cur = q.poll();
                if(cur.r == taxi.r && cur.c == taxi.c) {
                    if(cur.dist < minDist) {
                        minDist = cur.dist;
                        minIdx = turn;
                    } else if(cur.dist == minDist) {
                        if(list.get(minIdx).sr > list.get(turn).sr) {
                            minDist = cur.dist;
                            minIdx = turn;
                        } else if(list.get(minIdx).sr == list.get(turn).sr) {
                            if(list.get(minIdx).sc > list.get(turn).sc) {
                                minDist = cur.dist;
                                minIdx = turn;
                            }
                        }
                    }
                    continue start;
                }
                for (int i = 0; i < 4; i++) {
                    int nr = cur.r + dr[i];
                    int nc = cur.c + dc[i];
                    if(!isRange(nr, nc)) continue;
                    if(visited[nr][nc] || map[nr][nc] != 0) continue;
                    visited[nr][nc] = true;
                    q.offer(new Point(nr, nc, cur.dist+1));
                }
            }
        }
        if(minIdx == -1) return -1;
        pick = list.get(minIdx);
        taxi.r = pick.sr;
        taxi.c = pick.sc;
        list.remove(minIdx);
        return minDist;
    } // end of pick
    private static boolean isRange(int nr, int nc) {
        return nr >= 0 && nr < N && nc >= 0 && nc < N;
    } // end of isRange
} // end of class
