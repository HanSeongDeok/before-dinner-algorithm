package solution.gpt.implementation;

import java.util.*;

public class Solution76 {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Map<Integer, Deque<Integer>> boardMap = new HashMap<>();
        
        for (int x = 0; x < board[0].length; x++) {
            for (int y = 0; y < board.length; y++) {
                int doll = board[y][x];
                if (doll == 0) continue;
                boardMap.computeIfAbsent(x+1, ArrayDeque::new).offer(doll);
            }   
        }

        int cnt = 1;
        for (Deque<Integer> b : boardMap.values()) {
            System.out.println(cnt++ + ": " + b.toString());
        }

        Deque<Integer> box = new ArrayDeque<>();
        for (int move : moves){
            if (!boardMap.containsKey(move) || boardMap.get(move).isEmpty()) continue; 
            
            int doll = boardMap.get(move).pollFirst();
            if (box.isEmpty() || box.peekLast() != doll) {
                box.offer(doll);
            } else if (box.peekLast() == doll) {
                box.pollLast();
                answer+=2;
            }
        }
        System.out.println(answer);
        return answer;
    }

    public static void main(String[] args) {
        Solution76 s76 = new Solution76();
        s76.solution(
            new int[][] {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}},
            new int[] {1,5,3,5,1,2,1,4}
        );
    }
}
