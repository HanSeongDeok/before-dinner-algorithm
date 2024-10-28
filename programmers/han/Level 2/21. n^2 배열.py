def solution(n, left, right):
    answer = []
    tmp = [i for i in range(1, n+1)]
    for i in range(n):
        for j in range(i):
            tmp[j] = i+1
        answer.append(tmp[:])
    
    arr_answer = []
    for i in range(left, right+1):
        point = answer[int(i // n)][int(i % n)]
        arr_answer.append(point)
    return arr_answer

## WOW!!! -> 어떻게 이런 생각을 할 수 있지... 
def solution(n, left, right):
    answer = []
    for i in range(left, right + 1):
        r = i // n  # 각 행의 첫 번째 숫자는 인덱스를 n으로 나눈 값과 동일하며 그 값의 개수만큼 같은 값을 갖는다
        c = i % n   # 각 열의 인덱스는 n으로 나눈 나머지 + 1과 같지만 행의 패턴이 우선시 된다.
        answer.append(max(r, c) + 1)
    return answer
 
def solution(n, left, right):
    answer = []
    for i in range(left, right + 1):
        m = i % n
        v = i // n
        answer.append(max(m, v) + 1)
    return answer

print(solution(4, 7, 14))