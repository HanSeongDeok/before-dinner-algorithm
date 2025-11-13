package solution;

import java.util.*;

/**
 * 63. 쿼드압축 후 개수 세기
 * 
 * 분할 정복(Divide and Conquer) 알고리즘 
 * 재귀(Recursion) 방식
 */
public class Solution63 {
    public int[] solution(int[][] arr) {
        Map<Integer, Integer> countMap = new HashMap<>();
        countMap.put(0, 0);
        countMap.put(1, 0);
        
        compress(arr, 0, 0, arr.length, countMap);
        
        return new int[]{countMap.get(0), countMap.get(1)};
    }
    
    private void compress(int[][] arr, int x, int y, int size, Map<Integer, Integer> countMap) {
        // 현재 영역이 모두 같은 값인지 확인
        if (isUniform(arr, x, y, size)) {
            // 모두 같은 값이면 해당 값의 개수 증가
            int value = arr[x][y];
            countMap.put(value, countMap.get(value) + 1);
            return;
        }
        
        // 4등분하여 재귀 호출
        int half = size / 2;
        compress(arr, x, y, half, countMap);                   // 왼쪽 위
        compress(arr, x, y + half, half, countMap);            // 오른쪽 위
        compress(arr, x + half, y, half, countMap);            // 왼쪽 아래
        compress(arr, x + half, y + half, half, countMap);     // 오른쪽 아래
    }
    
    private boolean isUniform(int[][] arr, int x, int y, int size) {
        int firstValue = arr[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (arr[i][j] != firstValue) {
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args){
        Solution63 s63 = new Solution63();
        int[] a = s63.solution(new int[][]{{1,1,0,0},{1,0,0,0},{1,0,0,1},{1,1,1,1}});
        System.out.println(Arrays.toString(a));
    }
}
