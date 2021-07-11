package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_BOJ_5639_이진검색트리_실버1_이진호 {
    static int N;
    static int[] preorder = new int[10001];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while(true){
            input = br.readLine();
            if(input == null || input.equals("")) break;
            preorder[N++] = Integer.parseInt(input);
        }
        find(0, N-1);
        System.out.print(sb);
    } // end of main
    private static void find(int left, int right){
        if(left > right) return;
        int root = left;
        int start = left;
        int end = right;
        while(preorder[start] >= preorder[root]) start++;
        while(preorder[end] > preorder[root]) end--;
        find(start, end);
        find(end + 1,right);
        sb.append(preorder[root]).append("\n");
    } // end of find
} // end of class
