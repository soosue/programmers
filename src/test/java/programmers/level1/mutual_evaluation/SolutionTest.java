package programmers.level1.mutual_evaluation;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    @Test
    void ex1() {
        assertThat(new Solution()
                .solution(new int[][]{{100,90,98,88,65},{50,45,99,85,77},{47,88,95,80,67},{61,57,100,80,65},{24,90,94,75,65}}))
                .isEqualTo("FBABD");
    }

    @Test
    void ex2() {
        assertThat(new Solution()
                .solution(new int[][]{{50, 90}, {50, 87}}))
                .isEqualTo("DA");
    }

    @Test
    void ex3() {
        assertThat(new Solution()
                .solution(new int[][]{{70, 49, 90}, {68, 50, 38}, {73, 31, 100}}))
                .isEqualTo("CFD");
    }

    /*
        자신이 유일 최고점
        유일 최저점
        동시 최고점
        동시 최저점
        유일 중간점
        동시 중간점
     */
    @Test
    void ex4() {
        assertThat(new Solution()
                .solution(new int[][]{
                        {99, 99, 99, 99, 99, 99},
                        {50, 50, 50, 99, 50, 99},
                        {50, 99, 99, 50, 50, 50},
                        {50, 99, 50, 50, 50, 50},
                        {50, 99, 50, 99, 75, 75},
                        {50, 99, 50, 99, 99, 75}}
                        ))
                .isEqualTo("DADBCC");
    }

    @Test
    void ex5() {
        assertThat(new Solution()
        .solution(new int[][]{
                {75, 50, 100},
                {75, 100, 20},
                {100, 100, 20}
        })).isEqualTo("BBF");
    }
}