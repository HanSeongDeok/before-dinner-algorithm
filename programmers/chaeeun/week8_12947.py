def solution(x):
    num = sum([int(char) for char in str(x)])
    return x % num == 0
