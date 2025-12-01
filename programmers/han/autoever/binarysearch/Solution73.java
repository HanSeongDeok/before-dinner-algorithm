package binarysearch;

/**
 * 73. 입국 심사
 * 알고리즘 유형: 이분 탐색
 */
public class Solution73 {
    /**
     * @ Day1
     * 
     * @param n
     * @param times
     * @return
     */
    public long solution(int n, int[] times) {
        long left = 1;
        long right = (long) times[times.length - 1] * n;
        long answer = right;

        while (left <= right) {
            long mid = (long)(left + right) / 2;
            long cnt = 0;

            for (int time : times) {
                cnt += mid / time;
            }

            if (cnt >= n) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return answer;
    }

    /**
     * @ Day2
     * @param n
     * @param times
     * @return
     */
    public long solution2(int n, int[] times) {
        long left = 1;
        long right = (long) times[times.length - 1] * n;
        long answer = right;

        while (left <= right) {
            long mid = (long) (right + left) / 2;
            long total = 0;
            
            for (int time : times) {
                total += mid / time;
            }

            if (total >= n) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }

    /**
     * @ Day3
     * @param n
     * @param times
     * @return
     */
    public long solution3(int n, int[] times) {
        long answer = 0;
        long left = 1;
        long right = (long) times[times.length-1] * n;

        while(left <= right) {
            long mid = (long)(left + right) / 2;

            long totalN = 0;
            for (int time: times) {
                totalN += mid / time; 
            }

            if (n <= totalN) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution73 s73 = new Solution73();
        int[] times = { 7, 10 };
        long answer = s73.solution3(6, times);
        System.out.println(answer); // 28
    }
}
