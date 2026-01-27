package dp;

/**
 * PROGRAMMERS
 * 81. 도둑질
 */
public class Solution81 {
    public int solution(int[] money) {
        int answer = 0;
        int N = money.length;
        int[] memo = new int[N];

        if (N == 1) return money[0]; 
        if (N == 2) return Math.max(money[0], money[1]); 

        memo[0] = money[0];
        memo[1] = money[0];

        for (int i = 2; i < N-1; i++) {
            memo[i] = Math.max(money[i] + memo[i-2], memo[i-1]);
        }

        int[] memo2 = new int[N];
        memo2[0] = 0;
        memo2[1] = money[1];

        for (int i = 2; i < N; i++) {
            memo2[i] = Math.max(money[i] + memo2[i-2], memo2[i-1]);
        }

        answer = Math.max(memo[N-2], memo2[N-1]);
        System.out.println(answer);
        return answer;
    }
    public static void main(String[] args) {
        Solution81 s81 = new Solution81();
        s81.solution(new int[]{1, 2, 3, 1});
    }
}
