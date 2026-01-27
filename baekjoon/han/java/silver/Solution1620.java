package silver;

import java.io.*;
import java.util.*;

/**
 * BAEKJOON
 * 1620. 나는야 포켓몬 마스터 이다솜
 */
public class Solution1620 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        List<String> box = new ArrayList<>(N+1);
        Map<String, Integer> boxMap = new HashMap<>();
        box.add("");
        for (int i=1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            String pocketmon = st.nextToken();
            box.add(pocketmon);
            boxMap.put(pocketmon, i);
        }

        String command[] = new String[M];
        for (int i=0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            command[i] = st.nextToken();
        }

        // System.out.println("-------");

        for (String c : command) {
            try {
                int index = Integer.parseInt(c);
                System.out.println(box.get(index));
            } catch (NumberFormatException e) {
                System.out.println(boxMap.get(c));
            }
        }
    }
}
