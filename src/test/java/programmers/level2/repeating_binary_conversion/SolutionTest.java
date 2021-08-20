package programmers.level2.repeating_binary_conversion;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    @Test
    void ex1() {
        assertThat(new Solution().solution("110010101001")).isEqualTo(new int[]{3, 8});
    }

    @Test
    void ex2() {
        assertThat(new Solution().solution("01110")).isEqualTo(new int[]{3, 3});
    }

    @Test
    void ex3() {
        assertThat(new Solution().solution("1111111")).isEqualTo(new int[]{4, 1});
    }
}