package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_BOJ_21611_마법사상어와블리자드_골드1_이진호 {
    static int N, M, len, result;
    static int[][] map;
    static Point shark;
    static ArrayList<Integer> list = new ArrayList<>();
    static int[] dr = {0, 1, 0, -1}, dc = {-1, 0, 1, 0};
    static class Point {
        int r;
        int c;
        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " " );
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        len = N * N;
        map = new int[N][N];
        shark = new Point(N/2, N/2);
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        setIndex();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int d = Integer.parseInt(st.nextToken())-1;
            int s = Integer.parseInt(st.nextToken());
            // 구슬 파괴
            removeBeads(d, s);
            // 구슬 정렬
            sortBeads();
            // 구슬 폭발
            while(explodeBeads());
            // 구슬 변화
            changeBeads();
        }
        System.out.print(result);
    } // end of main
    private static void changeBeads() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        int size = list.size();
        int target = 0;
        int cnt = 1;
        for(int i = 2; i < size; i++) {
            target = list.get(i);
            if(target != list.get(i-1)) {
                // 이전 구슬과 다른 경우 -> cnt와 구슬번호를 tmpList에 삽입
                q.offer(cnt);
                q.offer(list.get(i-1));
                cnt = 1;
            } else {
                cnt++;
            }
        }
        if(list.get(list.size()-1) != 0) {
            q.offer(cnt);
            q.offer(list.get(list.size()-1));
        }
        list.clear();
        for(int i = 0; i < len; i++) {
            if(!q.isEmpty()) list.add(q.poll());
            else break;
        }
        return;
    } // end of changeBeads
    private static boolean explodeBeads() {
        Deque<Integer> deque = new ArrayDeque<>();
        boolean flag = false;
        int cnt = 1;
        for (int i = 1; i < list.size(); i++) {
            if(i != 1) {
                if(list.get(i) == list.get(i-1)) {
                    cnt++;
                } else {
                    if(cnt >= 4) {
                        flag = true;
                        result += (cnt * list.get(i-1));
                        for (int j = 0; j < cnt; j++) {
                            deque.pollLast();
                        }
                    }
                    cnt = 1;
                }
            }
            deque.addLast(list.get(i));
        }
        if(cnt >= 4) {
            flag = true;
            result += (cnt * deque.peekLast());
            for (int i = 0; i < cnt; i++) {
                deque.pollLast();
            }
        }
        list.clear();
        list.add(0);
        int size = deque.size();
        for (int i = 0; i < size; i++) {
            list.add(deque.pollFirst());
        }
        return flag;
    } // end of explodeBeads
    private static void sortBeads() {
        ArrayList<Integer> tmpList = new ArrayList<>();
        tmpList.add(0);
        for(int x : list) {
            if(x != 0) {
                tmpList.add(x);
            }
        }
        list = tmpList;
        return;
    } // end of sortBeads
    private static void removeBeads(int d, int s) {
        int start = 0;
        int size = list.size();
        switch(d) {
            case 0:
                for (int i = 1; i <= s; i++) {
                    start = 4*i*i + 3*i;
                    if(start < size) {
                        list.set(start, 0);
                    } else break;
                }
                break;
            case 1:
                for (int i = 1; i <= s; i++) {
                    start = 4*i*i -i;
                    if(start < size) {
                        list.set(start, 0);
                    } else break;
                }
                break;
            case 2:
                for (int i = 1; i <= s; i++) {
                    start = 4*i*i - 3*i;
                    if(start < size) {
                        list.set(start, 0);
                    } else break;
                }
                break;
            case 3:
                for (int i = 1; i <= s; i++) {
                    start = 4*i*i + i;
                    if(start < size) {
                        list.set(start, 0);
                    } else break;
                }
                break;
        }
        return;
    } // end of removeBeads
    private static void setIndex() {
        int nr = shark.r;
        int nc = shark.c;
        list.add(0);
        for (int i = 0; i < 2*N-1; i++) {
            int nd = i%4;
            int cnt = i/2 + 1;
            if(i == 2*N-2) cnt--;
            for (int j = 0; j < cnt; j++) {
                nr += dr[nd];
                nc += dc[nd];
                list.add(map[nr][nc]);
            }
        }
        return;
    } // end of setIndex
} // end of class