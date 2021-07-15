package programmers.level2.visited_length;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    @Test
    void ex1() {
        assertThat(new Solution()
                .solution("ULURRDLLU"))
                .isEqualTo(7);
    }

    @Test
    void ex2() {
        assertThat(new Solution()
                .solution("LULLLLLLU"))
                .isEqualTo(7);
    }

    @Test
    void ex3() {
        assertThat(new Solution()
                .solution("LRLRLR"))
                .isEqualTo(1);
    }
}