def solution(word):
    words = ['A', 'E', 'I', 'O', 'U']
    # 자리수가 증가 할 때 바로뒤의 자리수가 없는 것 까지 포함되어야 하기 때문에
    # 5가 아닌 6(1 * 5 + 1), 25가 아닌 31(6 * 5 + 1), 125가 아닌 156(31 * 5 + 1) ... 이다. 
    weights = sorted([1, 6, 31, 156, 781], reverse=True)  
    order = 0

    for i, char in enumerate(word):
        index = words.index(char) 
        order += index * weights[i]
        order += 1 
    return order


# 다른 접근: DFS로 사전 직접 생성 후 인덱스 반환
def solution_v2(word):
    words = ['A', 'E', 'I', 'O', 'U']
    result = []
    def dfs(current, words, result):
        if len(current) > 5:
            return
        if current:
            result.append(current)
        for w in words:
            dfs(current + w, words, result)
    dfs('', words, result)
    return result.index(word) + 1

print(solution_v2("AAAAE"))


# @Day 1
from collections import deque
from operator import indexOf
def solution(word):
    words = ["A", "E", "I", "O", "U"]
    dq = deque()
    def dfs(w):
        if len(w) > 5:
            return
        if w:
            dq.append(w)
        for wd in words:
            dfs(w + wd)
    dfs('')
    return dq.index(word) + 1





from collections import deque
def solution(word):
    alpha_list = [
         'A', 'E', 'I', 'O', 'U'
    ]
    dq = deque()
    def dfs(temp):
        if temp:
            dq.append(temp[-1])
        if len(temp) == 5:
            return
        for a in alpha_list:
            temp.append(temp[-1] + a if temp else a)
            dfs(temp)
            temp.pop()
    dfs([])
    return dq.index(word) + 1


print(solution("AAAAE"))   # 6
print(solution("AAAE"))    # 10
print(solution("I"))       # 1563
print(solution("EIO"))     # 1189