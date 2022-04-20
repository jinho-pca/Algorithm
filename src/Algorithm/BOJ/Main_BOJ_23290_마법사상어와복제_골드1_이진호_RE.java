package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_BOJ_23290_마법사상어와복제_골드1_이진호_RE {
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
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    for (int k = 0; k < 4; k++) {
                        this.orders.add(new int[] {i, j, k});
                    }
                }
            }
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
            moveFish();
            // 상어 이동
            moveShark();
            // 냄새 제거
            removeSmell();
            // 물고기 복제
            copyFish();
        }
        System.out.print(countFish());
    } // end of main
    private static int countFish() {
        int answer = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                answer += map[i][j].fishList.size();
            }
        }
        return answer;
    }
    private static void copyFish() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                for(Fish fish : map[i][j].copyList) {
                    map[fish.r][fish.c].fishList.add(fish);
                }
                map[i][j].copyList.clear();
            }
        }
        return;
    }
    private static void removeSmell() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if(map[i][j].smell > 0) map[i][j].smell--;
            }
        }
        return;
    } // end of removeSmell
    private static void moveShark() {
        int[] maxRoot = new int[3];
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
                if(nr < 0 || nr >= 4 || nc < 0 || nc >= 4) continue start;
                if(!visited[nr][nc]) count += map[nr][nc].fishList.size();
                visited[nr][nc] = true;
            }
            if(maxCnt < count) {
                maxCnt = count;
                maxRoot = order.clone();
            }
        }
        for (int i = 0; i < 3; i++) {
            shark.r += sr[maxRoot[i]];
            shark.c += sc[maxRoot[i]];
            if(map[shark.r][shark.c].fishList.size() > 0) {
                map[shark.r][shark.c].smell = 3;
                map[shark.r][shark.c].fishList.clear();
            }
        }
        return;
    } // end of moveShark
    private static void moveFish() {
        ArrayList<Fish> saveList = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                for(Fish fish : map[i][j].fishList) {
                    for (int k = 0; k < 8; k++) {
                        int nd = (fish.dir + 8 - k) % 8;
                        int nr = fish.r + dr[nd];
                        int nc = fish.c + dc[nd];
                        if(isMove(nr, nc)) {
                            fish.r = nr;
                            fish.c = nc;
                            fish.dir = nd;
                            break;
                        }
                    }
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
    private static boolean isMove(int nr, int nc) {
        if(nr >= 0 && nr < 4 && nc >= 0 && nc < 4) {
            if(map[nr][nc].smell == 0) {
                if(shark.r == nr && shark.c == nc) return false;
                else return true;
            } else return false;
        } else return false;
    } // end of isMove
    private static void saveFish() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                for(Fish fish : map[i][j].fishList) {
                    map[i][j].copyList.add(new Fish(fish.r, fish.c, fish.dir));
                }
            }
        }
        return;
    } // end of saveFish
} // end of class
