package programmers.level2.checking_social_distance;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    @Test
    void ex1() {
        assertThat(new Solution()
                .solution(new String[][]
                        {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}}))
                .isEqualTo(new int[]{1, 0, 1, 1, 1});
    }

    @Test
    void ex2() {
        assertThat(new Solution()
                .solution(new String[][]
                        {
                                {
                                        "POOPO",
                                        "OXPXX",
                                        "OPXPX",
                                        "OOXOX",
                                        "POXXP"
                                },
                                {
                                        "POOPX",
                                        "OXPXP",
                                        "PXXXO",
                                        "OXXXO",
                                        "OOOPP"
                                },
                                {
                                        "PXOPX",
                                        "OXOXP",
                                        "OXPOX",
                                        "OXXOP",
                                        "PXPOX"
                                },
                                {
                                        "OOOXX",
                                        "XOOOX",
                                        "OOOXX",
                                        "OXOOX",
                                        "OOOOO"
                                },
                                {
                                        "PXPXP",
                                        "XPXPX",
                                        "PXPXP",
                                        "XPXPX",
                                        "PXPXP"
                                }}))
                .isEqualTo(new int[]{0, 0, 1, 1, 1});
    }
}