package implementation;

import java.io.*;
import java.util.*;

/**
 * BAEKJOON
 * 14891. 톱니바퀴
 */
public class solution14891 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Map<Integer, List<Integer>> listMap = new HashMap<>();
        for (int i=1; i<=4; i++) {
            st = new StringTokenizer(br.readLine());
            String list = st.nextToken();
            for (char c : list.toCharArray()) {
                listMap.computeIfAbsent(i, k -> new ArrayList<>()).add(c - '0');
            }
        }

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        for (int i=0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            
            int[] state = new int[5];
            state[n] = dir;

            for (int j = n-1; j >= 1; j--) {
                if (listMap.get(j).get(2).equals(listMap.get(j+1).get(6))) break;
                state[j] = -state[j+1];  
            }

            for (int j = n+1; j <= 4; j++) {
                if (listMap.get(j).get(6).equals(listMap.get(j-1).get(2))) break;
                state[j] = -state[j-1];  
            }

            for (int j=1; j<=4; j++) {
                List<Integer> list = listMap.get(j);
                if (state[j] == 1) {
                    int value = list.get(list.size()-1);
                    list.remove(list.size()-1);
                    list.add(0, value);
                } else if (state[j] == -1) {
                    int value = list.get(0);
                    list.remove(0);
                    list.add(value);
                }
            }
        }

        int answer = 0;
        for (int i = 1; i<=4; i++) {
            if (i == 1) answer = listMap.get(i).get(0) == 1 ? answer + 1 : answer;  
            else if (i == 2) answer = listMap.get(i).get(0) == 1 ? answer + 2 : answer;  
            else if (i == 3) answer = listMap.get(i).get(0) == 1 ? answer + 4 : answer;  
            else if (i == 4) answer = listMap.get(i).get(0) == 1 ? answer + 8 : answer;  
        }
        System.out.println(answer);
    }
}
