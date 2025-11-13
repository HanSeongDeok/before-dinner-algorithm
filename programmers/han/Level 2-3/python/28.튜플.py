# 알고리즘 유형: 집합(set) 및 구현
# 각 집합의 크기별로 정렬 후, 순서대로 새로운 원소를 찾아내는 방식(집합 차집합 응용)
from unittest import result


def solution(s):
    s = s[2:-2].split("},{")
    s = [list(map(int, x.split(','))) for x in s]
    s.sort(key=len)
    answer = []
    for group in s:
        for num in group:
            if num not in answer:
                answer.append(num)
    return answer

# @ Day1
def solution(s):
    s = s[2:-2].split('},{')
    s = list(x.split(',') for x in s)
    s = sorted(s, key=lambda x: len(x))
    result = []
    for i in s:
        for j in i:
            if j not in result:
                result.append(j)
    return list(map(int, result))




# @ Day2
def solution(s):
    s = sorted(s[2:-2].split("},{"), key=len)
    result = []
    for c in s:
        c = c.split(',')
        for i in c:
            if i not in result:
                result.append(i)
    return list(map(int, result))





# 예시 테스트
print(solution("{{2},{2,1},{2,1,3},{2,1,3,4}}"))      # [2, 1, 3, 4]
print(solution("{{1,2,3},{2,1},{1,2,4,3},{2}}"))      # [2, 1, 3, 4]
print(solution("{{20,111},{111}}"))                   # [111, 20]
print(solution("{{123}}"))                            # [123]
print(solution("{{4,2,3},{3},{2,3,4,1},{2,3}}"))      # [3, 4, 2, 1]
