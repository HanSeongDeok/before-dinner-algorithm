# ㅋㅋㅋㅋ n을 테스트 케이스의 숫자로 하드코딩하는 실수를 범함
def solution(n):
    answer = []
    for i in range(1, n+1):
        tmp = []
        start, stack_cnt = i, 0
        while (stack_cnt <= n):
            if sum(tmp) == n:
                answer.append(tmp)
                break
            tmp.append(start)
            stack_cnt += start
            start += 1
    return len(answer)

print(solution(15))