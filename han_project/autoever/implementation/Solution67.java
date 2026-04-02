package implementation;

/**
 * PROGRAMMERS 
 * 2단계 - 다리를 지나는 트럭
 */
import java.util.*;

public class Solution67 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Deque<Integer> bridgeDq = new ArrayDeque<>();
        Deque<Integer> waitDq = new ArrayDeque<>();

        for (int t : truck_weights) bridgeDq.add(t);
        for (int i = 0; i < bridge_length; i++) waitDq.add(0);

        int cache = 0;
        while (!bridgeDq.isEmpty()) {
            int waitTruck = waitDq.poll();
            cache -= waitTruck;
            if (weight >= cache + bridgeDq.peek()) {
                int truck = bridgeDq.poll();
                cache += truck;
                waitDq.add(truck);
            } else {
                waitDq.add(0);
            }
            answer++;
        }

        while (!waitDq.isEmpty()) {
            waitDq.poll();
            answer++;
        }
        return answer;
    }
}
