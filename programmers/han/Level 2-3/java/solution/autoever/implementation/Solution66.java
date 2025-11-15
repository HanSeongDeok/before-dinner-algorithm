package solution.autoever.implementation;

import java.util.*;

public class Solution66 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Deque<Integer> bridgeDq = new ArrayDeque<>(bridge_length);
        Deque<Integer> truckDq = new ArrayDeque<>(truck_weights.length);
        
        for (int i = 0; i < bridge_length; i++) {
            bridgeDq.offer(0);
        }

        for (int truck : truck_weights) {
            truckDq.offer(truck);
        }

        while (!truckDq.isEmpty()) {
            bridgeDq.poll();
            int currentWeight = 0;
            for (int w : bridgeDq) currentWeight += w;
            if (currentWeight + truckDq.peekFirst() <= weight) {
                bridgeDq.offer(truckDq.poll());
            } else {
                bridgeDq.offer(0);
            }
            answer += 1;
        }
        return answer + bridgeDq.size();
    }
    public static void main(String[] args) {
        Solution66 s66 = new Solution66();
        int answer = s66.solution(2, 10, new int[] {7, 4, 5, 6});
        System.out.println(answer);
    }
}
