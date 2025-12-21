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
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int TC = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        for (int tc = 0; tc < TC; tc++) {
            st = new StringTokenizer(br.readLine());
            char[] COMMAND = st.nextToken().toCharArray();

            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());

            String[] ARR = st.nextToken().replaceAll("[\\[\\]]", "").split(",");
            int[] box = N == 0 ? new int[]{} : Arrays.stream(ARR).mapToInt(Integer::parseInt).toArray();

            for (char c : COMMAND) {
                int[] copyBox = Arrays.copyOf(box, box.length);
                if (c == 'R') {
                    for (int i = 0; i < N; i++) {
                        box[i] = copyBox[(N-1)-i];
                    } 
                } 
                else if (c == 'D') {
                    if (box.length == 0) break;
                    int[] createBox = new int[copyBox.length-1];
                    for (int i=0; i < copyBox.length-1; i++) {
                        createBox[i] = copyBox[i+1];
                    } 
                    box = createBox;
                }
            }
            String answer = box.length == 0 ? "error" : Arrays.toString(box); 
            sb.append(answer).append("\n");
        }
        System.out.println(sb.toString());
    }
}
