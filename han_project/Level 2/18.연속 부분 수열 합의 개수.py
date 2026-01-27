def solution(elements):
    size = len(elements)
    stream_set = set()
    elements = elements * 2  # 원형 리스트 효과를 위해 두 배로 확장
    for i in range(1, size+1):
        for j in range(size):
            stream_set.add(sum(elements[j : (j + i)]))
    return len(stream_set)

def solution2(elements):
    n = len(elements)
    elements = elements * 2  # 원형 리스트 효과를 위해 두 배로 확장
    stream_set = set()
    
    # 길이 1부터 n까지의 연속된 부분 수열의 합을 계산
    for length in range(1, n + 1):
        current_sum = sum(elements[:length])  # 초기 부분 수열 합
        stream_set.add(current_sum)
        
        for start in range(1, n):
            current_sum = current_sum - elements[start - 1] + elements[start + length - 1]
            stream_set.add(current_sum)
    
    return len(stream_set)

print(solution([7,9,1,1,4]))