package implementation;

import java.io.*;
import java.util.*;
public class Solution1713 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int maxNum = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int [] box = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i < N; i++) {
            box[i] = Integer.parseInt(st.nextToken());
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(maxNum);
        for (int i=0; i < N; i++) {
            if (pq.size() < maxNum) {
                pq.add(box[i]);
            } else {
                pq.poll();
                pq.add(box[i]);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) sb.append(pq.poll()).append(" ");
        System.out.println(sb.toString());
    }
}
