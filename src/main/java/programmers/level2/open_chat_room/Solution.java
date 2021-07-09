package programmers.level2.open_chat_room;

import java.util.*;

public class Solution {

    /*
        풀이

        제일 중요한건 uid당 최신 닉네임을 매칭시키는 것이다.
        result에 나오는 닉네임은 결국 마지막에 Change되거나 Enter된 아이디로 정해진다.

        따라서 record를 뒤에서부터 순회할 필요가 있다.
        방법은 뒤에서부터 순회하면서 uid당 최신 닉네임을 매칭시킨다. 최신이여야하기 때문에 한 번 매칭된 아이디들은 다시 매칭시킬 필요가 없다.

        uid가 몇개가 있을지 모르기 때문에 record 전체를 순회해야한다.

        result는 enter와 leave의 개수와 같다. change는 포함되지 않는다. 따라서 첫 순회할 때 change를 제외한 개수. 즉, result의 개수도 세어놓는다.

        result의 개수와, uid당 최신 닉네임을 매칭시켰다면,
        record를 처음부터 순회하면서 Enter와 Leave인 경우에 맞는 메시지를 만들어준다.
     */


    public String[] solution(String[] record) {
        Map<String, String> msgMap = new HashMap<>();
        msgMap.put("Enter", "님이 들어왔습니다.");
        msgMap.put("Leave", "님이 나갔습니다.");

        Map<String, String> idMap = new HashMap<>();
        StringBuffer sb = new StringBuffer();

        int resultCnt = 0;
        for (int i = record.length - 1; i >= 0; i--) {
            String[] row = record[i].split(" ");
            if ((row[0].equals("Enter") || row[0].equals("Change")) && !idMap.containsKey(row[1])) {
                idMap.put(row[1], row[2]);
            }
            if (!row[0].equals("Change")) resultCnt++;
        }

        String[] answer = new String[resultCnt];
        int j = 0;
        for (int i = 0; i < record.length; i++) {
            String[] row = record[i].split(" ");
            if (!row[0].equals("Change")) {
                answer[j++] = sb.append(idMap.get(row[1])).append(msgMap.get(row[0])).toString();
                sb.setLength(0);
            }
        }
        return answer;
    }
}
