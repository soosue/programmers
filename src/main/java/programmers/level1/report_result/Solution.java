package programmers.level1.report_result;

import java.util.*;

public class Solution {
    public int[] solution(String[] id_list, String[] reports, int k) {
        IntegratedReports integratedReports = new IntegratedReports(reports);
        StoppedUsers stoppedUsers = integratedReports.stoppedUsers(k);

        Reporters reporters = new Reporters(reports);
        return reporters.reportCounts(id_list, stoppedUsers);
    }
}

class IntegratedReports {
    private final Map<String, Integer> reportedUsers;

    IntegratedReports(String[] reports) {
        this(toMap(reports));
    }

    IntegratedReports(Map<String, Integer> reportedUsers) {
        this.reportedUsers = reportedUsers;
    }

    private static Map<String, Integer> toMap(String[] reports) {
        Map<String, Integer> reportedUsers = new HashMap<>();
        Set<String> reportHistory = new HashSet<>();
        for (String report : reports) {
            if (reportHistory.contains(report)) {
                continue;
            }
            reportHistory.add(report);

            String reportedUser = report.split(" ")[1];

            if (reportedUsers.containsKey(reportedUser)) {
                reportedUsers.put(reportedUser, reportedUsers.get(reportedUser) + 1);
                continue;
            }

            reportedUsers.put(reportedUser, 1);
        }

        return reportedUsers;
    }

    public Map<String, Integer> getReportedUsers() {
        return reportedUsers;
    }

    public StoppedUsers stoppedUsers(int k) {
        Set<String> stoppedUsers = new HashSet<>();
        for (Map.Entry<String, Integer> entry : reportedUsers.entrySet()) {
            if (entry.getValue() >= k) {
                stoppedUsers.add(entry.getKey());
            }
        }

        return new StoppedUsers(stoppedUsers);
    }
}

class StoppedUsers {
    private final Set<String> stoppedUsers;

    StoppedUsers(Set<String> stoppedUsers) {
        this.stoppedUsers = stoppedUsers;
    }

    public boolean contains(String id) {
        return stoppedUsers.contains(id);
    }
}

class Reporters {
    private final Map<String, Set<String>> reporters;

    public Reporters(String[] reports) {
        this(toMap(reports));
    }

    public Reporters(Map<String, Set<String>> reporters) {
        this.reporters = reporters;
    }

    private static Map<String, Set<String>> toMap(String[] reports) {
        Map<String, Set<String>> reporters = new HashMap<>();
        for (String report : reports) {
            String reporter = report.split(" ")[0];
            String reportedUser = report.split(" ")[1];

            if (reporters.containsKey(reporter)) {
                reporters.get(reporter).add(reportedUser);
                continue;
            }
            Set<String> reportedUsers = new HashSet<>();
            reportedUsers.add(reportedUser);
            reporters.put(reporter, reportedUsers);
        }

        return reporters;
    }

    public int[] reportCounts(String[] idList, StoppedUsers stoppedUsers) {
        int[] reportCounts = new int[idList.length];
        for (int i = 0; i < idList.length; i++) {
            Set<String> reportedUsers = reporters.getOrDefault(idList[i], new HashSet<>());

            for (String reportedUser : reportedUsers) {
                if (stoppedUsers.contains(reportedUser)) {
                    reportCounts[i]++;
                }
            }
        }

        return reportCounts;
    }

    public Map<String, Set<String>> getReporter() {
        return reporters;
    }
}
