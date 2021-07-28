package programmers.level2.finding_prime_number;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    @Test
    void ex1() {
        assertThat(new Solution().solution("17")).isEqualTo(3);
    }
    @Test
    void ex2() {
        assertThat(new Solution().solution("011")).isEqualTo(2);
    }
    @Test
    void ex3() {
        assertThat(new Solution().solution("123")).isEqualTo(5);
    }
    @Test
    void ex4() {
        assertThat(new Solution().solution("12")).isEqualTo(1);
    }
    @Test
    void ex5() {
        assertThat(new Solution().solution("1")).isEqualTo(0);
    }
}