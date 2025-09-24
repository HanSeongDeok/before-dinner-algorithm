# @ Day 1
def solution (A, B) :
    sum = 0
    sort_a = sorted(A)
    sort_b = sorted(B, reverse=True)

    for a, b in zip(sort_a, sort_b):
        sum += a * b
    
    return sum

# @Day 2
def solution(A, B):
    sort_A = sorted(A)
    sort_reverse_B = sorted(B, reverse=True)
    sum_AB = 0
    for a, b in zip(sort_A, sort_reverse_B):
        sum_AB += a * b
    return sum_AB
    

# @Day3 
def solution(A, B):
    sort_A = sorted(A)
    sort_B = sorted(B, reverse=True)
    return sum(a*b for a, b in zip(sort_A, sort_B))


print(solution([1, 4, 2], [5, 4, 4])) 
print(solution([1,2], [3,4]))