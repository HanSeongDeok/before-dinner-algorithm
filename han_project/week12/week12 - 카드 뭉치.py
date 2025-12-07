def solution2(cards1, cards2, goal):
    compared_1 = [i for i in goal if i not in cards2]
    compared_2 = [i for i in goal if i not in cards1]    
    return "Yes" if (compared_1 == cards1) and (compared_2 == cards2) else "No"

print(solution2(["i", "am"], ["want", "to"], ["i", "want", "to", "am"]))

def solution(cards1, cards2, goal):
    cnt_1, cnt_2 = 0, 0
    for i in goal:
        if cnt_1 < len(cards1) and cards1[cnt_1] == i:
            cnt_1 += 1
        elif cnt_2 < len(cards2) and cards2[cnt_2] == i:
            cnt_2 += 1
        else:
            return "No"
    return "Yes"
    
print(solution(["i", "am"], ["want", "to"], ["i", "want", "to", "am"]))