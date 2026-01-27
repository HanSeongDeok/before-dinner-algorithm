# @ Day 1
# 원형 큐 + 슬라이딩 윈도우
def solution(elements):
    size = len(elements)
    result_set = set(elements)
    elements *= 2
    for e in range(2, size+1):
        for i in range(size):
            sum_n = sum(elements[i : e+i])
            result_set.add(sum_n)
    return len(result_set)

print(solution([7,9,1,1,4]))