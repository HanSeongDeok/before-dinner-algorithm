def solution(citations):
    citations = sorted(citations, reverse=True)
    for i, v in enumerate(citations):
        index = i + 1
        if index > v:
            return i
    return len(citations)

print(solution([3, 0, 6, 1, 5]))