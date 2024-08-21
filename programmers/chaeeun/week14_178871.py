def solution(players, callings):
    rank = {}
    for i in range(len(players)):
        rank[players[i]] = i

    for calling in callings:
        current_index = rank[calling]  # 현재 순위
        
        # 선수 추월
        if current_index > 0:
            front_player = players[current_index - 1]
            
            # 순서 교환
            players[current_index], players[current_index - 1] = players[current_index - 1], players[current_index]
            
            rank[calling] -= 1
            rank[front_player] += 1

    return players
