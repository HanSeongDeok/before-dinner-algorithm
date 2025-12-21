package greedy;

import java.io.*;
import java.util.*;

/**
 * BAEKJOON
 * 2217. 로프
 * 
 * 오답 노트 -> 단순하게 최소 값 * N로 생각했지만 X
 * 전부 비교해봐야함.   
 */
public class Solution2217 {
    public static void main(String[] args) throws IOException{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int box[] = new int[N];
            for (int i=0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                box[i] = Integer.parseInt(st.nextToken());
            }

            box = Arrays.stream(box).boxed().sorted(Comparator.reverseOrder()).mapToInt(Integer::valueOf).toArray();
            
            int answer = 0;
            for (int i =0; i < N; i++) {
                answer = Math.max(box[i] * (i + 1), answer);
            }
            System.out.println(answer);
        }
}
