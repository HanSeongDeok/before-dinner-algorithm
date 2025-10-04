# @Day 1
def solution(s):
    numbers = list(map(int, s.split()))
    return f"{min(numbers)} {max(numbers)}"


# @Day2
def solution2(s):
    return f'{min(list(map(int, s.split())))} {max(list(map(int, s.split())))}'



# @Day3
def solution3(s):
    min_s = min(map(int, s.split()))
    max_s = max(map(int, s.split()))
    return f'{min_s} {max_s}'  

# @Day4
def solution(s):
    min_n = min(map(int, s.split()))
    max_n = max(map(int, s.split()))
    return f'{min_n} {max_n}'












print(solution('1 2 3 4'))
print(solution('-1 -2 -3 -4'))
print(solution2('1 2 3 4'))
print(solution2('-1 -2 -3 -4'))
print(solution3('1 2 3 4'))
print(solution3('-1 -2 -3 -4'))