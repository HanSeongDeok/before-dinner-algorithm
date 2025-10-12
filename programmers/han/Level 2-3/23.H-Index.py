# 아래 citations 배열을 입력하면 위 코드가 오답을 출력합니다.
# 예시: [4, 4, 4, 4]
# 정답은 4여야 하지만, 위 코드는 5를 반환합니다.

# @ day1
# 그리디 알고리즘
def solution(citations):
    citations = sorted(citations, reverse=True)
    for i in range(len(citations)):
        if i + 1 > citations[i]:
            return i
    return len(citations)





def solution(citations):
    citations = sorted(citations, reverse= True)
    for i in range(len(citations)):
        if i + 1 > citations[i]:
            return i
    return len(citations)


print(solution([3, 0, 6, 1, 5]))
print(solution([1, 0, 0, 0, 0]))