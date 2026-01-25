package implementation;

import java.io.*;
import java.util.*;

/**
 * BAEKJOON
 * 1713. 후보 추천하기
 */
public class Solution1713 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int maxNum = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] box = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            box[i] = Integer.parseInt(st.nextToken());
        }

        Map<Integer, Card> cardMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            if (cardMap.size() < maxNum) {
                if (cardMap.containsKey(box[i])) {
                    cardMap.get(box[i]).countCnt();
                } else {
                    cardMap.put(box[i], new Card(box[i], 1, i));
                }
            } else {
                if (cardMap.containsKey(box[i])) {
                    cardMap.get(box[i]).countCnt();
                } else {
                    // List<Card> cards = cardMap.values().stream().collect(Collectors.toList());
                    // int id = cards.get(0).id;
                    // for (int n = 1; n < maxNum; n++) {
                    //     if (cards.get(n).cnt == cardMap.get(id).cnt) {
                    //         id = cards.get(n).time > cardMap.get(id).time ? cardMap.get(id).id : cards.get(n).id;
                    //     } else {
                    //         id = cards.get(n).cnt > cardMap.get(id).cnt ? cardMap.get(id).id : cards.get(n).id;
                    //     }
                    // }
                    /** 
                     * 정석 코드
                    */
                    int removeId = -1;
                    for (Card c : cardMap.values()) {
                        if (removeId == -1) {
                            removeId = c.id;
                            continue;
                        }
                        Card best = cardMap.get(removeId);
                        if (c.cnt < best.cnt || (c.cnt == best.cnt && c.time < best.time)) {
                            removeId = c.id;
                        }
                    }
                    cardMap.remove(removeId);
                    cardMap.put(box[i], new Card(box[i], 1, i));
                }
            }
        }
        cardMap.values().stream().sorted((v1, v2) -> v1.id - v2.id).forEach(v -> System.out.print(v.id + " "));
    }

    private static class Card {
        int id;
        int cnt;
        int time;

        public Card(int id, int cnt, int time) {
            this.id = id;
            this.cnt = cnt;
            this.time = time;
        }

        public void countCnt() {
            cnt++;
        }
    }
}