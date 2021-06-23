package programmers.level2.menu_renewal;

import java.util.*;

public class Solution {

    private Map<Integer, Map<String, Integer>> courseCntMap = new HashMap<>();
    private List<String> result = new ArrayList<>();

    public String[] solution(String[] orders, int[] course) {

        //orders의 문자들을 오름차순으로 정렬
        sortingOrders(orders);

        //오름차순으로 정렬한 문자들을 course 수에 맞게 조합 경우의 수를 만듬
        //각 조합 경우의 수를 카운팅함
        makeCombinationsByCourses(orders, course);

        //course 수 중 카운팅이 높은 것을 선택
        selectResult(courseCntMap);

        //result 배열을 오름차순으로 정렬
        Collections.sort(result);

        return result.toArray(new String[]{});
    }

    private void sortingOrders(String[] orders) {
        for (int i = 0; i < orders.length; i++)
            orders[i] = sortingMenu(orders[i]);
    }

    private String sortingMenu(String order) {
        char[] menus = order.toCharArray();
        Arrays.sort(menus);

        return String.valueOf(menus);
    }

    private void makeCombinationsByCourses(String[] orders, int[] course) {
        for (int num : course) {
            Map<String, Integer> countMap = new HashMap<>();
            makeCombinationsByOrders(orders, num, countMap);
            courseCntMap.put(num, countMap);
        }
    }

    private void makeCombinationsByOrders(String[] orders, int num, Map<String, Integer> countMap) {
        for (String order : orders) {
            makeCombinationsAndCount(order, num, countMap);
        }
    }

    private void makeCombinationsAndCount(String order, int num, Map<String, Integer> countMap) {
        backtrack(order, new char[num], 0, 0, countMap);
    }

    private void backtrack(String order, char[] comb, int idx, int start, Map<String, Integer> countMap) {
        if (idx == comb.length) {
            countMap.put(String.valueOf(comb), countMap.getOrDefault(String.valueOf(comb), 0) + 1);
            return;
        }else {
            for (int i = start; i < order.length(); i++) {
                comb[idx] = order.charAt(i);
                backtrack(order, comb, idx + 1, i + 1, countMap);
            }
        }
    }

    private void selectResult(Map<Integer, Map<String, Integer>> countMap) {
        for (Integer course : countMap.keySet()) {
            if (countMap.get(course).isEmpty()) continue;

            int maxCnt = Collections.max(countMap.get(course).values());
            if (maxCnt <= 1) continue;
            for (Map.Entry<String, Integer> entry : countMap.get(course).entrySet()) {
                if (entry.getValue() == maxCnt)
                    result.add(entry.getKey());
            }
        }
    }
}
