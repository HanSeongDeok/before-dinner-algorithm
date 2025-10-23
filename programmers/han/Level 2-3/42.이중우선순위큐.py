from collections import deque
def solution(operations):
    dq = deque()

    for oper in operations:
        if oper == "D 1":
            if dq:
                dq.remove(max(dq))
        elif oper == "D -1":
            if dq:
                dq.remove(min(dq))
        else:
            dq.append(int(oper.split(' ')[-1]))

    if not dq:
        return [0, 0]

    return [max(dq), min(dq)] if len(dq) >= 2 else [dq[0], dq[0]]



print(solution(["I 16","D 1"]))  # [0,0]
print(solution(["I 7","I 5","I -5","D -1"]))  # [7,5]
print(solution(["I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"]))  # [0,0]
print(solution(["I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"]))  # [333, -45]



## 백준 통과 버전  heapq + lazy deletion
import heapq

def solution(operations):
    min_heap = []
    max_heap = []
    visited = [False] * len(operations)  # 어떤 값이 이미 삭제되었는지 추적

    for i, oper in enumerate(operations):
        if oper[0] == 'I':  # 삽입
            num = int(oper.split()[1])
            heapq.heappush(min_heap, (num, i))
            heapq.heappush(max_heap, (-num, i))
            visited[i] = True
        elif oper == 'D 1':  # 최댓값 삭제
            # 이미 삭제된 원소는 건너뛰기
            while max_heap and not visited[max_heap[0][1]]:
                heapq.heappop(max_heap)
            if max_heap:
                visited[max_heap[0][1]] = False
                heapq.heappop(max_heap)
        elif oper == 'D -1':  # 최솟값 삭제
            while min_heap and not visited[min_heap[0][1]]:
                heapq.heappop(min_heap)
            if min_heap:
                visited[min_heap[0][1]] = False
                heapq.heappop(min_heap)

    # 정리: 아직 살아 있는 값만 남기기
    while min_heap and not visited[min_heap[0][1]]:
        heapq.heappop(min_heap)
    while max_heap and not visited[max_heap[0][1]]:
        heapq.heappop(max_heap)

    if not min_heap or not max_heap:
        return [0, 0]
    return [-max_heap[0][0], min_heap[0][0]]