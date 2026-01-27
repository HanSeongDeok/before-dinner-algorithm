from collections import deque
#@Day 1
def solution(dirs):
    answer = 0
    dirs_dict = {
        "U": [0, 1],
        "D": [0, -1],
        "L": [-1, 0],
        "R": [1, 0],
    }
    visited = deque([[0, 0]])
    for d in dirs:
        prev = visited[-1]
        step = [dirs_dict[d][0] + prev[-2], dirs_dict[d][1] + prev[-1]]
        if -5 <= step[0] <= 5 and -5 <= step[1] <= 5:
            if prev[-2:] + step not in visited and step + prev[-2:] not in visited:
                answer += 1
            visited.append(prev[-2:] + step)
    return answer





def solution(s):
    s_dict = {
        "U" : [0,1],
        "D" : [0,-1],
        "R" : [1,0],
        "L" : [-1,0],
    }

    visited = deque([[0, 0]])
    answer = 0
    for c in s:
        lstep = visited[-1][-2:]
        nx = s_dict[c][0] + lstep[0]
        ny = s_dict[c][1] + lstep[1]
        if -5 <= nx <= 5 and -5 <= ny <= 5:
            if lstep + [nx, ny] not in visited and [nx, ny] + lstep not in visited:
                answer += 1
            visited.append(lstep + [nx, ny])
    return answer

def solution(dirs):
    xy_dict = {
        "U": [0, 1],
        "D": [0, -1],
        "L": [-1, 0],
        "R": [1, 0],
    }

    dq = deque([[0, 0]])
    result = 0
    for d in dirs:
        now = dq[-1][-2:]

        x_now = now[0]
        y_now = now[1]

        x_next = xy_dict[d][0] + x_now
        y_next = xy_dict[d][1] + y_now

        if -5 <= x_next <= 5 and -5 <= y_next <= 5:
            if now + [x_next, y_next] not in dq and [x_next, y_next] + now not in dq:
                result += 1
            dq.append(now + [x_next, y_next])
    return result


print(solution("ULURRDLLU"))  # 7
print(solution("LULLLLLLU"))  # 7
