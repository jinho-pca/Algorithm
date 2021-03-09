package Algorithm.BOJ;
/**
 * 5를 최대한 많이 써야한다.
 * 나머지가 0~4까지 가능하니까
 * 나머지 0 : 5로 다채운다.
 * 나머지 1 : 6빼고 나머지 5로 채운다.
 * 나머지 2 : 12빼고 나머지 5로 채운다.(예외 : 7)
 * 나머지 3 : 3빼고 나머지 5로 채운다.(예외 : 3)
 * 나머지 4 : 9빼고 나머지 5로 채운다.(예외 : 4)
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BOJ_2839_설탕배달_브론즈1_이진호 {
	public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int result = 0;
        int y = N % 5; // 가질 수 있는 값 : 0, 1, 2, 3, 4
        switch(y){
            case 0 :
                result = N / 5;
                break;
            case 1 :
                result = (N-6) / 5 + 2;
                break;
            case 2 :
                 if(N == 7){
                     result = -1;
                     break;
                 }else{
                     result = (N-12) / 5 + 4;
                     break;
                 }
            case 3 :
                result = (N-3) / 5 + 1;
                break;
            case 4 :
                if(N == 4){
                    result = -1;
                    break;
                }else{
                    result = (N-9) / 5 + 3;
                    break;
                }
        }
        System.out.println(result);
    }
}