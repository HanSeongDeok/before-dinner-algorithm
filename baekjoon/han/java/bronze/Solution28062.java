package bronze;

import java.io.*;
import java.util.*;
/**
 * BAEKJOON
 * 28062. 준석이의 사탕 사기
 */
public class Solution28062 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        List<Integer> boxList  = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i=0; i <N; i++) boxList.add((int)Integer.parseInt(st.nextToken()));  
        
        boxList.sort(Comparator.reverseOrder());
        int sum = boxList.stream().mapToInt(Integer::valueOf).sum();
        
        int minOdd = 0;
        int oddCnt = 0;
        for (int b : boxList) {
            if (b % 2 == 1) {
                minOdd = b;
                oddCnt++;
            }
        }
        
        System.out.println(oddCnt % 2 == 1 ?  sum - minOdd : sum);
    }
}
