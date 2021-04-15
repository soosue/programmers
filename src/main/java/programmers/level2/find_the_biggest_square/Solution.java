package programmers.level2.find_the_biggest_square;

public class Solution {
    int[][] map;
    public int solution(int [][]board) {

        int row = board.length;
        int col = board[0].length;
        map = new int[row+1][col+1]; //border trick

        int size = 0;

        // O(mn)
        for (int i = 1; i <= row; i++) { //border trick
            for (int j = 1; j <= col; j++) { //border trick
                if (board[i-1][j-1] != 0) { //border trick
                    map[i][j] = Math.min(Math.min(map[i][j-1], map[i-1][j]), map[i-1][j-1]) + 1;
                    size = size > map[i][j] ? size : map[i][j];
                }
            }
        }

        int answer = (int)Math.pow(size, 2);
        return answer;
    }
}
