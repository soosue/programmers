package programmers.level2.carpet;

public class Solution {
    /*
        풀이
        yellow가 될 수 있는 가지수를 먼저 만들어본다.
        각각의 가지수가 가질 수 있는 brown을 계산하고, 주어진 값과 맞나 비교한다.
     */
    public int[] solution(int brown, int yellow) {
        for (int i = yellow; i >= 1;  i--) {
            if (yellow % i == 0 && calBrown(i, yellow / i) == brown) {
                return new int[]{i + 2, yellow / i + 2};
            }
        }
        return null;
    }

    private int calBrown(int width, int height) {
        return 4 + (width + height) * 2;
    }
}