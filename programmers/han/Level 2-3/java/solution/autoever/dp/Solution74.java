package solution.autoever.dp;

import java.util.Arrays;

/**
 * 74. 정수 삼각형
 * 알고리즘 유형: 동적 계획법(DP)
 */
public class Solution74 {
    public int solution(int[][] triangle) {
        int n = triangle.length;
        int[][] dp = new int[n][n];
        
        dp[0][0] = triangle[0][0];

        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i-1][0] + triangle[i][0]; // 왼쪽 끝
            for (int j = 1; j < i; j++) {
                dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j];
            }
            dp[i][i] = dp[i-1][i-1] + triangle[i][i]; // 오른쪽 끝
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            answer = Math.max(answer, dp[n-1][i]);
        }
        return answer;
    }


    public int solution2(int[][] triangle) {
        int answer = Integer.MIN_VALUE;
        int len = triangle.length;
        int[][] dp = new int[len][len];
        dp[0][0] = triangle[0][0];

        for (int i=1; i < len; i++) {
            dp[i][0] = dp[i-1][0] + triangle[i][0];
            for (int j=1; j<i; j++) {
                dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j];
            }
            dp[i][i] = dp[i-1][i-1] + triangle[i][i]; 

        }

        // System.out.println(Arrays.toString(dp[len-1]));
        for (int value : dp[len-1]) {
            answer = Math.max(value, answer);
        }
        // System.out.println(answer);
        return answer;
    }

    public static void main(String[] args) {
        Solution74 s74 = new Solution74();
        s74.solution2(
            new int[][] {
                {7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}
            });
    }
}
