package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_BOJ_21608_상어초등학교_실버1_이진호 {
    static int N, len, result;
    static int[] students; // 학생 순서
    static ArrayList<Integer>[] likeList; // 좋아하는 학생 리스트
    static int[][] map; // 자리배열
    static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};
    static int[] score = {0, 1, 10, 100, 1000}; // 점수배열
    static PriorityQueue<Point> pq = new PriorityQueue<>((o1, o2) -> {
        int diff1 = o2.like - o1.like;
        int diff2 = o2.blank - o1.blank;
        int diff3 = o1.r - o2.r;
        if(diff1 == 0) {
            if(diff2 == 0) {
                if(diff3 == 0) return o1.c - o2.c;
                else return diff3;
            } else return diff2;
        } else return diff1;
    });
    static class Point {
        int r;
        int c;
        int like; // 인접한 좋아하는 학생 수
        int blank; // 인접한 빈칸의 수

        public Point(int r, int c, int[] likeAndBlank) {
            this.r = r;
            this.c = c;
            this.like = likeAndBlank[0];
            this.blank = likeAndBlank[1];
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        len = N * N;
        students = new int[len+1]; // 학생순서대로 변호저장
        map = new int[N+1][N+1]; // 책상
        likeList = new ArrayList[len+1]; // 학생순서별 좋아하는학생들 리스트
        for (int i = 1; i <= len; i++) {
            likeList[i] = new ArrayList<>();
        }

        for (int i = 1; i <= len; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int student = Integer.parseInt(st.nextToken());
            students[i] = student;
            for (int j = 0; j < 4; j++) {
                likeList[student].add(Integer.parseInt(st.nextToken()));
            }
        }

        // 학생하나씩 뽑아서 빈칸마다 정보갱신해서 우선순위큐에 넣고 꺼내면 최적의 자리가 나오니까 map 갱신
        for (int t = 1; t <= len; t++) {
            pq.clear();
            int student = students[t];
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if(map[i][j] == 0) pq.offer(new Point(i, j, calc(student, i, j)));
                }
            }
            Point seat = pq.poll(); // 최적의 자리
            map[seat.r][seat.c] = student; // 자리지정
        }

        // 점수계산
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                result += score[calc(map[i][j], i, j)[0]];
            }
        }

        System.out.print(result);
    } // end of main
    private static int[] calc(int number, int r, int c) {
        int like = 0, blank = 0;
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if(nr > 0 && nr <= N && nc > 0 && nc <= N) {
                if(map[nr][nc] > 0 && likeList[number].contains(map[nr][nc])) like++;
                else if(map[nr][nc] == 0) blank++;
            }
        }
        return new int[] {like, blank};
    } // end of calc
} // end of class
