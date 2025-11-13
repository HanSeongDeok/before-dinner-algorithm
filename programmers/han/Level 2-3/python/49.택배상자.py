from collections import deque
def solution(order):
    answer = 0
    order_dq = deque(order)
    save = deque()
    idx = 1
    while order_dq: 
        if save and order_dq[0] == save[0]:
            answer += 1
            order_dq.popleft()
            save.popleft()

        elif order_dq[0] == idx:
            answer += 1
            order_dq.popleft()
            idx += 1
        
        elif idx <= len(order): 
            save.appendleft(idx)
            idx += 1
        
        else:
            break
    return answer


# @ Day2
from collections import deque
def solution(order):
    box_dq = deque(order)
    save_dq = deque()

    idx = 1
    result = 0
    while box_dq:
        if idx > len(order) + 1:
            break

        if box_dq[0] == idx:
            box_dq.popleft()
            result += 1
            idx += 1

        elif save_dq and save_dq[0] == box_dq[0]:
            box_dq.popleft()
            save_dq.popleft()
            result += 1

        else:
            save_dq.appendleft(idx)
            idx += 1
    return result

print(solution([4, 3, 1, 2, 5]))
print(solution([5, 4, 3, 2, 1]))