package implementation;

import java.util.*;

/**
 * 27. 캐시
 * 알고리즘 유형: 구현, 자료구조(Deque, LRU Cache)
 */
public class Solution27 {
    /**
     * @ Day 2
     * @param cacheSize
     * @param cities
     * @return
     */
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Deque<String> dq = new ArrayDeque<>();

        if (cacheSize == 0) {
            return cities.length * 5;
        }

        for (String city : cities) {
            city = city.toUpperCase();
            if (dq.contains(city)) {
                dq.remove(city);
                dq.offer(city);
                answer += 1;
            } else {
                if (dq.size() == cacheSize) {
                    dq.poll();
                }
                dq.offer(city);
                answer += 5;
            }
        }
        
        return answer;
    }

    /**
     * @ Day2
     * @param cacheSize
     * @param cities
     * @return
     */
    public int solution2(int cacheSize, String[] cities) {
        int answer = 0;
        Deque<String> dq = new ArrayDeque<>();
        
        if(cacheSize == 0) {
            return cities.length * 5;
        }

        for (String city : cities) {
            String uCity = city.toUpperCase(); 
            if (dq.contains(uCity)) {
                dq.remove(uCity);
                dq.offer(uCity);
                answer += 1;
            } else {
                if (dq.size() == cacheSize) {
                    dq.poll();
                }
                dq.offer(uCity);
                answer += 5;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution27 s27 = new Solution27();
        int answer = s27.solution(3, 
            new String[] {
                "Jeju", "Pangyo", "Seoul", 
                "NewYork", "LA", "Jeju", 
                "Pangyo", "Seoul", "NewYork", "LA"});
        System.out.println(answer);
    }
}
