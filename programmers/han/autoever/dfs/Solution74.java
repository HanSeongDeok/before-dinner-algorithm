package dfs;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 74. 여행 경로
 * 알고리즘 유형: 깊이 우선 탐색(DFS)
 */
public class Solution74 {
    List<List<String>> answer = new ArrayList<>();
    boolean[] memo;
    /**
     * @Day 1
     * @param tickets
     * @return
     */
    public String[] solution(String[][] tickets) {
        List<String> path = new ArrayList<>();
        path.add("ICN"); 
        memo = new boolean[tickets.length];
        
        Arrays.sort(tickets, (a, b)-> a[0].equals(b[0]) ? a[1].compareTo(b[1]) : a[0].compareTo(b[0]));
        dfs("ICN", path, tickets);

        return answer.get(0).stream().toArray(String[]::new);
    }

    private void dfs(String airplane, List<String> path, String[][] tickets) {
        if (path.size() == tickets.length+1) {
            List<String>paths = path.stream().collect(Collectors.toList());
            answer.add(paths);
            return;
        }
        for (int i=0; i< tickets.length; i++) {
            if(!memo[i] && tickets[i][0].equals(airplane)) {
                memo[i] = true;
                path.add(tickets[i][1]);
                dfs(tickets[i][1], path, tickets);
                memo[i] = false;
                path.remove(path.size() - 1); 
            }
        }
    } 

    List<List<String>> answer2 = new ArrayList<>();
    boolean[] memo2;
    public String[] solution2(String[][] tickets) {
        memo2 = new boolean[tickets.length];
        List<String> path = new ArrayList<>();
        path.add("ICN");

        Arrays.sort(tickets, (a, b) -> a[0].equals(b[0]) ? a[1].compareTo(b[1]) : a[0].compareTo(b[0]));
        dfs2("ICN", path, tickets);
        return answer2.get(0).stream().toArray(String[]::new);
    }

    private void dfs2(String start, List<String> path, String[][] tickets) {
        if (path.size() == tickets.length+1) {
            answer2.add(new ArrayList<>(path));
            return ;
        }

        for (int i =0; i < tickets.length; i++) {
            if (!memo2[i] && tickets[i][0].equals(start)) {
                memo2[i] = true;
                path.add(tickets[i][1]);
                dfs2(tickets[i][1], path, tickets);
                memo2[i] = false;
                path.remove(path.size()-1);
            }
        }
    }


    public static void main(String[] args) {
        Solution74 s = new Solution74();
        String[][] tickets = { { "ICN", "JFK" }, { "HND", "IAD" }, { "JFK", "HND" } };
        String[][] tickets2 = { 
            { "ICN", "SFO" }, 
            { "ICN", "ATL" }, 
            { "SFO", "ATL" }, 
            { "ATL", "ICN" }, 
            { "ATL", "SFO" } 
        };
        String[] answer = s.solution(tickets2);
        for (String s1 : answer) {
            System.out.print(s1 + " ");
        }
    }
}
