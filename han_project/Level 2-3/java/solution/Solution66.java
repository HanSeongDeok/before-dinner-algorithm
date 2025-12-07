package solution;

import java.util.*;

/**
 * 66. 다리를 지나는 트럭
 * 알고리즘 유형: 큐, 시뮬레이션
 */
public class Solution66 {
    /**
     * @Day1
     * @param bridge_length
     * @param weight
     * @param truck_weights
     * @return
     */
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Deque<Integer> bridgeDeq = new ArrayDeque<>();
        Deque<Integer> truckDeq = new ArrayDeque<>();

        for (int i : truck_weights){
            truckDeq.offer(i);
        }

        for (int i = 0; i < bridge_length; i++) {
            bridgeDeq.offer(0);
        }

        int bridgeWeight = 0;
        while (!truckDeq.isEmpty()) {
            bridgeWeight -= bridgeDeq.poll();
            if (bridgeWeight + truckDeq.peek() <= weight) {
                int truck = truckDeq.poll();
                bridgeWeight += truck;
                bridgeDeq.offer(truck);
            } else {
                bridgeDeq.offer(0);
            }
            answer++;
        }
        return answer + bridgeDeq.size();
    }

    public static void main(String[] args) {
        Solution66 s66 = new Solution66();
        //System.out.println(s66.solution(2, 10, new int[] { 7, 4, 5, 6 }));
        System.out.println(s66.solution(2, 10, new int[] { 7, 4, 5, 6 }));
    }
}
