package implementation;

// 프로그래머스 Lv.1 - 오픈채팅방 (2019 KAKAO BLIND RECRUITMENT)
// https://school.programmers.co.kr/learn/courses/30/lessons/42888

import java.util.*;

public class Solution31 {
    public String[] solution(String[] record) {
        String[] answer = {};
        Map<String, String> nameMap = new HashMap<>();

        StringTokenizer st;
        for (String r : record) {
            st = new StringTokenizer(r);
            String command = st.nextToken(), uuid = st.nextToken();
            if (command.equals("Enter") || command.equals("Change")) {
                String nickName = st.nextToken();
                nameMap.put(uuid, nickName);
            } 
        }

        StringBuilder sb = new StringBuilder();
        for (String r : record) {
            st = new StringTokenizer(r);
            String command = st.nextToken(), uuid = st.nextToken();
            if (command.equals("Enter")) {
                sb.append(String.format("%s님이 들어왔습니다.", nameMap.get(uuid)))
                    .append("\n");
            } else if (command.equals("Leave")) {
                sb.append(String.format("%s님이 나갔습니다.", nameMap.get(uuid)))
                    .append("\n");
            }
        }
        answer = sb.toString().split("\n");
        return answer;
    }
    public static void main(String[] args) {
        Solution31 s31 = new Solution31();
        String[] records = {
            "Enter uid1234 Muzi",
            "Enter uid4567 Prodo",
            "Leave uid1234",
            "Enter uid1234 Prodo",
            "Change uid4567 Ryan"
        };
        s31.solution(records);
    }
}
