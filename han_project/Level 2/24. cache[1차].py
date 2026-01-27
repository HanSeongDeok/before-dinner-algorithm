def solution(cacheSize, cities):
    answer = 0
    deque = [""] * cacheSize
    for i in cities:
        i = i.upper()
        if i not in deque and len(deque) > 0:
            deque.pop(0)
            deque.append(i)
            answer += 5
        elif i in deque:
            deque.pop(deque.index(i))
            deque.append(i)
            answer += 1
        else:
            answer += 5
    return answer

print(solution(3, ["Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"]))