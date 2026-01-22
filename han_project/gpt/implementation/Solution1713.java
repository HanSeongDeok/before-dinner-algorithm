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
        
        Map<Integer, Card> cardMap = new HashMap<>();
        for (int i=0; i < N; i++) {
            if (cardMap.size() < maxNum) {
                if (!cardMap.isEmpty() && cardMap.containsKey(box[i])) {
                    cardMap.get(box[i]).countCnt();
                } else {
                    cardMap.put(box[i], new Card(box[i],1, i));
                }
            } else {
                if (cardMap.containsKey(box[i])) {
                    cardMap.get(box[i]).countCnt();
                } else {
                    List<Card> cards = (ArrayList<Card>)cardMap.values();  
                    int id = cards.get(0).id;
                    for (int n=1; n < maxNum; n++) {
                        if (cards.get(n).cnt == cardMap.get(id).cnt) {
                            id = cards.get(n).time >  cardMap.get(id).time ? cardMap.get(id).id : cards.get(n).id; 
                        } else {
                            id = cards.get(n).cnt > cardMap.get(id).cnt ? cards.get(n).cnt : cardMap.get(id).cnt; 
                        }
                    }
                }
            }
        } 
    }

    private static class Card {
        int id;
        int cnt; 
        int time;
        public Card(int id, int cnt, int time){
            this.id = id;
            this.cnt = cnt;
            this.time = time;
        }
        public void countCnt(){
            cnt++;
        } 
    }
}