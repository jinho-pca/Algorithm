package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_BOJ_3190_뱀_골드5_이진호 {
    static int N, K, L, result;
    static int[] dir = {0, 0}; // dr, dc 의 인덱스를 담는다.
    static int[][] map;
    static Deque<Point> snake = new ArrayDeque<>();
    static Queue<Command> command = new LinkedList<>();
    static int[] dr = {0, 1, 0, -1}, dc = {1, 0, -1, 0}; // 우하좌상
    static class Point {
        int r;
        int c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
        @Override
        public boolean equals(Object o) {
            if(o instanceof Point) {
                Point p = (Point) o;
                return this.r == p.r && this.c == p.c;
            }
            return false;
        }
        @Override
        public int hashCode() {
            return Objects.hash(r, c);
        }
    }
    static class Command {
        int time;
        char direction;

        public Command(int time, char direction) {
            this.time = time;
            this.direction = direction;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            map[r][c] = 1;
        }
        L = Integer.parseInt(br.readLine());
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int time = Integer.parseInt(st.nextToken());
            char direction = st.nextToken().charAt(0);
            command.offer(new Command(time, direction));
        }

        snake.addFirst(new Point(0, 0));

        while(true) {
            result++;
            boolean finish = move();
            if(finish) break;
            if(!command.isEmpty() && command.peek().time == result) {
                // 방향전환이 이루어 지는 경우
                Command cmd = command.poll();
                switch(cmd.direction) {
                    case 'D': // 오른쪽
                        dir[0] = (dir[0]+1) % 4;
                        dir[1] = (dir[1]+1) % 4;
                        break;
                    case 'L': // 왼쪽
                        dir[0] = (dir[0]+3) % 4;
                        dir[1] = (dir[1]+3) % 4;
                        break;
                }
            }
        }
        System.out.print(result);
    } // end of main
    private static boolean move() {
        Point head = snake.peekFirst(); // 뱀의 머리
        int nr = head.r + dr[dir[0]];
        int nc = head.c + dc[dir[1]];
        if(nr < 0 || nr >= N || nc < 0 || nc >= N) return true;
        Point nextHead = new Point(nr, nc);
        if(snake.contains(nextHead)) return true;

        snake.addFirst(nextHead); // 뱀의 머리 길이를 늘린다.
        if(map[nextHead.r][nextHead.c] == 1) {
            // 사과가 있는경우
            map[nextHead.r][nextHead.c] = 0;
        } else {
            snake.pollLast();
        }
        return false;
    } // end of move
} // end of class
