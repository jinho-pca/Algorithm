package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_17141_연구소2_골드5_이진호 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N, M, count = 0, answer = Integer.MAX_VALUE;
    private static int[][] map;
    private static boolean[] visited;
    private static ArrayList<int[]> virus = new ArrayList<>();
    private static final int[] dr = {-1, 1, 0, 0};
    private static final int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                map[i][j] = tmp;
                if (tmp == 2) virus.add(new int[] {i, j});
                if (tmp == 0) count++;
            }
        }

        count += virus.size() - M;
        visited = new boolean[virus.size()];

        if (count == 0) answer = 0;
        else combination(0, 0);

        System.out.println((answer == Integer.MAX_VALUE) ? -1 : answer);
    }

    private static void combination(int depth, int start) {
        if (depth == M) {
            int[][] copyMap = copy();
            bfs(copyMap, count);
            return;
        }

        for (int i = start; i < virus.size(); i++) {
            visited[i] = true;
            combination(depth + 1, i + 1);
            visited[i] = false;
        }
    }

    private static void bfs(int[][] map, int count) {
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < virus.size(); i++) {
            if (visited[i]) queue.add(virus.get(i));
        }

        int time = 0;
        while (!queue.isEmpty()) {
            if (answer <= time) break; // 해당 조합은 이전 조합보다 느리다는 뜻.

            int len = queue.size();
            for (int t = 0; t < len; t++) { // 시작 지점이 여러 개이기 때문에 반복문으로 한 번더 감싼다.
                int[] now = queue.poll();

                for (int i = 0; i < 4; i++) {
                    int nr = now[0] + dr[i];
                    int nc = now[1] + dc[i];

                    if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                    if (map[nr][nc] != 0) continue;

                    map[nr][nc] = 2;
                    queue.add(new int[] {nr, nc});
                    count--; // 지날 수 있는 길 -1
                }
            }

            time++;
            if (count == 0) { // 더이상 지날 수 있는 길이 없다면 (탐색 가능한 길이 없다면)
                answer = time;
                return;
            }
        }
    }

    private static int[][] copy() {
        int[][] tmpMap = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                tmpMap[i][j] = (map[i][j] == 2 ? 0 : map[i][j]);
        }

        for (int i = 0; i < virus.size(); i++) {
            if (visited[i]) {
                int[] v = virus.get(i);
                tmpMap[v[0]][v[1]] = 2;
            }
        }

        return tmpMap;
    }
}