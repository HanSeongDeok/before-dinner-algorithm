def solution(cards1, cards2, goal):
    cnt1, cnt2 = 0, 0
    for i in range(len(goal)):
        if len(cards1) > cnt1 and\
           (cards1[cnt1] == goal[i]):
           cnt1 += 1
        elif len(cards2) > cnt2 and\
           (cards2[cnt2] == goal[i]):
           cnt2 += 1
        else: 
           return "No"           
    return "Yes"