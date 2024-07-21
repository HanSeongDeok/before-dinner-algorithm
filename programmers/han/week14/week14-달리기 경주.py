# 시간초과...
def solution(players, callings):
    cnt = 1
    for i in range(len(callings)):
        target = callings[i]
        if i + cnt < len(callings) and callings[i+cnt] == target:
            cnt += 1
            continue 
        index = players.index(target)
        players.remove(target)
        players.insert(index-cnt, target) 
        cnt = 1
    return players

# GPT 답지
def solution2(players, callings):
    # 딕셔너리를 사용하여 선수들의 현재 인덱스를 추적
    index_map = {player: i for i, player in enumerate(players)}
    
    cnt = 1
    for i in range(len(callings)):
        target = callings[i]
        if i + cnt < len(callings) and callings[i + cnt] == target:
            cnt += 1
            continue
        
        current_index = index_map[target]
        new_index = max(current_index - cnt, 0)
        
        # 인덱스 변경에 따라 위치를 업데이트
        if new_index != current_index:
            # 모든 영향을 받는 선수들의 인덱스를 업데이트
            for player, idx in index_map.items():
                if new_index <= idx < current_index:
                    index_map[player] += 1
            index_map[target] = new_index

        cnt = 1

    # index_map을 사용하여 최종 players 리스트를 재구성
    sorted_players = sorted(index_map.items(), key=lambda x: x[1])
    players = [player for player, _ in sorted_players]
    
    return players

# 예시 호출
players = ["michael", "lebron", "kobe", "shaq", "duncan"]
callings = ["lebron", "shaq", "kobe", "lebron", "shaq"]
print(solution(players, callings))  # 최종 결과 출력

solution(["mumu", "soe", "poe", "kai", "mine"],
         ["kai", "kai", "mine", "mine"])