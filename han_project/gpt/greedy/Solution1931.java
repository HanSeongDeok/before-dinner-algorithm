package greedy;

import java.io.*;
import java.util.*;

/**
 * BAEKJOON
 * 1931. 회의실 배정
 * 
 * 오답 노트 -> 그리디 풀이의 핵심은 배열의 모든 선택이 국소 최적해인데 
 * 각 시작 시간마다의 시간을 비교하는 O(N^logN)의 방식으로 생각해버림
 * 
 * 정렬 기준을 회의 1. 마지막 시간 2. 같을 시 시작시간으로 오름차순 후
 * 시작시간을 비교해서 count하면 그게 무조건 최대 이용 가능한 시간임.
 */
public class Solution1931 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        List<int[]> box = new ArrayList<>();
        for (int i=0; i< N; i++) {
            st = new StringTokenizer(br.readLine());
            int startTime = Integer.parseInt(st.nextToken()), endTime = Integer.parseInt(st.nextToken());
            box.add(new int[] {startTime, endTime});
        } 
        box.sort((a, b) -> {
            if (a[1] == b[1]) return Integer.compare(a[0], b[0]);
            else return Integer.compare(a[1], b[1]);
        });

        // for (int[] b : box) {
        //     System.out.println(Arrays.toString(b));
        // }
        
        int endTime = box.get(0)[1];
        int count = 1;
        for (int[ ] b : box) {
            if (b[0]  < endTime) continue;
            endTime = b[1];
            count ++;
        }
        
        System.out.println(count);
    }
}