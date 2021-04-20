package Algorithm.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_8382_방향전환_D4_이진호 {
    static int[] start, end;
    static int dx, dy, result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= TC; tc++) {
            start = new int[2];
            end = new int[2];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            start[0] = Integer.parseInt(st.nextToken());
            start[1] = Integer.parseInt(st.nextToken());
            end[0] = Integer.parseInt(st.nextToken());
            end[1] = Integer.parseInt(st.nextToken());
            dx = Math.abs(start[0] - end[0]);
            dy = Math.abs(start[1] - end[1]);
            result = dx + dy + Math.abs(dx - dy) / 2 * 2;
            sb.append("#").append(tc).append(" ").append(result).append("\n");
        } // end of for tc
        System.out.print(sb);
    } // end of main
} // end of class
