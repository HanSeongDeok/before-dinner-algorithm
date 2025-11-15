package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

 /**
 * 68. 삼각 달팽이
 * 알고리즘 유형: 구현, 시뮬레이션
 */
public class Solution68 {
    /**
     * @ Day1
     * @param n
     * @return
     */
    public int[] solution(int n) {
        List<Integer> answer = new ArrayList<>();
        int[][] boxs = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                boxs[i][j] = -1;
            }
        }

        int x = 0, y = 0, cnt = 1; 
        for (int i=0; i < n; i++) {
            for (int j=i; j < n; j++) {
                if (i % 3 == 0 && j != 0) {
                    y++;
                } else if ((i % 3 == 1)) {
                    x++;
                } else if ((i % 3 == 2)) {
                    y--;
                    x--;
                }
                boxs[y][x] = cnt++;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (boxs[i][j] == -1) continue;
                answer.add(boxs[i][j]);
            }
        }
        return answer.stream().mapToInt(i->i).toArray();
    }

    public static void main(String[] args) {
        Solution68 s68 = new Solution68();
        s68.solution(4);
    }
}
