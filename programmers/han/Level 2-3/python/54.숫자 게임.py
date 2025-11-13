# @Day 1
def solution(A, B):
    answer = 0
    A = sorted(A, reverse=True)
    B = sorted(B, reverse=True)
    
    if A[-1] >= B[0]:
        return answer

    idx = 0
    for a in A:
        if a < B[idx]:
            answer += 1
            idx += 1 

    return answer

print(solution([5,1,3,7], [2,2,6,8]))  # 3
print(solution([2,2,2,2], [1,1,1,1]))  # 0
