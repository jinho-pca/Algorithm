package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main_BOJ_15787_기차가어둠을헤치고은하수를_실버2_이진호 {
    static int N, M;
    static int[][] train;
    static HashSet<String> list = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        train = new int[N+1][21];
        for (int cmd = 0; cmd < M; cmd++) {
            st = new StringTokenizer(br.readLine(), " ");
            int kind = Integer.parseInt(st.nextToken());
            int i = Integer.parseInt(st.nextToken());
            int x = 0;
            if(st.hasMoreTokens())
                x = Integer.parseInt(st.nextToken());

            switch (kind){
                case 1:
                    train[i][x] = 1;
                    break;
                case 2:
                    train[i][x] = 0;
                    break;
                case 3:
                    for (int j = 20; j >= 2; j--) {
                        train[i][j] = train[i][j-1];
                    }
                    train[i][1] = 0;
                    break;
                case 4:
                    for (int j = 1; j < 20; j++) {
                        train[i][j] = train[i][j+1];
                    }
                    train[i][20] = 0;
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb = new StringBuilder();
            for (int j = 1; j < 21; j++) {
                sb.append(train[i][j]);
            }
            list.add(sb.toString());
        }
        System.out.print(list.size());
    } // end of main
} // end of class
