# @Day 1
def solution(n, left, right):
    result = []
    for i in range(left, right+1):
        r, c = (i % n), (i // n)
        result.append(max(r, c) + 1)
    return result



# @Day 2
def solution(n, left, right):
    result = []
    for i in range(left, right + 1):
        v, r = divmod(i, n)
        result.append(max(v, r) + 1)
    return result


print(solution(3, 2, 5))