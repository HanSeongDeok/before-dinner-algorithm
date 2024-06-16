def solution(lottos, win_nums):
    same_num = 0
    zero_num = 0
    
    for i in range(6):
        if lottos[i] == 0:
            zero_num += 1
        elif lottos[i] in win_nums:
            same_num += 1
    
    highest_rank = min(7 - (same_num + zero_num), 6)
    lowest_rank = min(7 - same_num, 6)
    
    return [highest_rank, lowest_rank]
    return answer
