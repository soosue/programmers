package leetcode.array.search_insert_position_36;

public class Solution {
    /*
        풀이
        정렬된 배열에서 target이 존재하면 해당 인덱스, 존재하지 않으면 들어갈 위치 인덱스를 반환.

        우선 정렬된 배열이므로 binary search를 이용하면 시간복잡도를 O(n)에서 O(logn)으로 줄일 수 있다.
        1. 존재하면 target의 인덱스를 반환하는 것은 binary search로 return한다.
        2. 존재하지 않을 경우. 시작인덱스를 반환해주면 된다.
     */
    public int searchInsert(int[] nums, int target) {
        int s = 0;
        int e = nums.length - 1;

        while (s <= e) {
            int m = (s + e) / 2;

            if (target == nums[m])
                return m;
            else if (target < nums[m])
                e = m - 1;
            else if (nums[m] < target)
                s = m + 1;
        }
        return s;
    }
}