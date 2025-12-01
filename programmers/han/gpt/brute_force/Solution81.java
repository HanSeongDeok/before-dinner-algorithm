package brute_force;

import java.util.*;

/**
 * PROGRAMMERS
 * 81. 전력망 둘로 나누기
 */
public class Solution81 {
    static Map<Integer, List<Integer>> networkMap = new HashMap<>(); 
    static int count;
    static boolean[] state;
    static int answer = Integer.MAX_VALUE;
    public int solution(int n, int[][] wires) {
        for (int i = 0; i < wires.length; i++) {
            networkMap.clear();
            for (int j = 0; j < wires.length; j++) {
                if (i == j) continue; 
                int key = wires[j][0], value = wires[j][1];
                
                networkMap.computeIfAbsent(key, k -> new ArrayList<>()).add(value);
                networkMap.computeIfAbsent(value, k -> new ArrayList<>()).add(key);
            }
            state = new boolean[n+1];
            List<Integer> counter = new ArrayList<>();
            for (int j = 1; j <= n; j++) {
                if (!state[j]) {
                    state[j] = true;
                    count = 1;
                    dfs(j);
                    counter.add(count);
                }
            }
            answer = Math.min(answer, Math.abs(counter.get(0) - counter.get(1))); 
        }
        return answer;
    }

    private static void dfs(int idx) {
        if (!networkMap.containsKey(idx)) {
            return;
        }
        for (int i : networkMap.get(idx)) {
            if (!state[i]) {
                state[i] = true;
                count++;
                dfs(i);
            }
        }
    }

    public static void main(String[] args) {
        Solution81 s81 = new Solution81();
        
        int[][] wires1 = {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};
        int[][] wires2 = {{1,2},{2,3},{3,4}};
        int[][] wires3 = {{1,2},{2,7},{3,7},{3,4},{4,5},{6,7}};
        
        System.out.println(s81.solution(9, wires1)); // 3
        System.out.println(s81.solution(4, wires2)); // 0
        System.out.println(s81.solution(7, wires3)); // 1
    }
}
