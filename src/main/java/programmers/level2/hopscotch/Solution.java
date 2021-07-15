package programmers.level2.hopscotch;

public class Solution {
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
