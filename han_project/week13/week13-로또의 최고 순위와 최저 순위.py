def solution(lottos, win_nums):
    won_table = {0: 6, 1: 6, 2: 5, 3: 4, 4: 3, 5: 2, 6: 1}
    answer = [0] * 2
    cnt = 0
    for i in lottos:
        if i in win_nums:
            cnt+=1
            win_nums.remove(i)
    
    answer[1] = won_table[cnt]
    
    check = len(win_nums)
    for i in lottos:
        if check == 0:
            break
        if i != 0:
            continue
        cnt+=1
        check-=1
    
    answer[0] = won_table[cnt]
    return answer