from collections import deque
from importlib import import_module

# 알고리즘 유형: LRU(Least Recently Used) 캐시 알고리즘
# @Day 1
def solution(cacheSize, cities):
    dq = deque([''] * cacheSize)
    result = 0
    if not dq:
        return len(cities) * 5
    for c in cities:
        if c.upper() in dq:
            result += 1
            dq.remove(c.upper())
            dq.append(c.upper()) 
        else:
            result += 5
            dq.popleft()
            dq.append(c.upper()) 
    return result


# @Day 2
from collections import deque
def solution(cacheSize, cities):
    result = 0
    cache = deque()
    if not cacheSize:
        return 5 * len(cities)
    for c in cities:
        if c.upper() in cache:
            cache.remove(c.upper())
            cache.append(c.upper())
            result += 1
        else:
            if len(cache) == cacheSize:
                cache.popleft()
            cache.append(c.upper())
            result += 5
    return result

print(solution(2, ["test", "test"]))