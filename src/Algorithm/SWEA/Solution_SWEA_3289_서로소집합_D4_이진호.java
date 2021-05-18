package Algorithm.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_3289_서로소집합_D4_이진호 {
    static int n, m;
    static int[] parents;

    static void make() {
        for (int i = 0; i <= n; i++) {
            parents[i] = i;
        }
    }

    static int findSet(int a) {
        if (parents[a] == a) return a;
        return parents[a] = findSet(parents[a]);
    }

    static boolean union(int a, int b) {
        int aRoot = findSet(a);
        int bRoot = findSet(b);
        if (aRoot == bRoot) return false;

        parents[bRoot] = aRoot;
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= TC; testCase++) {
            sb.append("#").append(testCase).append(" ");
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            parents = new int[n+1];
            make();

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int kind = Integer.parseInt(st.nextToken());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                switch (kind) {
                    case 0: // 합집합
                        union(a, b);
                        break;
                    case 1: // 같은집합인지 판단
                        if (findSet(a) == findSet(b)) {
                            sb.append(1);
                        } else {
                            sb.append(0);
                        }
                        break;
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
