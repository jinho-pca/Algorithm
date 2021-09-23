package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_BOJ_3629_로봇프로젝트_골드4_이진호 {
    static int x, n;
    static int[] length;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        String input = "";
        while((input = br.readLine()) != null){
            search(input);
        }
    } // end of main
    private static void search(String input) throws IOException {
        x = Integer.parseInt(input) * 10000000;
        n = Integer.parseInt(br.readLine());
        length = new int[n];
        for (int i = 0; i < n; i++) {
            length[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(length);

        int left = 0;
        int right = n-1;

        while(left < right){
            if(length[left] + length[right] == x){
                System.out.println("yes " + length[left] + " " + length[right]);
                return;
            }else if(length[left] + length[right] < x){
                left++;
            }else right--;
        }
        System.out.println("danger");
        return;
    }
} // end of class