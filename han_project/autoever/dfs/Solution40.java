package dfs;

import java.util.*;

public class Solution40 {
    private int len;
    private List<List<String>> answers;

    public String[] solution(String[][] tickets) {
        len = tickets.length + 1;
        answers = new ArrayList<>();
        String[] answer = new String[len];

        Map<String, List<String>> map = new HashMap<>();
        Map<String, List<Boolean>> state = new HashMap<>();

        for (String[] t : tickets) {
            String start = t[0], end = t[1];
            map.computeIfAbsent(start, s -> new ArrayList<>()).add(end);
            state.computeIfAbsent(start, s -> new ArrayList<>()).add(false);
        }

        List<String> list = new ArrayList<>();
        list.add("ICN");

        dfs(map, state, list, "ICN");
        Collections.sort(answers, (a1, a2) -> a1.toString().compareTo(a2.toString()));

        for (int i=0; i < len; i++) answer[i] = answers.get(0).get(i);
        return answer;
    }

    private void dfs(Map<String, List<String>> map, Map<String, List<Boolean>> state, List<String> list, String start) {
        if (list.size() == len) {
            answers.add(new ArrayList<>(list));
            return;
        }

        if (!map.containsKey(start)) return;

        List<String> ticketList = map.get(start);
        List<Boolean> stateList = state.get(start);  

        for (int i =0; i < ticketList.size(); i++) {
            if (!stateList.get(i)) {
                stateList.set(i, true);
                list.add(ticketList.get(i));
                dfs(map, state, list, ticketList.get(i));
                list.remove(list.size() - 1);
                stateList.set(i, false);
            }
        }
    }

    public static void main(String[] args) {
        Solution40 s40 = new Solution40();
        s40.solution(new String[][] {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK","HND"}});
        s40.solution(new String[][] { { "ICN", "SFO" }, { "ICN", "ATL" }, { "SFO", "ATL" }, { "ATL", "ICN" },{ "ATL", "SFO" } });
    }
}
