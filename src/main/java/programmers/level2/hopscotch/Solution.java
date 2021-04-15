package programmers.level2.hopscotch;

public class Solution {
    int[][] map;
    int solution(int[][] land) {

        int row = land.length;
        int col = land[0].length;
        int scoreHigh = 0;
        map = new int[row][col];

        for (int i = 0; i < col; i++)
            map[0][i] = land[0][i];

        // O(mn)
        for (int i = 1; i < row; i++)
            for (int j = 0; j < col; j++)
                for (int k=0; k<col; k++)
                    if (k != j)
                        map[i][j] = Math.max(map[i][j], map[i-1][k]+ land[i][j]) ;

        for (int i = 0; i < col; i++)
            scoreHigh = Math.max(scoreHigh, map[row-1][i]);

        return scoreHigh;
    }

//    int solution(int[][] land) {
//        int row = land.length;
//        int col = land[0].length;
//
//        map = new int[row+1][col];
//
//        int scoreHigh = 0;
//        for (int i = 1; i <= row; i++)
//            for (int j = 0; j < col; j++)
//                map[i][j] = getPrevScore(i, j) + land[i-1][j];
//
//        for (int i = 0; i < col; i++)
//            scoreHigh = Math.max(scoreHigh, map[row][i]);
//
//        return scoreHigh;
//    }
//
//    private int getPrevScore(int i, int j) {
//        int max = 0;
//        for (int k = 0; k < 4; k++)
//            if (k != j)
//                max = Math.max(max, map[i-1][k]);
//
//        return max;
//    }
}
