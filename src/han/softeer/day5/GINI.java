package han.softeer.day5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class GINI {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] indexInfos = getInfos(br);
        char[][] map = new char[indexInfos[0]][indexInfos[1]];
        int[][] dxy = {{-1,0},{1,0},{0,-1},{0,1}};

        Queue<Map<List<Integer>, Integer>> wQ = new LinkedList<>();
        Queue<Map<List<Integer>, Integer>> rainQ = new LinkedList<>();

        for (int i=0; i< map.length; i++) {
            map[i] = getValues(br);
            for (int j=0; j<map[i].length; j++) {
                List<Integer> list = new ArrayList<>();
                Map<List<Integer>, Integer> m = new HashMap<>();
                if (map[i][j]== 'W') {
                    list.add(i);    list.add(j);
                    m.put(list, 0);
                    wQ.add(m);
                } else if (map[i][j] == '*') {
                    list.add(i);    list.add(j);
                    m.put(list, 0);
                    rainQ.add(m);
                }
            }
        }

        int cnt = 0, result = 0;
        boolean isBreak = false;
        while (!wQ.isEmpty() && !isBreak) {
            int rainSize = rainQ.size();
            for (int i=0; i<rainSize; i++) {
                Map<List<Integer>, Integer> m = rainQ.poll();
                for (int j=0; j < 4; j++) {
                    int nr = m.keySet().stream().findFirst().get().get(0)+dxy[j][0];
                    int nc = m.keySet().stream().findFirst().get().get(1)+dxy[j][1];
                    if(nr<0 || nr>=indexInfos[0] || nc<0 || nc>=indexInfos[1]) continue;
                    if(map[nr][nc] !='.') continue;
                    map[nr][nc] = '*';
                    rainQ.add(createRainMap(nr, nc, 0));
                }
            }
            int wSize = wQ.size();
            for (int i=0; i<wSize; i++) {
                Map<List<Integer>, Integer> m = wQ.poll();
                for (int j = 0; j < 4; j++) {
                    int nr = m.keySet().stream().findFirst().get().get(0)+dxy[j][0];
                    int nc = m.keySet().stream().findFirst().get().get(1)+dxy[j][1];
                    if(nr<0||nr>=indexInfos[0]||nc<0||nc>=indexInfos[1]) continue;
                    if(map[nr][nc] == '*' || map[nr][nc]== 'X' || map[nr][nc] == 'W') continue;
                    if(map[nr][nc] == 'H'){
                        result = m.get(m.keySet().stream().findFirst().get())+1;
                        isBreak = true;     break;
                    }
                    wQ.add(createRainMap(nr, nc, m.get(m.keySet().stream().findFirst().get())+1));
                    map[nr][nc] = 'W';
                }
            }
        }
        if (result == 0) {
            System.out.println("FAIL");
        } else {
            System.out.println(result);
        }
    }

    private static Map<List<Integer>, Integer> createRainMap(int nr, int nc, int value) {
        List<Integer> list = new ArrayList<>();
        Map<List<Integer>, Integer> maps = new HashMap<>();
        list.add(nr);
        list.add(nc);
        maps.put(list, value);
        return maps;
    }

    private static int[] getInfos(BufferedReader br) throws IOException {
        return Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
    private static char[] getValues(BufferedReader br) throws IOException {
        return br.readLine().toCharArray();
    }
}
