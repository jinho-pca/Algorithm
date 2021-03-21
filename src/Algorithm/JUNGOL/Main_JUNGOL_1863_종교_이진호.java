package Algorithm.JUNGOL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_JUNGOL_1863_종교_이진호 {

    static int n, m;
    static int[] parents;
    static boolean[] check;

    static void make(){ // 크기가 1인 단위집합을 만든다.
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
    }

    static int findSet(int a){
        if(parents[a] == a) return a;
//        return findSet(parents[a]); // path compression 전
        return parents[a] = findSet(parents[a]); // path compression 후(조사해온 형님을 내 형님으로 수정)
    }

    static boolean union(int a, int b){
        int aRoot = findSet(a);
        int bRoot = findSet(b);
        if(aRoot == bRoot) return false;

        parents[bRoot] = aRoot;
//        parents[aRoot] = bRoot;
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int cnt = 0;
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        parents = new int[n+1];
        // 1. make-set
        make();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b);
        }

        for (int i = 0; i < n+1; i++) {
            if(parents[i] ==i){
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
