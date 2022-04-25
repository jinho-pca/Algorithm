package Algorithm.Programmers.LEVEL2;

import java.util.*;
public class Solution_카카오프렌즈컬러링북 {
    static int[] dr ={-1, 1, 0, 0};
    static int[] dc ={0, 0, -1, 1};
    static boolean[][] visited;
    static int R, C, numberOfArea, maxSizeOfOneArea;
    public int[] solution(int m, int n, int[][] picture) {
        numberOfArea = 0;
        maxSizeOfOneArea = 0;
        R = m;
        C = n;
        visited = new boolean[R][C];
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if(visited[i][j]) continue;
                if(picture[i][j] != 0) {
                    bfs(i, j, picture);
                    numberOfArea++;
                }
            }
        }

        return new int[] {numberOfArea, maxSizeOfOneArea};
    }
    private static void bfs(int r, int c, int[][]picture) {
        int area = 0;
        int number = picture[r][c];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {r, c});
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            for(int i = 0; i < 4; i++) {
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];

                if(nr >= 0 && nr < R && nc >= 0 && nc < C && !visited[nr][nc] && picture[nr][nc] == number) {
                    area++;
                    visited[nr][nc] = true;
                    queue.offer(new int[] {nr, nc});
                }
            }
        }
        maxSizeOfOneArea = Math.max(maxSizeOfOneArea, area);
    }
}
