# 19. 괄호 회전하기
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

print(solution("}]()[{"))

# 18. 연속 부분 수열 합의 개수
def solution(elements):
    size = len(elements)
    elements *= 2
    stream_set = set()
    for i in range(1, size + 1):
        for n in range(size):
            stream_set.add(sum(elements[n : n + i]))
    return len(stream_set)

print(solution([7,9,1,1,4]))