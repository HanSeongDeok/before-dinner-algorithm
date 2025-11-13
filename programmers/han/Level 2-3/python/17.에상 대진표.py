
# @ Day 1
# 시뮬레이션 유형 수학적 사고
def solution(N, A, B):
    result = 0
    while A != B:
        A = (A + 1) // 2
        B = (B + 1) // 2
        result += 1
    return result

print(solution(8, 4, 7))