package solution;

import java.util.*;
/**
 * 69. 연속된 부분 수열의 합
 * 알고리즘 유형: 투 포인터, 슬라이딩 윈도우
 */
public class Solution69 {
    /**
     * @ Day 1
     * @param sequence
     * @param k
     * @return
     */
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int sum = 0, sp = 0, ep=0, minLen = Integer.MAX_VALUE;
        while (ep <= sequence.length){
            if (sum < k) {
                if (ep == sequence.length) break; 
                sum += sequence[ep++];
            } else if (sum > k) {
                sum -= sequence[sp++];
            } else {
                if (ep - sp < minLen) {
                    minLen = ep - sp;
                    answer[0] = sp;
                    answer[1] = ep-1;
                }
                sum -= sequence[sp++];
            };
        }
        return answer;
    }


    public static void main(String[] args) {
        Solution69 s69 = new Solution69();
        s69.solution(new int[]{1, 2, 3, 4, 5}, 7);
    }
}
