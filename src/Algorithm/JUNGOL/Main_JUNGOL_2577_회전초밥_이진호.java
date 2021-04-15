package Algorithm.JUNGOL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
807ms
 */
public class Main_JUNGOL_2577_회전초밥_이진호 {
    static int N, d, k, c, result, plus;
    static int[] arr, check, max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new int[N + k - 1];
        check = new int[d+1];
        check[c] = 1;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        for (int i = N; i < N+k-1; i++) {
            arr[i] = arr[i-N];
        }

        int start = 1;
        for (int i = 0; i < k; i++) {
            if(check[arr[i]] == 0) start++;
            check[arr[i]]++;
        }
        result = start;

        for (int i = 0; i < N-1; i++) {
            check[arr[i]]--;
            if(check[arr[i]] == 0){
                start--;
            }

            if(check[arr[i + k]] == 0){
                start++;
                result = result < start ? start : result;
            }
            check[arr[i + k]]++;


        }

        System.out.print(result);
    } // end of main
} // end of class
