from collections import deque
#@ Day 1
def solution(s):
    dq_s = deque(s)
    result = 0
    valid_dict = {
        "{" : "}",
        "(" : ")",
        "[" : "]"
    }
    for i in range(len(dq_s)):
        temp_list = []
        isTrue = True
        for c in dq_s:
            if not temp_list and c not in valid_dict.keys():
                isTrue = False
                break
            if c in valid_dict.keys():
                temp_list.append(c)
            elif temp_list and c != valid_dict[temp_list.pop()]:
                isTrue = False
                break
            
        if isTrue and not temp_list:
            result += 1
        dq_s.append(dq_s.popleft())
    return result

def solution(s):
    answer = 0
    pair_map = {
    "{" : "}",
    "[" : "]",
    "(" : ")"
    }
    size = len(s)
    s *= 2  
    for i in range(size):
        isCorrect = True
        temp_list = []
        for c in s[i : i+size]:
            if not temp_list and c not in pair_map:
                isCorrect = False
                break
            if c in pair_map:
                temp_list.append(c)
            elif pair_map[temp_list.pop()] != c:
                isCorrect = False
                break
        if isCorrect and not temp_list:
            answer += 1
    return answer

print(solution("[](){}"))
print(solution("}]()[{"))
print(solution("[)(]"))
print(solution("}}}"))