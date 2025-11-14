package solution;

/**
 * 68. 삼각 달팽이
 */
public class Solution68 {
    public int[] solution(int n) {
        int[][] triangle = new int[n][n];
        int num = 1;
        int x = -1, y = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i % 3 == 0) { // 아래로 이동
                    x++;
                } else if (i % 3 == 1) { // 오른쪽으로 이동
                    y++;
                } else if (i % 3 == 2) { // 대각선 위로 이동
                    x--;
                    y--;
                }
                triangle[x][y] = num++;
            }
        }
        int[] answer = new int[n*(n+1)/2];
        int idx = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                answer[idx++] = triangle[i][j];
            }
        }
        return answer;
    }
    
    public static void main(String[] args) {
        Solution68 s68 = new Solution68();
        System.out.println(s68.solution(4));
    }
}
