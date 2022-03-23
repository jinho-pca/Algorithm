package Algorithm.Programmers.LEVEL1;

import java.util.Stack;

public class Solution_크레인인형뽑기게임 {
    public int solution(int[][] board, int[] moves) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int N = board.length;
        int answer = 0;
        for(int move : moves) {
            for(int i = 0; i < N; i++) {
                if(board[i][move-1] != 0) {
                    if(stack.peek() == board[i][move-1]) {
                        stack.pop();
                        answer+=2;
                    }else {
                        stack.push(board[i][move-1]);
                    }
                    board[i][move-1] = 0;
                    break;
                }
            }
        }
        return answer;
    }
}
