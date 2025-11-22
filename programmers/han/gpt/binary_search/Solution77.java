package solution.gpt.binary_search;

/**
 * 77. 징검다리 건너기
 * 
 */
public class Solution77 {
    // 징검다리 건너기 문제 풀이 (이진 탐색)
    public int solution(int[] stones, int k) {
        int left = 1;
        int right = 200000000; // 최대 값
        int answer = 0;
        
        while(left <= right) {
            int mid = (left + right) / 2;
            int cnt = 0; // 연속으로 못 건너는 징검다리 개수

            for(int stone : stones) {
                if(stone - mid < 0) {
                    cnt++;
                    if(cnt >= k) break;
                } else {
                    cnt = 0;
                }
            }
            if(cnt < k) { // mid명까지는 건널 수 있음
                answer = mid;
                left = mid + 1;
            } else { // mid명이 건너면 건널 수 없음
                right = mid - 1;
            }
        }
        return answer;
    }

    /**
     * @Day 1
     * 
     * 판단 방법 요약
     * 문제 목표 확인: 최대값인지 최소값인지
     * 조건 해석: 각 분기에서 mid가 답의 후보인지 확인
     * 패턴 적용:
     * 최대값 찾기: 조건 만족 시 answer = mid + left = mid + 1
     *최소값 찾기: 조건 불만족 시 answer = mid + right = mid - 1
     * 
     * @param stones
     * @param k
     * @return
     */
    public int solution2(int[] stones, int k) {
        long answer = 0;
        long left = 1, right = 10;
        while (left <= right) {
            long mid = (long) (left + right) / 2;
            long cnt = 0;
            for (int stone : stones) {
                if (stone - mid < 0) {
                    cnt += 1;
                    if (cnt >= k) break;
                } else {
                    cnt = 0;
                }
            }
            if (cnt < k) {
                answer = mid;
                left = mid +  1;
            } else {   
                right = mid - 1;
            }
        }
        return (int)answer;
    }

    public static void main(String[] args) {
        Solution77 s77 = new Solution77();
        System.out.println(s77.solution2(new int[]{2, 4, 5, 3, 2, 1, 4, 2, 5, 1}, 3));
    }
}
