package programmers.level1.calculating_insufficient_cash;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    @Test
    void ex1() {
        assertThat(new Solution().solution(3, 20, 4))
                .isEqualTo(10);
    }
}