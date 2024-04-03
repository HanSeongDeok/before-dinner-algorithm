from itertools import combinations
from math import sqrt

def solution(nums):
    answer = 0
    for combo in combinations(nums, 3):
        if is_prime(sum(combo)):
            answer += 1
    return answer

def is_prime(n):
    if n < 2:
        return False
    for i in range(2, int(sqrt(n)) + 1):
        if n % i == 0:
            return False
    return True
