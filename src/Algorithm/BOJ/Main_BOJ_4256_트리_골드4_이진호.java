package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_4256_트리_골드4_이진호 {
    static int N, M;
    static int[] preorder, inorder;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < N; tc++) {
            M = Integer.parseInt(br.readLine());
            preorder = new int[M];
            inorder = new int[M];
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < M; i++) {
                preorder[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < M; i++) {
                inorder[i] = Integer.parseInt(st.nextToken());
            }
            find(0, 0, M);
            sb.append("\n");
        }
        System.out.print(sb.toString());
    } // end of main
    private static void find(int v, int l, int r){
        for (int i = l; i < r; i++) {
            if(inorder[i] == preorder[v]){
                find(v + 1, l, i);
                find(v + (i - l) + 1, i+1, r);
                sb.append(preorder[v]).append(" ");
            }
        }
    } // end of find
} // end of class
