# 최소공배수 LCM = a*b / GCD -> 유클리드 호제법을 통해 구할 수 있다.
# 이 문제 또한 내일 다시 풀어보기!
def solution(arr):
    arr = sorted(arr)
    answer = arr[0]
    for i in range(1, len(arr)):
        answer = custom_LCM(lambda a, b: custom_GCD(a,b), 
                   answer, 
                   arr[i])
    return answer

def custom_GCD(a, b):
    b, a = max(a,b), min(a,b)
    while b % a != 0:
        mod = b % a
        b, a = a, mod
    return int(a)
    
def custom_LCM(gcd, a, b):
    return int(a * b / gcd(a, b))

print(solution([2,6,8,14]))