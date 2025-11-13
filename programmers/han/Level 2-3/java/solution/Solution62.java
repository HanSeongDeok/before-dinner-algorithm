package solution;
import java.util.*;

/**
 * 62. 두 큐 합 같게 만들기
 */
public class Solution62 {
    /**
    * @Day1
    */
    public int solution(int[] queue1, int[] queue2){
        Deque<Integer> dq1 = new ArrayDeque<>();
        Deque<Integer> dq2 = new ArrayDeque<>();
        
        long sum1 = 0, sum2 = 0;
        for (int q : queue1) {
            dq1.offerLast(q);
            sum1 += q;
        }
        for (int q: queue2){
            dq2.offerLast(q);
            sum2 += q;
        }

        if ((sum1 + sum2) % 2 != 0) return -1;
        
        int result = 0;
        while (result < queue1.length * 3) {
            if (sum1 == (sum1 + sum2) / 2) return result;
            if (sum1 > sum2) {
                int value = dq1.pollFirst();
                dq2.offerLast(value);
                sum1 -= value;
                sum2 += value;
            } else {
                int value = dq2.pollFirst();
                dq1.offerLast(value);
                sum1 += value;
                sum2 -= value;
            }
            result++;
        }

        return -1;
    }
    
    public static void main(String[] args){
        Solution62 solution = new Solution62();
        System.out.println(solution.solution(
            new int[]{1, 2, 1, 2}, 
            new int[]{1, 10, 1, 2}));
    }
}
