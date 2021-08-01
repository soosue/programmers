package programmers.level1.making_prime_number;

public class Solution {
    /*
        풀이
        주어진 nums 중 3개를 뽑아 더해 소수가 되는지 확인.
        -> 조합 문제, 순서 상관x

        문제 조건에 중복된 숫자는 주어지지 않는다.
        단순 조합으로 3개 선택 후 합이 소수인지 확인 후, 더해주는 방식으로 진행한다.
     */
    public int solution(int[] nums) {
        return comb(nums, 0, 0, 3, 0);
    }

    private int comb(int[] nums, int depth, int sum, int limit, int counted) {
        if (counted == limit) {
            if (isPrimeNumber(sum))
                return 1;
            else
                return 0;
        }else if (depth >= nums.length) {
            return 0;
        }

        return comb(nums, depth + 1, sum + nums[depth], limit, counted + 1) + comb(nums, depth + 1, sum, limit, counted);
    }

    private boolean isPrimeNumber(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }
        return n > 1;
    }
}