package gold;

import java.io.*;
import java.util.*;

/**
 * BAEKJOON
 * 5430. AC
 * 
 * 시간 초과 -> 오답 다시 풀기
 */
public class Solution5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int tc = 0; tc < TC; tc++) {
            boolean IS_REVERSE = false; 
            boolean IS_ERROR = false;

            char[] COMMAND = br.readLine().toCharArray();
            int N = Integer.parseInt(br.readLine());

            String arrInput = br.readLine();
            Deque<Integer> box = new ArrayDeque<>();

            if (N > 0) {
                String[] ARR = arrInput.replaceAll("[\\[\\]]", "").split(",");
                for (String s : ARR) {
                    box.add(Integer.valueOf(s));
                }
            }

            for (char c : COMMAND) {
                if (c == 'R') {
                    IS_REVERSE = !IS_REVERSE;
                } else if (c == 'D') {
                    if (box.isEmpty()) {
                        IS_ERROR = true;
                        break;
                    }
                    if (IS_REVERSE) box.pollLast();
                    else box.pollFirst();
                }
            }

            if (IS_REVERSE)  {
                Deque<Integer> dq = new ArrayDeque<>();
                int size = box.size();
                for (int i=0; i<size; i++) {
                    dq.add(box.pollLast());
                }
                box = dq;
            } 

            String answer = IS_ERROR ? "error" : box.toString().replaceAll(" ", "");
            sb.append(answer).append("\n");
        }

        System.out.println("----------------------------");
        System.out.println(sb.toString());
    }
}
