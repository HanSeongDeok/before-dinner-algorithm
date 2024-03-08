import numpy
def solution(x: int, n: int) -> list:
    # 등차수열
    return [0] * n\
        if x == 0\
        else numpy.arange(x, x * (n+1) ,x).tolist()

# 0일 때 생각을 못함 ㅜㅜ
print(solution(2, 5))