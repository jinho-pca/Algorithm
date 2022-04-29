package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_BOJ_19237_어른상어_골드2_이진호 {
    static int N, M, K, time;
    static Room[][] map;
    static Shark[] sharks;
    static int[] dr = {0, -1, 1, 0, 0}, dc = {0, 0, 0, -1, 1};
    static class Room {
        int owner;
        int time;
        PriorityQueue<Integer> sharkList;
        public Room() {this.sharkList = new PriorityQueue<>((o1, o2) -> o1-o2);}
    }
    static class Shark {
        int r;
        int c;
        int number;
        int dir;
        int[][] priority = new int[5][5];
        public Shark(int r, int c, int number) {
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
        K = Integer.parseInt(st.nextToken());
        map = new Room[N][N];
        sharks = new Shark[M+1];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = new Room();
            }
        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                int cur = Integer.parseInt(st.nextToken());
                if(cur != 0) {
                    map[i][j].owner = cur;
                    map[i][j].time = K;
                    map[i][j].sharkList.add(cur);
                    Shark shark = new Shark(i, j, cur);
                    sharks[cur] = shark;
                }
            }
        }
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= M; i++) {
            sharks[i].dir = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i <= M; i++) {
            int[][] priority = new int[5][5];
            for (int j = 1; j <= 4; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int k = 1; k <= 4; k++) {
                    priority[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            sharks[i].priority = priority;
        }
        while(time++ < 1000) {
            // 상어이동
            moveShark();
            // 냄새갱신
            updateSmell();
            // 중복제거
            deleteShark();
            // 냄새뿌리기
            makeSmell();
            if(countShark() == 1) break;
        }
        System.out.print(time > 1000 ? -1 : time);
    } // end of main
    private static void makeSmell() {
        for (int i = 1; i <= M; i++) {
            if(sharks[i] == null) continue;
            map[sharks[i].r][sharks[i].c].owner = sharks[i].number;
            map[sharks[i].r][sharks[i].c].time = K;
        }
        return;
    } // end of makeSmell
    private static void deleteShark() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j].sharkList.size() > 1) {
                    int live = map[i][j].sharkList.poll();
                    while(!map[i][j].sharkList.isEmpty()) {
                        int delete = map[i][j].sharkList.poll();
                        sharks[delete] = null;
                    }
                    map[i][j].sharkList.clear();
                    map[i][j].sharkList.offer(live);
                }
            }
        }
        return;
    } // end of deleteShark
    private static void updateSmell() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j].time > 0) map[i][j].time--;
                if(map[i][j].time == 0) map[i][j].owner = 0;
            }
        }
        return;
    } // end of updateSmell
    private static void moveShark() {
        start:
        for (int i = 1; i <= M; i++) {
            Shark cur = sharks[i];
            if(cur == null) continue;
            Shark tmp = new Shark(-1,-1,cur.number);
            boolean flag = false;
            int nd = cur.dir;
            int nr = cur.r;
            int nc = cur.c;
            for (int j = 1; j <= 4; j++) {
                nd = cur.priority[cur.dir][j];
                nr = cur.r + dr[nd];
                nc = cur.c + dc[nd];
                if(!isRange(nr, nc)) continue;
                if(map[nr][nc].owner != 0) {
                    // 빈칸이 아닌 경우
                    if(map[nr][nc].owner == i && !flag) {
                        // 내 냄새이면서 우선순위가 높은 경우 일단 저장하고 밑에서 사용
                        flag = true;
                        tmp.r = nr;
                        tmp.c = nc;
                        tmp.dir = nd;
                        continue;
                    }
                } else {
                    // 빈칸인 경우 -> 이동
                    map[cur.r][cur.c].sharkList.remove(cur.number);
                    cur.r = nr;
                    cur.c = nc;
                    cur.dir = nd;
                    map[nr][nc].sharkList.add(cur.number);
                    continue start;
                }
            }
            // 갈 곳이 없는 경우 내 냄새를 따라 간다.
            if(flag) {
                map[cur.r][cur.c].sharkList.remove(cur.number);
                cur.r = tmp.r;
                cur.c = tmp.c;
                cur.dir = tmp.dir;
                map[cur.r][cur.c].sharkList.add(cur.number);
            }
        }
        return;
    } // end of moveShark
    private static boolean isRange(int nr, int nc) {
        return nr >= 0 && nr < N && nc >= 0 && nc < N;
    } // end of isRange
    private static int countShark() {
        int cnt = 0;
        for (int i = 1; i <= M; i++) {
            if(sharks[i] != null) cnt++;
        }
        return cnt;
    }
} // end of class
