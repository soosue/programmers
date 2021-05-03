package swexpert.test.binomial_coefficient;

public class Solution {
    public static void main(String[] args) {
        //b(n, r) = b(n-1, r-1) + b(n-1, r)
        //b(5, 3)을 구하라
        int l = 5 + 1;
        int r = 3;
        int[][] memo = new int[l][l];


        for (int i = 0; i < l; i++) {
            int min = Math.min(i, r);
            for (int j = 0; j <= min; j++) {
                if (j == 0 || i == j) memo[i][j] = 1;
                else memo[i][j] = memo[i - 1][j - 1] + memo[i - 1][j];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
                sb.append(memo[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
