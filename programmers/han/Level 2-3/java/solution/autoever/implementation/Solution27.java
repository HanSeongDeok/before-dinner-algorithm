package solution.autoever.implementation;

import java.util.*;

public class Solution27 {
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
