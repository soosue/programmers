package leetcode.third_maximum_number_414;

public class Solution {

    /*
        int 배열 nums 가 주어졌을 때, 이 배열에서 세 번째로 큰 숫자를 return 하라.
        존재하지 않는다면, 제일 큰 숫자를 return 하라.

        O(n)
        최소값을 처리하기 위해 Integer 의 null 을 이용하거나 더 큰 범위 long 의 MIN_VALUE 를 이용한다.
     */
    public int thirdMax(int[] nums) {
        Integer first = null;
        Integer second = null;
        Integer third = null;

        for (Integer n : nums) {
            if (n.equals(first) || n.equals(second) || n.equals(third)) continue;
            if (first == null || n > first) {
                third = second;
                second = first;
                first = n;
            }else if (second == null || n > second) {
                third = second;
                second = n;
            }else if (third == null || n > third) {
                third = n;
            }
        }

        return third == null? first : third;
    }

    public int thirdMaxV2(int[] nums) {
        long first = Long.MIN_VALUE;
        long second = Long.MIN_VALUE;
        long third = Long.MIN_VALUE;

        for (long n : nums) {
            if (n == first || n == second || n == third) continue;
            if (n > first) {
                third = second;
                second = first;
                first = n;
            }else if (n > second) {
                third = second;
                second = n;
            }else if (n > third) {
                third = n;
            }
        }

        return third == Long.MIN_VALUE? (int)first : (int)third;
    }
}