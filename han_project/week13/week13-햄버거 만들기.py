# 시간 초과 O(n^2) 
def solution(ingredient):
    hanberger_set = [1, 2, 3, 1]
    answer = 0
    while(is_contain(ingredient, hanberger_set)):
        answer += 1
    return answer

def is_contain(ingredient, hanberger_set):
    for i in range(len(ingredient) - 3):
        if ingredient[i:i + 4] == hanberger_set:
            del ingredient[i:i + 4]
            return True
    return False

# 수정본 O(n)
def solution(ingredient):
    hanberger_set = [1, 2, 3, 1]
    stack = []
    answer = 0
    for item in ingredient:
        stack.append(item)
        if stack[-4:] == hanberger_set:
            answer += 1
            del stack[-4:]
    return answer

print(solution([2, 1, 1, 2, 3, 1, 2, 3, 1]))