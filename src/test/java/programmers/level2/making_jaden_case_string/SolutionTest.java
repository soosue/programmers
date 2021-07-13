package programmers.level2.making_jaden_case_string;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    @Test
    void ex1() {
        assertThat(new Solution()
                .solution("3people unFollowed me"))
                .isEqualTo("3people Unfollowed Me");
    }

    @Test
    void ex2() {
        assertThat(new Solution()
                .solution("for the last week"))
                .isEqualTo("For The Last Week");
    }

    @Test
    void ex3() {
        assertThat(new Solution()
                .solution("aaa aaaaa"))
                .isEqualTo("Aaa Aaaaa");
    }
}