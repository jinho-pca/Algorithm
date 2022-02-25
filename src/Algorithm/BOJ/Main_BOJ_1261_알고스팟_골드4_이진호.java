package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_BOJ_1261_알고스팟_골드4_이진호 {
    static int N, M, result;
    static int[][] map, distance;
    static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};
    static class Node {
        int r;
        int c;
        int cost;

        public Node(int r, int c, int cost) {
            this.r = r;
            this.c = c;
            this.cost = cost;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        distance = new int[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j) - '0';
                distance[i][j] = Integer.MAX_VALUE;
            }
        }
        dijkstra();
        System.out.print(result);
    } // end of main
    private static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        distance[0][0] = 0;
        pq.offer(new Node(0, 0, 0));
        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            if(cur.r == N-1 && cur.c == M-1) {
                result = cur.cost;
                return;
            }
            for (int i = 0; i < 4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                if(nr >= 0 && nr < N && nc >= 0 && nc < M) {
                    int cost = map[nr][nc];
                    if(distance[nr][nc] > cur.cost + cost) {
                        distance[nr][nc] = cur.cost + cost;
                        pq.offer(new Node(nr, nc, distance[nr][nc]));

                    }
                }
            }
        }
    }
} // end of class
