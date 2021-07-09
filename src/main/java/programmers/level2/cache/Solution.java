package programmers.level2.cache;

import java.util.*;

public class Solution {
    /*
        풀이

        도시 이름을 캐시크기만큼 저장해놓을 공간이 필요하다.
        그 공간에서 도시 이름이 존재하는지 탐색이 빨라야한다. (map)

        miss일 경우, 캐시크기가 꽉차있으면, 먼저 들어왔던 도시이름이 빠져나가야한다. (queue)
                    꽉차있지 않으면 도시이름을 추가해준다.
        hit일 경우, 캐시크기에 상관없이 해당 도시 이름을 맨 뒤에 위치시킨다. (list)

        저장되는 공간은 수정이 용이해야한다. -> queue보다는 list를 쓰도록 하자.
        따라서 map과 list를 같이 갖고 있는 객체를 하나 만들고 찾을 때는 map, 위치를 변경할 때는 list를 이용하도록 한다.

     */

    private final int CACHE_HIT_TIME = 1;
    private final int CACHE_MISS_TIME = 5;

    public int solution(int cacheSize, String[] cities) {
        SizedQueueMap<String, String> cache = new SizedQueueMap<>(cacheSize);

        int runTime = 0;
        for (String city : cities)
            runTime += cache.isHit(city.toLowerCase(), "data") ? CACHE_HIT_TIME : CACHE_MISS_TIME;

        return runTime;
    }
}

class SizedQueueMap<K, V> {
    private final int MAX_SIZE;
    private Map<K, V> map = new HashMap<>();
    private List<K> list = new ArrayList<>();

    public SizedQueueMap(int maxSize) {
        MAX_SIZE = maxSize;
    }

    public boolean isHit(K key, V value) {
        if (map.containsKey(key)) {
            list.add(list.remove(list.indexOf(key)));
            return true;
        }else {
            if (MAX_SIZE == 0) return false;

            if (map.size() == MAX_SIZE)
                map.remove(list.remove(0));

            map.put(key, value);
            list.add(key);

            return false;
        }
    }
}