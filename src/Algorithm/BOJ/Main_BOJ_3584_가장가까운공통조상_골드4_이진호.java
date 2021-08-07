package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_BOJ_3584_가장가까운공통조상_골드4_이진호 {
    static int TC, N, x, y, result;
    static int[] tree;
    static boolean[] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        TC = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < TC; tc++) {
            result = 0;
            N = Integer.parseInt(br.readLine());
            tree = new int[N+1];
            check = new boolean[N+1];
            for (int i = 1; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int parent = Integer.parseInt(st.nextToken());
                int child = Integer.parseInt(st.nextToken());

                tree[child] = parent; // 인덱스 : 자식, 값 : 부모
            }
            st = new StringTokenizer(br.readLine(), " ");
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            result = find(x, y);
            sb.append(result).append("\n");
        } // end of for tc
        System.out.print(sb);
    } // end of main
    private static int find(int x, int y){
        int result = 0;
        ArrayList<Integer> xParent = new ArrayList<>();
        ArrayList<Integer> yParent = new ArrayList<>();
        xParent.add(x);
        yParent.add(y);
        int nextX = tree[x];
        int nextY = tree[y];
        while(nextX != 0){
            xParent.add(nextX);
            nextX = tree[nextX];
        }
        while(nextY != 0){
            yParent.add(nextY);
            nextY = tree[nextY];
        }
        if(xParent.size() <= yParent.size()){
            for (int i = 0; i < xParent.size(); i++) {
                check[xParent.get(i)] = true;
            }
            for (int i = 0; i < yParent.size(); i++) {
                if(check[yParent.get(i)]){
                    result = yParent.get(i);
                    break;
                }
            }
        }else{
            for (int i = 0; i < yParent.size(); i++) {
                check[yParent.get(i)] = true;
            }
            for (int i = 0; i < xParent.size(); i++) {
                if(check[xParent.get(i)]){
                    result = xParent.get(i);
                    break;
                }
            }
        }

        return result;
    }
} // end of class
