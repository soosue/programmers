package swexpert.test.coin_exchange;

public class Solution {
    public static void main(String[] args) {
        // 사용할 수 있는 동전 : 1원, 4원, 6원
        // 거스름돈 8원에 대한 최소 동전 개수는 몇 개일까?

        // 8원에 대한 최소 동전 개수는 1원 + 7원 or 4원 + 4원 or 6원 + 2원
        int[] ex = new int[]{1, 4, 6};

        int n = 8;
        int[] memo = new int[8 + 1];


        for (int i = 1; i < memo.length; i++) {
            int min = n;
            for (int j = 0; j < ex.length; j++) {
                if (i - ex[j] >= 0) {
                    min = Math.min(min, memo[i - ex[j]]);
                }
            }
            memo[i] = min + 1;
        }
        System.out.println(n + "원의 최소 거스름 동전 개수: " + memo[n]);


    }
}
