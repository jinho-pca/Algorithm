package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
84ms
 */
public class Main_BOJ_2564_경비원_실버1_이진호 {
    static int N, M, K, result;
    static int[][] point;
    static int[] man;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());
        point = new int[K][2];
        man = new int[2];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            point[i][0] = Integer.parseInt(st.nextToken());
            point[i][1] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        man[0] = Integer.parseInt(st.nextToken());
        man[1] = Integer.parseInt(st.nextToken());

        for (int i = 0; i < K; i++) {
            if((point[i][0] == 1 && man[0] == 2) || (point[i][0] == 2 && man[0] == 1)){ // 남북 평행한 경우
                result += Math.min(M + point[i][1] + man[1], M+(N-point[i][1]) + (N-man[1]));
            }else if((point[i][0] == 3 && man[0] == 4) || (point[i][0] == 4 && man[0] == 3)){ // 동서 평행한 경우
                result += Math.min(N+point[i][1] + man[1], N+(M-point[i][1]) + (M-man[1]));
            }else{ // 그 외
                result += Math.abs(change(point[i])[1] - change(man)[1]) + Math.abs(change(point[i])[0] - change(man)[0]);
            }
        }
        System.out.println(result);
    } // end of main
    private static int[] change(int[] point){
        int[] result = new int[2];
        switch(point[0]){
            case 1:
                result =  new int[]{point[1], M};
                break;
            case 2:
                result = new int[]{point[1], 0};
                break;
            case 3:
                result = new int[]{0, M-point[1]};
                break;
            case 4:
                result = new int[]{N, M-point[1]};
                break;
        }
        return result;
    } // end of change
} // end of class
