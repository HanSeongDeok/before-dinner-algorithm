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

print(solution([4, 3, 1, 2, 5]))
print(solution([5, 4, 3, 2, 1]))