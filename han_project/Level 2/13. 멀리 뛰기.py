# Dynamic programming 동적 계획법 문제
# 다시 풀어보기!!
def solution(n):
    answer = 0
    # n = 1, n = 2 ... n = a 일때 도달 가능한 경우의 수가
    # n = 3 일 때 (n - 2) + (n -1)의 경우의 수와 같다 즉, 피보나치 수열 형태를 띈다.
    # 따라서 n에 대한 동적 계획법으로 풀이 가능    
    one_step, two_step = 1, 2
    if n == one_step:
        return 1
    if n == two_step:
        return 2
    
    for i in range(3, n+1):
        answer = (one_step + two_step) 
        one_step = two_step
        two_step = answer
    
    return answer % 1234567

print(solution(5))