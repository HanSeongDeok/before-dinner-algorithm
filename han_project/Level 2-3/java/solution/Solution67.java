package solution;

/**
 * 67. 큰 수 만들기
 * 알고리즘 유형: 그리디, 슬라이딩 윈도우
 */
public class Solution67 {
 
    /**
     * @Day 1
     * @param number
     * @param k
     * @return
     */
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        int idx = 0;
        for (int i = 0; i < number.length() - k; i++) {
            char maxValue = '0';
            for (int j = idx; j <= i + k; j++) {
                char value = number.charAt(j);
                if (maxValue < value) {
                    maxValue = value;
                    idx = j + 1;
                }
            }
            answer.append(maxValue);
        }
        return answer.toString();
    }

    public static void main(String[] args) {
        Solution67 s67 = new Solution67();
        System.out.println(s67.solution("1924",2));
    }
}
