package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_BOJ_19236_청소년상어_골드2_이진호 {
    static int result;
    static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1}, dc = {0, -1, -1, -1, 0, 1, 1, 1};
    static class Fish {
        int r;
        int c;
        int num;
        int dir;
        boolean alive;
        public Fish(int r, int c, int num, int dir, boolean alive) {
            this.r = r;
            this.c = c;
            this.num = num;
            this.dir = dir;
            this.alive = alive;
        }
    }
    static class Shark {
        int r;
        int c;
        int dir;
        int score;
        public Shark(int r, int c, int dir, int score) {
            this.r = r;
            this.c = c;
            this.dir = dir;
            this.score = score;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Shark shark;
        int[][] map = new int[4][4];
        ArrayList<Fish> fishList = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 4; j++) {
                Fish fish = new Fish(i, j, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())-1, true);
                map[i][j] = fish.num;
                fishList.add(fish);
            }
        }
        Collections.sort(fishList, (o1, o2)-> o1.num - o2.num);
        Fish first = fishList.get(map[0][0]-1);
        shark = new Shark(0, 0, first.dir, first.num);
        first.alive = false;
        map[0][0] = -1;
        moveShark(map, shark, fishList);
        System.out.print(result);
    } // end of main
    private static void moveShark(int[][] map, Shark shark, ArrayList<Fish> fishList) {
        if(shark.score > result) result = shark.score;
        System.out.println("물고기 이동 전");
        for(int[] x : map) System.out.println(Arrays.toString(x));
        System.out.println();
        System.out.println("방향");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if(map[i][j] <= 0) System.out.print("-1 ");
                else System.out.print(fishList.get(map[i][j]-1).dir + " ");
            }
            System.out.println();
        }
        System.out.println();
        for(Fish fish : fishList) moveFish(map, fish, fishList);
        System.out.println("물고기 이동 후");
        for(int[] x : map) System.out.println(Arrays.toString(x));
        System.out.println();
        for (int i = 1; i <= 3; i++) {
            int nr = shark.r + i * dr[shark.dir];
            int nc = shark.c + i * dc[shark.dir];
            if(!isRange(nr, nc)) continue;
            if(map[nr][nc] <= 0) continue;

            int[][] copyMap = copyMap(map);
            ArrayList<Fish> copyList = copyList(fishList);
            copyMap[shark.r][shark.c] = 0;
            Fish fish = copyList.get(map[nr][nc]-1);
            Shark newShark = new Shark(fish.r, fish.c, fish.dir, shark.score+fish.num);
            fish.alive = false;
            copyMap[fish.r][fish.c] = -1;
            moveShark(copyMap, newShark, copyList);
        }
    } // end of moveShark
    private static void moveFish(int[][] map, Fish fish, ArrayList<Fish> fishList) {
        if(!fish.alive) return;
        for (int i = 0; i < 8; i++) {
            int nd = (fish.dir + i) % 8;
            int nr = fish.r + dr[nd];
            int nc = fish.c + dc[nd];
            if(!isRange(nr, nc)) continue;
            if(map[nr][nc] == -1) continue;
            map[fish.r][fish.c] = 0;
            if(map[nr][nc] == 0) {
                fish.r = nr;
                fish.c = nc;
            } else {
                Fish tmp = fishList.get(map[nr][nc]-1);
                tmp.r = fish.r;
                tmp.c = fish.c;
                map[fish.r][fish.c] = tmp.num;
                fish.r = nr;
                fish.c = nc;
            }
            map[nr][nc] = fish.num;
            fish.dir = nd;
            return;
        }
    } // end of moveFish
    private static ArrayList<Fish> copyList(ArrayList<Fish> list) {
        ArrayList<Fish> tmp = new ArrayList<>();
        for(Fish f : list) tmp.add(new Fish(f.r, f.c, f.num, f.dir, f.alive));
        return tmp;
    } // end of copyList
    private static int[][] copyMap(int[][] map) {
        int[][] tmp = new int[4][4];
        for (int i = 0; i < 4; i++) {
            tmp[i] = map[i].clone();
        }
        return tmp;
    } // end of copyMap
    private static boolean isRange(int nr, int nc) {
        return nr >= 0 && nr < 4 && nc >= 0 && nc < 4;
    } // end of isRange
} // end of class
