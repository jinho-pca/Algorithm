package Algorithm.Programmers.LEVEL1;

import java.time.LocalDate;

public class Solution_2016년 {
    public String solution(int a, int b) {
        String[] days = {"","MON","TUE","WED","THU","FRI","SAT","SUN"};
        LocalDate date = LocalDate.of(2016, a, b);
        return days[date.getDayOfWeek().getValue()];
    }
}
