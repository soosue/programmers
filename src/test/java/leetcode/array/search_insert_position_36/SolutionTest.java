package leetcode.array.search_insert_position_36;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    @Test
    void ex1() {
        assertThat(new Solution().searchInsert(new int[]{1, 3, 5, 6}, 5))
                .isEqualTo(2);
    }
    @Test
    void ex2() {
        assertThat(new Solution().searchInsert(new int[]{1,3,5,6}, 2))
                .isEqualTo(1);
    }
    @Test
    void ex3() {
        assertThat(new Solution().searchInsert(new int[]{1,3,5,6}, 7))
                .isEqualTo(4);
    }
    @Test
    void ex4() {
        assertThat(new Solution().searchInsert(new int[]{1,3,5,6}, 0))
                .isEqualTo(0);
    }
    @Test
    void ex5() {
        assertThat(new Solution().searchInsert(new int[]{1}, 0))
                .isEqualTo(0);
    }
}