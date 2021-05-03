package swexpert.test.nth_rabbit;

public class Solution {
    public static void main(String[] args) {

        int n = 12;
        int[] rabbit = new int[n];
        rabbit[1] = 1;
        rabbit[2] = 1;
        rabbit[3] = 2;
        rabbit[4] = 3;
        rabbit[5] = 5;
        rabbit[6] = 8;

        for (int i = 3; i < n; i++) {
            rabbit[i] = rabbit[i - 1] + rabbit[i - 2];
        }

        StringBuilder sb = new StringBuilder();
        for (int i : rabbit) {
            sb.append(i).append(" ");
        }
        System.out.println(sb.toString());
    }
}
