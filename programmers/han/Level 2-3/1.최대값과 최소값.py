# Day 1
def solution(s):
    numbers = list(map(int, s.split()))
    return f"{min(numbers)} {max(numbers)}"


# Day2
def solution2(s):
    return f'{min(list(map(int, s.split())))} {max(list(map(int, s.split())))}'


print(solution('1 2 3 4'))
print(solution2('1 2 3 4'))