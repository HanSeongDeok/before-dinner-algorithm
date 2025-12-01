package solution;

import java.util.*;

/**
 * 72. 시소 짝꿍
 * 알고리즘 유형: 해시(Hash), 구현(Implementation)
 */
public class Solution72 {
    /**
     * @Day 1
     * @param weights
     * @return
     */
    public long solution2(int[] weights) {
        long answer = 0;
        Map<Long, Long> weightsCount = new HashMap<>();
        for (long i : weights) {
            weightsCount.put(i, weightsCount.getOrDefault(i, 0L) + 1);
        } 

        long[][] rates = {{2, 1}, {3, 2}, {4, 3}};
        
        for (long w : weightsCount.keySet()) {
            long sameCnt = weightsCount.get(w);
            if (sameCnt > 0) {
                answer += (sameCnt * (sameCnt-1)) / 2;
            }

            for (long[] rate : rates) {
                long value = w * rate[0];
                long target = rate[1];

                if (value % target == 0) {
                    long targetValue = value / target;
                    if (targetValue > w && weightsCount.containsKey(targetValue)) {
                        answer += sameCnt * weightsCount.get(targetValue);
                    }
                }

            }
        }
        System.out.println(answer);
        return answer;
    }

    public static void main(String[] args) {
        Solution72 s72 = new Solution72();
        s72.solution2(new int[]{100,180,360,100,270});
    }
}
