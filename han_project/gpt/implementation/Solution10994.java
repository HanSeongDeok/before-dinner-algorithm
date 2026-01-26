package implementation;

import java.io.*;

public class Solution10994 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        int size = 4 * N - 3; // 전체 크기: 4*N-3 x 4*N-3
        
        char[][] pattern = new char[size][size];
        
        // 초기화: 모든 칸을 공백으로
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                pattern[i][j] = ' ';
            }
        }
        
        // 재귀적으로 별 패턴 채우기
        drawStar(pattern, 0, 0, N);
        
        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                sb.append(pattern[i][j]);
            }
            sb.append('\n');
        }
        System.out.print(sb.toString());
    }
    
    // 재귀 함수: (r, c) 위치에서 시작하는 n 크기의 별 패턴 그리기
    private static void drawStar(char[][] pattern, int r, int c, int n) {
        if (n == 1) {
            pattern[r][c] = '*';
            return;
        }
        
        int currentSize = 4 * n - 3;
        
        // 바깥 테두리: 위쪽과 아래쪽
        for (int i = 0; i < currentSize; i++) {
            pattern[r][c + i] = '*';                    // 위쪽
            pattern[r + currentSize - 1][c + i] = '*';  // 아래쪽
        }
        
        // 바깥 테두리: 왼쪽과 오른쪽
        for (int i = 0; i < currentSize; i++) {
            pattern[r + i][c] = '*';                    // 왼쪽
            pattern[r + i][c + currentSize - 1] = '*';  // 오른쪽
        }
        
        // 안쪽 패턴 재귀 호출
        if (n > 1) {
            drawStar(pattern, r + 2, c + 2, n - 1);
        }
    }
}
