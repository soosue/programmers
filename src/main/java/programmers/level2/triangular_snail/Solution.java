package programmers.level2.triangular_snail;

public class Solution {
    public int[] solution(int n) {
        int[] answer = new int[n*(n+1)/2];
        int[][] map = new int[n][n];

        int x = -1, y = 0;

        for (int i = 0, num = 1; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i % 3 == 0) {
                    x++;
                }else if (i % 3 == 1) {
                    y++;
                }else if (i % 3 == 2) {
                    x--;
                    y--;
                }
                map[x][y] = num++;
            }
        }

        for (int i = 0, k = 0; i < n; i++) {
            for (int j = 0; j < i+1; j++) {
                answer[k++] = map[i][j];
            }
        }

        return answer;
    }
}