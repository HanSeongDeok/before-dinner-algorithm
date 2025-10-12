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

print(solution("ULURRDLLU"))  # 7
print(solution("LULLLLLLU"))  # 7
