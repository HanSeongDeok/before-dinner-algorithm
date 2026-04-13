package implementation;

// 프로그래머스 Lv.2 - 행렬 테두리 회전하기 (2021 Dev-Matching 웹 백엔드)
// https://school.programmers.co.kr/learn/courses/30/lessons/77485

import java.util.*;

public class Solution34 {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] box = new int[rows+1][columns+1];
        int[][] copyBox = new int[rows+1][columns+1];
        int count = 1;
        for (int i=1; i <= rows; i++) {
            for (int j=1; j <= columns; j++) {
                box[i][j] = count; 
                copyBox[i][j] = count;
                count++;
            }
        }

        int idx = 0;
        for (int[] q : queries) {
            int min = Integer.MAX_VALUE;

            // 우측 회전
            for (int i=1; i<=Math.abs(q[3] - q[1]); i++) {
                int y = q[0];
                int x = q[1] + i;
                copyBox[y][x] = box[y][x-1];
                min = Math.min(min, copyBox[y][x]);
            }

            // 아래 회전
            for (int i=1; i<=Math.abs(q[0] - q[2]); i++) {
                int y = q[0]+i;
                int x = q[3];
                copyBox[y][x] = box[y-1][x];
                min = Math.min(min, copyBox[y][x]);
            }

            // 좌측 회전
            for (int i=1; i<=Math.abs(q[3] - q[1]); i++) {
                int y = q[2];
                int x = q[3] - i;
                copyBox[y][x] = box[y][x+1];
                min = Math.min(min, copyBox[y][x]);
            }

            // 위 회전
            for (int i=1; i<=Math.abs(q[0] - q[2]); i++) {
                int y = q[2] - i;
                int x = q[1];
                copyBox[y][x] = box[y+1][x];
                min = Math.min(min, copyBox[y][x]);
            }
            
            for (int i=0; i < copyBox.length; i++) {
                box[i] = Arrays.copyOf(copyBox[i], copyBox[i].length);
            }
            answer[idx++] = min;
        }   

        System.out.println(Arrays.toString(answer));
        return answer;
    }
    public static void main(String[] args) {
        Solution34 s34 = new Solution34();
        int rows = 6;
        int columns = 6;
        int[][] queries = {{2,2,5,4},{3,3,6,6},{5,1,6,3}};
        s34.solution(rows, columns, queries);

        Map<Integer, Integer> xMap = new HashMap<>();
        Map<Integer, Integer> yMap = new HashMap<>();
        int[][] test = new int[][] {{2, 2}, {1, 2}, {1, 1}};
        for (int[] t : test) {
            xMap.put(t[0], xMap.getOrDefault(t[0], 0)+1);
            yMap.put(t[1], yMap.getOrDefault(t[1], 0)+1);
        }
        int[] answer = new int[2];
        for (int[] t : test) {
            if (xMap.get(t[0]) == 1) {
                answer[0] = t[0];
            }
            if (yMap.get(t[1]) == 1) {
                answer[1] = t[1];
            }
        }
        System.out.println(Arrays.toString(answer));
    }
}
