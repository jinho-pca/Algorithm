package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_BOJ_21609_상어중학교_골드2_이진호 {
    static int N, M, score;
    static int[][] map;
    static boolean[][] visited;
    static ArrayList<Point> rainbowList = new ArrayList<>();
    static PriorityQueue<Group> groupPQ = new PriorityQueue<>((o1, o2) -> {
        int diffSize = o2.size - o1.size;
        if(diffSize == 0) {
            int diffRainbow = o2.rainbowCnt - o1.rainbowCnt;
            if(diffRainbow == 0) {
                int diffR = o2.start.r - o1.start.r;
                if(diffR == 0) return o2.start.c - o1.start.c;
                return diffR;
            }
            return diffRainbow;
        }
        return diffSize;
    });
    static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};
    static class Group {
        int size;
        int rainbowCnt;
        Point start;
        ArrayList<Point> groupList;
        public Group(int size, int rainbowCnt, Point start, ArrayList<Point> groupList) {
            this.size = size;
            this.rainbowCnt = rainbowCnt;
            this.start = start;
            this.groupList = groupList;
        }
    }
    static class Point {
        int r;
        int c;
        int number;
        public Point(int r, int c, int number) {
            this.r = r;
            this.c = c;
            this.number = number;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 0) rainbowList.add(new Point(i, j, 0));
            }
        }

        while(true) {
            // 좌상단부터 완탐으로 bfs 수행 후 그룹을 찾는다. -> 그룹사이즈는 2이상 이다.
            // 그룹을 찾으면 그룹의 사이즈와 기준점을 우선순위큐에 저장한다.
            // 이때 우선순위큐의 정렬기준은 사이즈가 제일 큰거 -> 기준점의 행이 가장 큰거 -> 기준점의 열이 가장 큰거 의 순으로 정렬한다.
            // 우선순위큐에서 poll한 그룹을 제거한다.
            if(!findGroup()) break;
            // 중력작용 : -1빼고 모든 블록이 아래로 떨어질 수 있을 만큼 떨어진다.
            gravity();
            // 반시계 90도 회전
            rotate();
            // 중력작용
            gravity();
        }
        System.out.print(score);
    } // end of main
    private static boolean findGroup() {
        visited = new boolean[N][N];
        Point startPoint;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!visited[i][j] && map[i][j] > 0) {
                    startPoint = new Point(i, j, map[i][j]);
                    findRainbow();
                    bfs(startPoint);
                }
            }
        }
        if(groupPQ.size() == 0) return false;
        Group deleteGroup = groupPQ.poll();

        score += deleteGroup.size * deleteGroup.size;
        for (int i = 0; i < deleteGroup.groupList.size(); i++) {
            Point pick = deleteGroup.groupList.get(i);
            map[pick.r][pick.c] = -2;
        }
        groupPQ.clear();
        return true;
    } // end of findGroup
    private static void bfs(Point start) {
        int target = start.number;
        Queue<Point> q = new LinkedList<>();
        Group group = new Group(1, 0, start, new ArrayList<Point>());
        group.groupList.add(start);
        q.offer(start);
        visited[start.r][start.c] = true;
        while(!q.isEmpty()) {
            Point cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                if(visited[nr][nc]) continue;
                if(map[nr][nc] == target || map[nr][nc] == 0) {
                    Point next = new Point(nr, nc, map[nr][nc]);
                    visited[next.r][next.c] = true;
                    q.offer(next);
                    group.size++;
                    if(map[next.r][next.c] == 0) group.rainbowCnt++;
                    group.groupList.add(next);
                }
            }
        }
        if(group.size >= 2) {
            groupPQ.offer(group);
        }
        return;
    } // end of bfs
    private static void findRainbow() {
        rainbowList.clear();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j] == 0) {
                    rainbowList.add(new Point(i, j, 0));
                    visited[i][j] = false;
                }
            }
        }
        return;
    } // end of findRainbow
    private static void gravity() {
        for (int i = N-2; i >= 0; i--) {
            for (int j = 0; j < N; j++) {
                if(map[i][j] != -1 && map[i][j] != -2) {
                    int nr = i;
                    for (int k = i+1; k < N; k++) {
                        if(map[k][j] == -2) nr = k;
                        else break;
                    }
                    if(nr != i) {
                        map[nr][j] = map[i][j];
                        map[i][j] = -2;
                    }
                }
            }
        }
        return;
    } // end of gravity
    private static void rotate() {
        Queue<Integer> list = new LinkedList<>();
        for (int i = N-1; i >= 0; i--) { // 우측열부터선택
            for (int j = 0; j < N; j++) { // 위쪽행부터선택
                list.add(map[j][i]);
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = list.poll();
            }
        }
        return;
    } // end of rotate
} // end of class