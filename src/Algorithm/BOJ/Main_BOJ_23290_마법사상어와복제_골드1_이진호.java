package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_BOJ_23290_마법사상어와복제_골드1_이진호 {
    static int M, S;
    static Shark shark;
    static Room[][] map = new Room[4][4];
    static boolean[][] visited;
    static int[] dr = {0, -1, -1, -1, 0, 1, 1, 1}, dc = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] sr = {-1, 0, 1, 0}, sc = {0, -1, 0, 1};
    static class Room {
        ArrayList<Fish> fishList = new ArrayList<>();
        ArrayList<Fish> copyList = new ArrayList<>();
        int smell = 0;
        public void copy() {
            for(Fish fish : fishList)
                copyList.add(new Fish(fish));
            return;
        }
        public void reduceSmell() {
            if(this.smell > 0) smell--;
            return;
        }
        public void finishCopy() {
            for(Fish fish : copyList)
                fishList.add(fish);
            copyList.clear();
            return;
        }
    }
    static class Shark {
        int r;
        int c;
        ArrayList<int[]> orders = new ArrayList<>();
        public Shark(int r, int c) {
            this.r = r;
            this.c = c;
            makeOrder();
        }
        public void makeOrder() {
            for (int i = 0; i < 4; i++)
                for (int j = 0; j < 4; j++)
                    for (int k = 0; k < 4; k++)
                        this.orders.add(new int[]{i, j, k});
        }
        public int[] findRoute() {
            int[] maxRoute = new int[3];
            int maxCnt = -1;
            start:
            for(int[] order : shark.orders) {
                visited = new boolean[4][4];
                int count = 0;
                int nr = shark.r;
                int nc = shark.c;
                for (int i = 0; i < 3; i++) {
                    nr += sr[order[i]];
                    nc += sc[order[i]];
                    if(!isRange(nr, nc)) continue start;
                    if(!visited[nr][nc]) count += map[nr][nc].fishList.size();
                    visited[nr][nc] = true;
                }
                if(maxCnt < count) {
                    maxCnt = count;
                    maxRoute = order.clone();
                }
            }
            return maxRoute;
        }
    }
    static class Fish {
        int r;
        int c;
        int dir;
        public Fish(int r, int c, int dir) {
            this.r = r;
            this.c = c;
            this.dir = dir;
        }
        public Fish(Fish fish) {
            this.r = fish.r;
            this.c = fish.c;
            this.dir = fish.dir;
        }
        public void move() {
            for (int i = 0; i < 8; i++) {
                int nd = (dir+8-i) % 8;
                int nr = r + dr[nd];
                int nc = c + dc[nd];
                if(isMove(nr, nc)) {
                    this.r = nr;
                    this.c = nc;
                    this.dir = nd;
                    return;
                }
            }
        }
        public boolean isMove(int nr, int nc ) {
            return isRange(nr, nc) && noShark(nr, nc) && noSmell(nr ,nc);
        }
        public boolean noShark(int nr, int nc) {
            return !(shark.r == nr && shark.c == nc);
        }
        public boolean noSmell(int nr, int nc) {
            return (map[nr][nc].smell == 0);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                map[i][j] = new Room();
            }
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken())-1;
            int dir = Integer.parseInt(st.nextToken())-1;
            Fish fish = new Fish(r, c, dir);
            map[r][c].fishList.add(fish);
        }
        st = new StringTokenizer(br.readLine(), " ");
        shark = new Shark(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1);
        for (int turn = 1; turn <= S; turn++) {
            // 복제할 물고기 저장
            saveFish();
            // 물고기 이동
//            print("물고기이동 전");
            moveFish();
//            print("물고기이동 후");
            // 상어 이동
//            print("상어이동 전");
            moveShark(turn);
//            print("상어이동 후");
            // 냄새 감소
            reduceSmell();
            // 물고기 복제
//            print("복제 전");
            copyFish();
//            print("복제 후");
        }
        System.out.println(countFish());
    } // end of main
    private static int countFish() {
        int answer = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                answer += map[i][j].fishList.size();
            }
        }
        return answer;
    } // end of countFish
    private static void copyFish() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                map[i][j].finishCopy();
            }
        }
        return;
    } // end of copyFish
    private static void reduceSmell() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                map[i][j].reduceSmell();
            }
        }
        return;
    } // end of reduceSmell
    private static void moveShark(int turn) {
        int[] maxRoute = shark.findRoute();
        int nr = shark.r;
        int nc = shark.c;
        for (int i = 0; i < 3; i++) {
            nr += sr[maxRoute[i]];
            nc += sc[maxRoute[i]];
            if(map[nr][nc].fishList.size() > 0) {
                map[nr][nc].smell = 3;
                map[nr][nc].fishList.clear();
            }
        }
        shark.r = nr;
        shark.c = nc;
        return;
    } // end of moveShark
    private static void moveFish() {
        ArrayList<Fish> saveList = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                for(Fish fish : map[i][j].fishList) {
                    fish.move();
                    saveList.add(fish);
                }
                map[i][j].fishList.clear();
            }
        }
        for(Fish fish : saveList) {
            map[fish.r][fish.c].fishList.add(fish);
        }
        return;
    } // end of moveFish
    private static void saveFish() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                map[i][j].copy();
            }
        }
        return;
    } // end of saveFish
    private static boolean isRange(int nr, int nc) {
        return nr >= 0 && nr < 4 && nc >= 0 && nc < 4;
    } // end of isRange
} // end of class
