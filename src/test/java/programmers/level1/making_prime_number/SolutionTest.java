package programmers.level1.making_prime_number;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    @Test
    void ex1() {
        assertThat(new Solution()
                .solution(new int[]{1, 2, 3, 4}))
                .isEqualTo(1);
    }
    @Test
    void ex2() {
        assertThat(new Solution()
                .solution(new int[]{1, 2, 7, 6, 4}))
                .isEqualTo(4);
    }
}