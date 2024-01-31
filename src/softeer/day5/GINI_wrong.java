package softeer.day5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class GINI_wrong {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] indexInfos = getInfos(br);
        String[][] map = new String[indexInfos[0]][indexInfos[1]];
        boolean[][] goal = new boolean[indexInfos[0]][indexInfos[1]];

        Map<Integer, Integer> rainMap = new HashMap<>();
        Map<Integer, Integer> wMap = new HashMap<>();

        Queue<Map<Integer, Integer>> rainQ = new LinkedList<>();
        Queue<Map<Integer, Integer>> wQ = new LinkedList<>();

        for (int i=0; i< map.length; i++) {
            map[i] = getValues(br);
            int count = 0;
            for (String v : map[i]) {
                if (v.equals("H") || v.equals("*") || v.equals("X") || v.equals("W")) {
                    if (v.equals("W")) {
                        wMap.put(i, count);
                        wQ.add(wMap);
                    }
                    else if (v.equals("*")) {
                        rainMap.put(i, count);
                        rainQ.add(rainMap);
                    }
                    else if (v.equals("H")) goal[i][count] = true;
                }
                count++;
            }
        }

        int count = 0;
        int result = 0;
        while (count < indexInfos[0]) {
            int rainSize = rainQ.size();
            int[] keys = getKeys(rainQ);
            int[] values = getValues(rainQ);
            for (int i=0; i < rainSize; i++) {
                int upIndex = keys[i] - 1, downIndex = keys[i] +1;
                int leftIndex = values[i] -1, rightIndex = values[i] + 1;

                String s = map[upIndex][values[i]];
                if (validIndex(upIndex, indexInfos)
                        && !s.equals("X") && !s.equals("*") && !s.equals("H")) {
                    putInMap(rainQ, rainMap, upIndex, values[i]);
                }

                 s = map[downIndex][values[i]];
                if (validIndex(downIndex, indexInfos)
                        && !s.equals("X") && !s.equals("*") && !s.equals("H")) {
                    putInMap(rainQ, rainMap, downIndex, values[i]);
                }

                 s = map[keys[i]][leftIndex];
                if (validIndex(leftIndex, indexInfos)
                        && !s.equals("X") && !s.equals("*") && !s.equals("H")) {
                    putInMap(rainQ, rainMap, keys[i], leftIndex);
                }

                 s = map[keys[i]][rightIndex];
                if (validIndex(rightIndex, indexInfos)
                        && !s.equals("X") && !s.equals("*") && !s.equals("H")) {
                    putInMap(rainQ, rainMap, keys[i], rightIndex);
                }
            }

            int wSize = wQ.size();
            keys = getKeys(wQ);
            values = getValues(wQ);
            for (int i=0; i<wSize; i++) {
                int upIndex = keys[i] - 1, downIndex = keys[i] +1;
                int leftIndex = values[i] -1, rightIndex = values[i] + 1;

                String s = map[upIndex][values[i]];
                if (validIndex(upIndex, indexInfos)
                        && !s.equals("X") && !s.equals("*")) {
                    putInMap(rainQ, rainMap, upIndex, values[i]);
                }

                s = map[downIndex][values[i]];
                if (validIndex(downIndex, indexInfos)
                        && !s.equals("X") && !s.equals("*")) {
                    putInMap(rainQ, rainMap, downIndex, values[i]);
                }

                 s = map[keys[i]][leftIndex];
                if (validIndex(leftIndex, indexInfos)
                        && !s.equals("X") && !s.equals("*")) {
                    putInMap(rainQ, rainMap, keys[i], leftIndex);
                }

                s = map[keys[i]][rightIndex];
                if (validIndex(rightIndex, indexInfos)
                        && !s.equals("X") && !s.equals("*")) {
                    putInMap(rainQ, rainMap, keys[i], rightIndex);
                }
            }
            count++;
        }
    }

    private static void putInMap(Queue<Map<Integer,Integer>> q, Map<Integer,Integer> map, int kIndex,int vIndex ){
        map = new HashMap<>();
        map.put(kIndex, vIndex);
        q.add(map);
    }
    private static boolean validIndex (int index, int[] indexInfos) {
        return index < indexInfos[0] || index >= 0;
    }

    private static int[] getKeys(Queue<Map<Integer, Integer>> rainQ) {
        return rainQ.peek().keySet().stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    private static int[] getValues(Queue<Map<Integer, Integer>> rainQ) {
        return rainQ.poll().values().stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    private static int[] getInfos(BufferedReader br) throws IOException {
        return Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static String[] getValues(BufferedReader br) throws IOException {
        return (String[]) Arrays.stream(br.readLine().split(" "))
                .toArray();
    }
}
