package greedy;

import java.io.*;
import java.util.*;

/**
 * BAEKJOON
 * 1541. 잃어버린 괄호
 * 
 * 오답 노트 -> -로 나눠 미리 더하기를 한 후 남은 -를 처리하는 게 무조건 가장 작다.
 * 생각을 못함..
 */
public class Solution1541 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        String S = st.nextToken();
        String[] box = S.split("\\-");
        
        int answer = 0;
        for (int i=0; i < box.length; i++) {
            String[] target = box[i].split("\\+");
            int sum = Arrays.stream(target).mapToInt(Integer::parseInt).sum();
            answer = i==0 ? answer + sum  : answer + (-sum);
        }

        System.out.println(answer);
    }
}
