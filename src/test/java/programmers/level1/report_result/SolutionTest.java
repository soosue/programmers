package programmers.level1.report_result;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void reporters_reportCounts() {
        String[] idList = {"muzi", "frodo", "apeach", "neo"};
        String[] reports = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};

        IntegratedReports integratedReports = new IntegratedReports(reports);
        StoppedUsers stoppedUsers = integratedReports.stoppedUsers(2);

        Reporters reporters = new Reporters(reports);
        int[] result = reporters.reportCounts(idList, stoppedUsers);

        assertThat(result).containsExactly(2, 1, 1, 0);
    }

    @Test
    void integratedReports_stoppedUsers() {
        IntegratedReports integratedReports = new IntegratedReports(
                new String[]{"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"}
        );

        StoppedUsers stoppedUsers = integratedReports.stoppedUsers(2);
        assertThat(stoppedUsers.contains("frodo")).isTrue();
        assertThat(stoppedUsers.contains("neo")).isTrue();
        assertThat(stoppedUsers.contains("apeach")).isFalse();
        assertThat(stoppedUsers.contains("muzi")).isFalse();
    }

    @Test
    void integratedReports() {
        IntegratedReports integratedReports = new IntegratedReports(
                new String[]{"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"}
                );

        assertThat(integratedReports.getReportedUsers().get("frodo")).isEqualTo(2);
        assertThat(integratedReports.getReportedUsers().get("neo")).isEqualTo(2);
        assertThat(integratedReports.getReportedUsers().get("muzi")).isEqualTo(1);
    }

    @Test
    void reportersTest() {
        Reporters reporters = new Reporters(new String[]{"aa bb", "aa cc", "bb aa"});

        assertThat(reporters.getReporter().get("aa")).contains("cc", "bb");
        assertThat(reporters.getReporter().get("bb")).contains("aa");
    }


    @Test
    public void test1() {
        String[] idList = {"muzi", "frodo", "apeach", "neo"};
        String[] reports = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        int k = 2;

        int[] result = this.solution.solution(idList, reports, k);
        assertThat(result).containsExactly(2, 1, 1, 0);
    }

    @Test
    public void test2() {
        String[] idList = {"con", "ryan"};
        String[] reports = {"ryan con", "ryan con", "ryan con", "ryan con"};
        int k = 2;

        int[] result = this.solution.solution(idList, reports, k);
        assertThat(result).containsExactly(0, 0);
    }
}