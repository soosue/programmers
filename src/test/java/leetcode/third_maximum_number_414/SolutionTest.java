package leetcode.third_maximum_number_414;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    @Test
    void ex1() {
        assertThat(new Solution().thirdMax(new int[]{3, 2, 1})).isEqualTo(1);
    }

    @Test
    void ex2() {
        assertThat(new Solution().thirdMax(new int[]{1, 2})).isEqualTo(2);
    }

    @Test
    void ex3() {
        assertThat(new Solution().thirdMax(new int[]{2, 2, 3, 1})).isEqualTo(1);
    }

    @Test
    void ex4() {
        assertThat(new Solution().thirdMax(new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE, 1})).isEqualTo(1);
    }

    @Test
    void ex5() {
        assertThat(new Solution().thirdMax(new int[]{Integer.MIN_VALUE, 2, 1})).isEqualTo(Integer.MIN_VALUE);
    }
}