#12 구명보트
def solution(people, limit):
    people = sorted(people, reverse=True)
    l_point, r_point = 0, len(people)-1
    result = 0
    while (r_point >= l_point):
        if people[l_point] + people[r_point] <= limit:
            l_point += 1
            r_point -= 1
        else:
            l_point += 1
        result += 1
    return result

#13 멀리 뛰기
# Dynamic programming 동적 계획법 문제
def solution(n):
    # n = 1, n = 2 ... n = a 일때 도달 가능한 경우의 수가
    # n = 3 일 때 (n - 2) + (n -1)의 경우의 수와 같다 즉, 피보나치 수열 형태를 띈다.
    # 따라서 n에 대한 동적 계획법으로 풀이 가능 
    fibo_1, fibo_2 = 1, 2
    result = 1
    for i in range(2, n):
        result = fibo_1 + fibo_2
        fibo_1 = fibo_2
        fibo_2 = result 
    if n == 2:
        result = 2
    return result % 1234567

#14 N개의 최소공배수
# 최소공배수 LCM = a*b / GCD -> 유클리드 호제법을 통해 구할 수 있다.
def solution(arr):
    result = 0
    if(len(arr) == 1):
        return arr[0]
    
    a, b = arr[0], arr[1]
    result = int(a * b / custom_GCD(a, b))
    for i in range(2, len(arr)):
        a = result
        b = arr[i]
        result = int(a * b / custom_GCD(a, b))
    return result

def custom_GCD(a, b):
    #b, a = max(a,b), min(a,b)
    mod = -1
    while(mod != 0):
       mod = int(b % a)
       b = a
       a = mod
    return b

print(solution([2, 6, 8, 14]))