package Algorithm.Programmers.LEVEL1;

public class Solution_부족한금액계산하기 {
    public long solution(int price, int money, int count) {
        return money >= (long)count * (count+1) / 2 * price ? 0 : (long)count * (count+1) / 2 * price - money;
    }
}
