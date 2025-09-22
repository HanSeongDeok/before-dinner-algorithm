# @ Day 1
def solution (A, B) :
    sum = 0
    sort_a = sorted(A)
    sort_b = sorted(B, reverse=True)

    for a, b in zip(sort_a, sort_b):
        sum += a * b
    
    return sum

print(solution([1, 4, 2], [5, 4, 4]	)) 
print(solution([1,2], [3,4]))