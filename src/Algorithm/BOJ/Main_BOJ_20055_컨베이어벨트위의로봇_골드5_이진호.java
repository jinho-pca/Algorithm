package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_BOJ_20055_컨베이어벨트위의로봇_골드5_이진호 {
    static int N, K, cnt, result;
    static ArrayList<Point> belt = new ArrayList<>();
    static class Point {
        int durability; // 내구도
        boolean robot; // 로봇 유무
        public Point(int durability, boolean robot) {
            this.durability = durability;
            this.robot = robot;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 2 * N; i++) {
            Point point = new Point(Integer.parseInt(st.nextToken()), false);
            belt.add(point);
        }
        while(cnt < K) {
            cnt = 0;
            result++;
            // 한칸회전
            Point last = belt.get(2*N-1);
            belt.remove(2*N-1);
            belt.add(0, last);
            // N번째 칸의 로봇있다면 내리기
            if(belt.get(N-1).robot) belt.get(N-1).robot = false;
            // 로봇이동
            for (int i = N-2; i >= 0; i--) {
                if(belt.get(i).robot && !belt.get(i+1).robot && belt.get(i+1).durability >= 1) {
                    belt.get(i+1).robot = true;
                    belt.get(i).robot = false;
                    belt.get(i+1).durability--;
                }
            }
            // 로봇올리기
            Point first = belt.get(0);
            if(first.durability >= 1) {
                first.robot = true;
                first.durability--;
            }
            // N번째 칸의 로봇있다면 내리기
            if(belt.get(N-1).robot) belt.get(N-1).robot = false;
            // 내구도 0인칸 개수 갱신
            for (int i = 0; i < belt.size(); i++) {
                if(belt.get(i).durability == 0) cnt++;
            }
        }
        System.out.print(result);
    } // end of main
} // end of class
