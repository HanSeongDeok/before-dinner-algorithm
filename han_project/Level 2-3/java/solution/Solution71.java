package solution;

/**
 * 71.마법의 엘리베이터
 * 알고리즘 유형: 그리디(Greedy), 구현(Implementation)
 */
public class Solution71 {
    /**
     * @Day 1
     * @param storey
     * @return
     */
    public int solution2(int storey) {
        int answer = 0;
        while (storey > 0) {
            int remainder = storey % 10;
            int next = (storey / 10) % 10;
            if (remainder > 5) {
                storey += (10 - remainder);
                answer += (10 - remainder);
            } else if(remainder < 5) {
                storey -= remainder;
                answer += remainder;
            } else {
                if (next >= 5) {
                    storey += 5;
                    answer += 5;
                } else {
                    storey -= 5;
                    answer += 5;
                }
            }
            storey /= 10;
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution71 s71 = new Solution71();
        s71.solution2(16);
        s71.solution2(2554);
    }
}
