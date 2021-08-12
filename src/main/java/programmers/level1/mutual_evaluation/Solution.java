package programmers.level1.mutual_evaluation;

public class Solution {
    private int[][] scores;

    /*
        풀이
        단순 계산 문제인 것으로 판단했다.

        학생의 수 n만큼
        평균 점수를 구하려면 n만큼의 순회를 해야하므로 O(n^2)이다.

        유일한 최고값, 유일한 최소값인지 판단하고, sum을 구하는데 3n인데 이를 n으로 줄이는 방법을 생각해봤으나
        코드의 가독성이 떨어진다고 판단했다.
     */
    public String solution(int[][] score) {
        scores = score;
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < scores[0].length; i++) {
            double avg;

            if (isUniqueAndHighest(i) || isUniqueLowest(i)) {
                avg = exceptSelf(i);
            }else {
                avg = includeSelf(i);
            }
            ans.append(scoring(avg));
        }
        return ans.toString();
    }

    private boolean isUniqueAndHighest(int no) {
        int selfScore = scores[no][no];
        for (int i = 0; i < scores.length; i++) {
            if (i != no && scores[i][no] >= selfScore) {
                return false;
            }
        }
        return true;
    }

    private boolean isUniqueLowest(int no) {
        int selfScore = scores[no][no];
        for (int i = 0; i < scores.length; i++) {
            if (i != no && scores[i][no] <= selfScore) {
                return false;
            }
        }
        return true;
    }

    private double exceptSelf(int no) {
        double sum = 0;
        for (int i = 0; i < scores.length; i++) {
            if (i != no) {
                sum += scores[i][no];
            }
        }
        return sum / (scores.length - 1);
    }

    private double includeSelf(int no) {
        double sum = 0;
        for (int i = 0; i < scores.length; i++) {
            sum += scores[i][no];
        }
        return sum / scores.length;
    }

    private char scoring(double avg) {
        if (avg >= 90) {
            return 'A';
        }else if (avg >= 80) {
            return 'B';
        }else if (avg >= 70) {
            return 'C';
        }else if (avg >= 50) {
            return 'D';
        }else {
            return 'F';
        }
    }
}
