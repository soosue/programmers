package programmers.level2.number_of_124country;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    @Test
    void ex1() {
        assertThat(new Solution()
                .solution(1))
                .isEqualTo("1");
    }
    @Test
    void ex2() {
        assertThat(new Solution()
                .solution(2))
                .isEqualTo("2");
    }
    @Test
    void ex3() {
        assertThat(new Solution()
                .solution(3))
                .isEqualTo("4");
    }
    @Test
    void ex4() {
        assertThat(new Solution()
                .solution(4))
                .isEqualTo("11");
    }
    @Test
    void ex5() {
        assertThat(new Solution()
                .solution(23))
                .isEqualTo("212");
    }
    @Test
    void ex6() {
        assertThat(new Solution()
                .solution(24))
                .isEqualTo("214");
    }
    @Test
    void ex7() {
        assertThat(new Solution()
                .solution(25))
                .isEqualTo("221");
    }
    @Test
    void ex8() {
        assertThat(new Solution()
                .solution(36))
                .isEqualTo("424");
    }
    @Test
    void ex9() {
        assertThat(new Solution()
                .solution(37))
                .isEqualTo("441");
    }
    @Test
    void ex10() {
        assertThat(new Solution()
                .solution(38))
                .isEqualTo("442");
    }
    @Test
    void ex11() {
        assertThat(new Solution()
                .solution(39))
                .isEqualTo("444");
    }
    @Test
    void ex12() {
        assertThat(new Solution()
                .solution(40))
                .isEqualTo("1111");
    }
}