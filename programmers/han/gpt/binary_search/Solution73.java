package solution.gpt.binary_search;

/**
 * 73. 입국 심사
 */
public class Solution73 {
    public long solution(int n, int[] times) {
        long answer = 0;
        long left = 1;
        long right = times[times.length-1] * n;

        while (left <= right) {
            long mid = (long)(left + right) / 2;
            long cnt = 0;
            for (int time : times) {
                cnt += mid / time;
            }

            if (cnt < n) {
                left = mid + 1;
            } else {
                answer = mid;
                right = mid - 1;
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        Solution73 s73 = new Solution73();
    }
}
