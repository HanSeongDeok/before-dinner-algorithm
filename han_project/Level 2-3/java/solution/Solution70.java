package solution;
/**
 * 70. 스티커 모으기(2)
 * 알고리즘 유형: DP(동적 프로그래밍)
 */
public class Solution70 {

    public int solution(int sticker[]) {
        int [] dp = new int[sticker.length];
        if (sticker.length == 1) return sticker[0];
        if (sticker.length == 2) return Math.max(sticker[0], sticker[1]);

        dp[0] = sticker[0];
        dp[1] = Math.max(dp[0], sticker[1]);
        int maxCase1 = dp[1];
        for (int i = 2; i < sticker.length-1; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + sticker[i]);
            maxCase1 = dp[i]; 
        }

        dp = new int[sticker.length]; 
        dp[0] = 0;
        dp[1] = sticker[1];
        int maxCase2 = dp[1];
        for (int i = 2; i < sticker.length; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + sticker[i]);
            maxCase2 = dp[i]; 
        }
        return Math.max(maxCase1, maxCase2);
    }

    public static void main(String[] args) {
        Solution70 s70 = new Solution70();
        System.out.println(s70.solution(
            new int[]{14, 6, 5, 11, 3, 9, 2, 10}));
    }
}
