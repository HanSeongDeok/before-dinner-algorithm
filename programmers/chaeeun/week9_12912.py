def solution(a, b):
    big = max(a, b)
    small = min(a, b)
    nums = [i for i in range(small, big + 1)]
    return sum(nums)
