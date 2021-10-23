package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main_BOJ_3052_나머지_브론즈2_이진호 {
    static HashSet<Integer> set = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            int A = Integer.parseInt(br.readLine());
            set.add(A % 42);
        }
        System.out.println(set.size());
    }
}
