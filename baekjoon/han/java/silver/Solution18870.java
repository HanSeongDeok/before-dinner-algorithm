package silver;

import java.io.*;
import java.util.*;

/**
 * BAEKJOON
 * 18870.  좌표 압축
 * 
 * 첫번째 시간초과 -> List로 contain 확인하면 시간이 늘어나기 때문.. 
 * index 따로 두어 조건 부합 시 index++ 방식으로 해결
 */
public class Solution18870 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] box = new int[N]; 

        st = new StringTokenizer(br.readLine());
        for (int i=0; i < N; i++) {
            box[i] = Integer.parseInt(st.nextToken());
        }

        int[] copyBox = Arrays.copyOf(box, N);
        copyBox = Arrays.stream(copyBox).boxed().sorted(Comparator.reverseOrder()).mapToInt(Integer::valueOf).toArray();

        Map<Integer, Integer> boxMap = new HashMap<>();
        int index = 1;
        int cnt = 0;

        boxMap.put(copyBox[0], index);
        for (int i=1; i < copyBox.length; i++) {     
            if (copyBox[i] != copyBox[i-1]) index++;
            else cnt++;
            boxMap.put(copyBox[i], index);
        }

        StringBuilder sb = new StringBuilder();
        for (int b : box) {
            sb.append((N - cnt) - boxMap.get(b)).append(" ");
        }
        System.out.println(sb.toString());
    }
}
