package programmers.level2.hopscotch;

public class Solution {
    /*
        풀이
        각 위치까지 오는데 가질 수 있는 최댓값을 계산하면서 내려감
        첫째 줄 땅은 각자의 점수.
        두번째 줄 땅은 첫번째줄 점수의 최댓값(자기 열은 제외) + 각자의 점수.
        세번째 줄 땅은 두번째줄 점수의 최댓값(자기 열은 제외) + 각자의 점수.
        ... 반복된다ㅏ.

        땅의 크기가 m x n라 하면, O(mnn).

        고려사항.
        1. 문제에서 n은 4로 고정값.
        2. 바로 위에서 자신의 열은 밟을 수 없음.
     */
    public int solution(int[][] land) {
        for (int i = 1; i < land.length; i++) {
            for (int j = 0; j < land[i].length; j++) {
                int max = 0;
                for (int k = 0; k < land[i - 1].length; k++) {
                    if (j != k)
                        max = Math.max(max, land[i - 1][k]);
                }
                land[i][j] += max;
            }
        }

        int max = 0;
        for (int n : land[land.length - 1])
            max = Math.max(max, n);

        return max;
    }
}
