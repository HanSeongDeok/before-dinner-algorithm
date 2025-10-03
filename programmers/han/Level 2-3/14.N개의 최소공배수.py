from math import gcd

# GCD(최대공약수, Greatest Common Divisor)와 LCM(최소공배수, Least Common Multiple) 유형
# 최소 공배수 = a x b / 최대공약수 (GCD)
# 최대 공약수 = 두 수 a, b에 대해, a와 b를 나눌 수 있는 가장 큰 수
# ** 유클리드 호제법: gcd(a, b) = gcd(b, a % b), b가 0이 될 때 a가 최대공약수 **
def solution(arr):
    def lcm(a, b):
        return a * b // custom_gcd(a, b)
    
    answer = arr[0]
    for num in arr[1:]:
        answer = lcm(answer, num)
    return answer

def custom_gcd(a, b):
    mod = -1
    while mod:
        mod = int(a % b)
        a = b
        b = mod
    return a

# @Day 2
from math import gcd
def solution(arr):
    a = arr[0]
    result = 0
    for b in arr[1:]:
        a = a * b // custom_gcd(a, b)
        result = a
    return result 

def custom_gcd(a, b):
    while b:
        mod = a % b
        a = b
        b = mod
    return a

print(custom_gcd(24, 45))
print(solution([2,6,8,14]))