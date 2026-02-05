package implementation;

import java.io.*;
import java.util.*;

/**
 * BAEKJOON
 * 20608. 상어 초등학교
 */
public class Solution20608 {
    private static int[] mapN = {1, -1, 0, 0};
    private static int[] mapM = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] box = new int[N * N];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < N * N; i++) {
            st = new StringTokenizer(br.readLine());
            box[i] = Integer.parseInt(st.nextToken());
            for (int n=0; n<4; n++) {
                int value = Integer.parseInt(st.nextToken());
                map.computeIfAbsent(box[i], k-> new ArrayList<>()).add(value);
            }
        }

        int table[][] = new int[N][N];
        for (int i = 0; i < N * N; i++) {
            int value = box[i];
            List<Integer> likeList = map.get(value);
            int maxLike=0, maxEmpty=0, bestN=N, bestM=N;
            for (int n= 0; n < N; n++) {
                for (int m= 0; m < N; m++) {
                    if (table[n][m] != 0) continue;
                    int likeCnt = 0;
                    int emptyCnt = 0;
                    for (int k =0; k < 4; k++) {
                        int nextN = n + mapN[k];
                        int nextM = m + mapM[k];
                        if (-1 < nextN && nextN < N && -1 < nextM && nextM < N) {
                            if (likeList.contains(table[nextN][nextM])) likeCnt++;
                            if (table[nextN][nextM] == 0) emptyCnt ++;
                        }
                    }
                    if (maxLike < likeCnt || 
                        maxLike == likeCnt && maxEmpty < emptyCnt || 
                        maxLike == likeCnt && maxEmpty == emptyCnt && bestN > n ||
                        maxLike == likeCnt && maxEmpty == emptyCnt &&  bestN == n && bestM > m
                    ) {
                        maxLike = likeCnt; maxEmpty = emptyCnt;
                        bestN = n; bestM = m;
                    }
                }
            }
            table[bestN][bestM] = value;
        }

        int answer = 0; 
        for (int n= 0; n < N; n++) {
            for (int m= 0; m < N; m++) {
                int value = table[n][m];
                List<Integer> likeList = map.get(value);
                int cnt = 0;
                for (int k =0; k < 4; k++) {
                    int nextN = n + mapN[k];
                    int nextM = m + mapM[k];
                    if (-1 < nextN && nextN < N && -1 < nextM && nextM < N) {
                        if (likeList.contains(table[nextN][nextM])) cnt++;
                    }
                }
                int cal = cnt == 0 ? 0 : 1; 
                for (int i=1; i <cnt; i++) cal *= 10;   
                answer += cal;
            }
        }
        System.out.println(answer);
    }
}
