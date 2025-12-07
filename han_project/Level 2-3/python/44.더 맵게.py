
from collections import deque

def solution(scoville, K):
    q = deque(sorted(scoville))
    result = 0

    while len(q) > 1:
        first = q.popleft()
        if first >= K:
            # 이미 K 이상이면 종료
            q.appendleft(first)
            break
        second = q.popleft()
        new_val = first + second * 2

        # new_val을 올바른 위치에 삽입하여 정렬 유지 (insert sort)
        inserted = False
        for i in range(len(q)):
            if new_val < q[i]:
                q.insert(i, new_val)
                inserted = True
                break
        if not inserted:
            q.append(new_val)
        result += 1

    # 마지막 원소가 K 이상이어야 성공
    return result if q and q[0] >= K else -1


# 시간 복잡도 분석:
# - 각 반복(iteration)마다 dq.popleft() 두 번 (O(1)씩)
# - 새로운 mix 값을 dq에 정렬 상태로 삽입해야 함 (for문: dq의 길이 N인 경우 최악 O(N) 소요, insert도 O(N))
# - 최악의 경우 매번 dq 전체를 훑어야 하므로, while 루프가 최대 N번 반복 시 전체 O(N^2)
# - 즉, 이 방식은 while 루프당 O(N) × 최대 N회 = O(N^2)의 시간 복잡도를 가짐

from collections import deque
def solution(scoville, K):
    dq = deque(sorted(scoville))
    result = 0

    while len(dq) > 1:
        first = dq.popleft()
        if first >= K:
            dq.appendleft(first)
            break
        second = dq.popleft()
        mix = first + second * 2 
        
        # dq에 mix 삽입: O(N) (최악)
        check = False
        for i in range(len(dq)):
            if mix <= dq[i]:
                dq.insert(i, mix)
                check = True
                break
        if not check:
            dq.append(mix)
        result += 1

    return result if dq and dq[0] >= K else -1



import heapq
"""
heapq 모듈은 파이썬에서 제공하는 최소 힙(min-heap) 자료구조를 위한 라이브러리입니다.
리스트 기반으로 동작하며, 우선순위 큐(priority queue) 구현에 자주 활용됩니다.
항상 가장 작은 값이 0번째 인덱스에 위치하도록 유지합니다.

주요 함수 설명:

- heapq.heapify(x): 리스트 x를 힙 구조로 변환합니다. O(N) 시간 복잡도.
- heapq.heappush(heap, item): heap에 item을 추가하여 힙 속성을 유지합니다. O(log N) 시간.
- heapq.heappop(heap): heap에서 가장 작은 원소를 제거 후 반환합니다. O(log N) 시간.
- heapq.heappushpop(heap, item): item을 먼저 heap에 넣은 다음, 가장 작은 원소를 제거 및 반환합니다. push와 pop을 동시에 더 효율적으로 처리할 때 사용합니다.
- heapq.heapreplace(heap, item): heap에 item을 넣고, 가장 작은 원소를 제거 및 반환합니다. heappushpop과 비슷하나 동작 순서가 반대입니다.
- heapq.nsmallest(n, iterable[, key]): iterable에서 n개의 가장 작은 원소를 리스트로 반환합니다.
- heapq.nlargest(n, iterable[, key]): iterable에서 n개의 가장 큰 원소를 리스트로 반환합니다.
- heapq.merge(*iterables): 여러 정렬된 iterator를 하나의 정렬된 시퀀스로 병합합니다(iterator 반환).
- heapq를 사용해 최대 힙(max-heap)을 구현하고 싶을 땐 값에 -1을 곱해 저장·추출하는 방식으로 사용합니다.

heapq를 사용하면 일반 리스트보다 훨씬 빠르게 최소/최대값을 효율적으로 처리할 수 있습니다.
"""

def solution_heapq(scoville, K):
    heapq.heapify(scoville)
    cnt = 0

    while len(scoville) > 1:
        first = heapq.heappop(scoville)
        if first >= K:
            heapq.heappush(scoville, first)
            break
        second = heapq.heappop(scoville)
        new_val = first + second * 2
        heapq.heappush(scoville, new_val)
        cnt += 1

    return cnt if scoville and scoville[0] >= K else -1









import heapq as hq
def solution(scoville, K):
    hq.heapify(scoville)
    result = 0
    while len(scoville) > 1:
        first = hq.heappop(scoville)
        if first >= K:
            hq.heappush(scoville, first)
            break
        second = hq.heappop(scoville)
        mix = first + second * 2
        hq.heappush(scoville, mix)
        result += 1
    return result if scoville and scoville[0] >= K else -1






import heapq as hq
def solution(scoville, K):
    hq.heapify(scoville)
    result = 0
    
    while len(scoville) > 1:
        first = hq.heappop(scoville)
        if first >= K:
            hq.heappush(scoville, first)
            break
        
        second = hq.heappop(scoville)
        mix = first + second * 2
        hq.heappush(scoville, mix)
        result += 1
    return result if scoville and scoville[0] >= K else -1

print(solution([1, 2, 3, 9, 10, 12], 7))  # 2
