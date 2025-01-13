# 오답 
def solution_(dirs):
    answer = 0
    # [0]: y / [1]: x
    dir_dict = {"U" : [1, 0], "D": [-1, 0], "L" : [0, -1], "R" : [0, 1]}
    current_dir, before_dir = [0,0], [0,0]
    memo = []
    for d in dirs:
        current_dir[0] += dir_dict[d][0] 
        current_dir[1] += dir_dict[d][1]
        if current_dir[0] > 5 or current_dir[0] < -5 or current_dir[1] > 5 or current_dir[1] < -5:
            if current_dir[0] > 5 : current_dir[0] = 5
            if current_dir[0] < -5 : current_dir[0] = -5
            if current_dir[1] > 5 : current_dir[1] = 5
            if current_dir[1] < -5 : current_dir[1] = -5
            continue
        moving = before_dir + current_dir 
        if moving in memo:
            before_dir = current_dir[:]
            continue
        memo.append(moving[:])
        before_dir = current_dir[:]
        answer += 1
    return answer

print(solution_("ULURRDLLU"))
print(solution_("LULLLLLLU"))

# RETRY 1 =>  **(A → B)**와 **(B → A)**가가 동일한 경로임을 간과 함 !!!! 이런!!!!
def solution(dirs):
    answer = 0
    # [0]: y / [1]: x
    dir_dict = {"U" : [1, 0], "D": [-1, 0], "L" : [0, -1], "R" : [0, 1]}
    current_dir, before_dir = [0,0], [0,0]
    memo = list()
    for d in dirs:
        check_y = current_dir[0] + dir_dict[d][0] 
        check_x = current_dir[1] + dir_dict[d][1]
        if check_y > 5 or check_y < -5 or check_x > 5 or check_x < -5:
            continue
        
        current_dir[0], current_dir[1] = check_y, check_x
        moving = sorted([before_dir, current_dir])
        moving = moving[0] + moving[1]
        
        if moving not in memo:
            memo.append(moving[:])
            answer += 1
    
        before_dir = current_dir[:]   
    return answer

print(solution("LULLLLLLU"))
print(solution("ULURRDLLU"))
